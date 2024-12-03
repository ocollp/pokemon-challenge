package com.pokemon.application.rest.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.pokemon.application.rest.dto.ErrorDTO;
import com.pokemon.application.rest.dto.ErrorReasonDTO;
import com.pokemon.domain.exception.DomainException;
import com.pokemon.domain.shared.enums.ErrorEnum;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String ERROR = "errorCode";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(final Exception exception) {
        log.error("ERROR " + ExceptionUtils.getStackTrace(exception));
        log.error("ERROR " + exception.getMessage());
        MDC.put(ERROR, ErrorEnum.INTERNAL_SERVER_ERROR.getCode());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorDTO.builder().error(ErrorEnum.INTERNAL_SERVER_ERROR.getCode()).errorDescription(ErrorEnum.INTERNAL_SERVER_ERROR.getMessage()).build());
    }

    @SuppressWarnings("unchecked")
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorDTO> handleDomainException(final DomainException exception) {
        log.error("ERROR " + exception.getMessage());
        MDC.put(ERROR, ErrorEnum.INVALID_REQUEST_PARAMETERS.getCode());
        return ResponseEntity.status(exception.getResponseCode()).body(ErrorDTO.builder().error(exception.getCode()).errorDescription(exception.getMessage()).errorReasons((List<ErrorReasonDTO>) (List<?>) exception.getErrorReasons()).build());
    }

    @ExceptionHandler({FeignException.class})
    @ResponseBody
    public ResponseEntity<ErrorDTO> feignHandler(final HttpServletRequest req, final HttpServletResponse response, final FeignException ex) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        try {
            final ErrorDTO feignError = mapper.readValue(ex.contentUTF8(), new TypeReference<>() {
            });
            log.error("ERROR: " + feignError);
            MDC.put(ERROR, feignError.getError());
            return ResponseEntity.status(ex.status()).body(feignError);
        } catch (final IOException e) {
            log.error("ERROR parsing: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorDTO.builder().error(ErrorEnum.INTERNAL_SERVER_ERROR.getCode()).errorDescription(ErrorEnum.INTERNAL_SERVER_ERROR.getMessage()).build());
        }
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(final HttpServletRequest request, final HttpServletResponse response, final MethodArgumentNotValidException exception) {
        final BindingResult result = exception.getBindingResult();
        final List<ErrorReasonDTO> errorList = result.getFieldErrors().stream().map(error -> ErrorReasonDTO.builder().name(error.getField()).value(error.getRejectedValue()).message(error.getDefaultMessage()).build()).collect(Collectors.toList());
        log.error("ERROR " + exception.getMessage());
        MDC.put(ERROR, ErrorEnum.INVALID_REQUEST_PARAMETERS.getCode());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDTO.builder().error(ErrorEnum.INVALID_REQUEST_PARAMETERS.getCode()).errorDescription(ErrorEnum.INVALID_REQUEST_PARAMETERS.getMessage()).errorReasons(errorList).build());
    }

    @ExceptionHandler({MissingRequestHeaderException.class})
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleMissingRequestHeaderException(final HttpServletRequest request, final HttpServletResponse response, final MissingRequestHeaderException exception) {
        log.error("ERROR " + exception.getMessage());
        final String headerName = exception.getHeaderName();
        MDC.put(ERROR, ErrorEnum.MISSING_HEADER.getCode());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDTO.builder().error(ErrorEnum.MISSING_HEADER.getCode()).errorDescription(String.format(ErrorEnum.MISSING_HEADER.getMessage(), headerName)).build());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleInvalidFormatException(final HttpServletRequest request, final HttpServletResponse response, final HttpMessageNotReadableException exception) {
        log.error("ERROR " + exception.getMessage());
        MDC.put(ERROR, ErrorEnum.INVALID_BODY_REQUEST.getCode());
        InvalidFormatException invalidFormatException = (InvalidFormatException) exception.getCause();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDTO.builder().error(ErrorEnum.INVALID_BODY_REQUEST.getCode()).errorDescription(String.format(ErrorEnum.INVALID_BODY_REQUEST.getMessage(), invalidFormatException.getPath().get(0).getFieldName(), invalidFormatException.getValue())).build());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleForbiddenException(final AccessDeniedException exception) {
        MDC.put(ERROR, ErrorEnum.FORBIDDEN.getCode());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ErrorDTO.builder().error(ErrorEnum.FORBIDDEN.getCode()).errorDescription(exception.getMessage()).build());
    }
}
