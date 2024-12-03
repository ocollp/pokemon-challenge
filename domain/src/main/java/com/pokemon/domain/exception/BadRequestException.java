package com.pokemon.domain.exception;

import com.pokemon.domain.shared.dto.ErrorReasonDTO;
import com.pokemon.domain.shared.enums.ErrorEnum;

import java.util.List;

public final class BadRequestException extends DomainException {

    private static final long serialVersionUID = 913818516943971463L;

    public BadRequestException(final String code, final String message) {
        super(code, 400, message);
    }

    public BadRequestException(final ErrorEnum errorEnum) {
        super(errorEnum.getCode(), 400, errorEnum.getMessage());
    }

    public BadRequestException(final String code, final String message, final List<ErrorReasonDTO> data) {
        super(code, 400, message, data);
    }
}