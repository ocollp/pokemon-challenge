package com.pokemon.domain.exception;

import com.pokemon.domain.shared.dto.ErrorReasonDTO;

import java.util.ArrayList;
import java.util.List;

public class DomainException extends Exception {

    private static final long serialVersionUID = 6173659257108201607L;

    private final String code;

    private final int responseCode;

    private final List<ErrorReasonDTO> errorReasons = new ArrayList<>();

    public DomainException(final String code, final int responseCode, final String message) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
    }

    public DomainException(final String code, final int responseCode, final String message, final List<ErrorReasonDTO> errorReasons) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.errorReasons.addAll(errorReasons);
    }

    public String getCode() {
        return this.code;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public List<ErrorReasonDTO> getErrorReasons() {
        return errorReasons;
    }
}