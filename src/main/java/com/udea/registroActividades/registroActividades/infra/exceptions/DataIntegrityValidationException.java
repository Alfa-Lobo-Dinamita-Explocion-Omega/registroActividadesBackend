package com.udea.registroActividades.registroActividades.infra.exceptions;

import java.util.List;

import lombok.Getter;

@Getter
public class DataIntegrityValidationException extends RuntimeException {
    private List<CustomValidationException> validationExceptions;
    public DataIntegrityValidationException(List<CustomValidationException> exceptions) {
        this.validationExceptions = exceptions;
    }
}

