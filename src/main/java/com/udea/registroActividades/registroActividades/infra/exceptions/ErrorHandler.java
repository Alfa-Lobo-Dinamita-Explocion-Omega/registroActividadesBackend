package com.udea.registroActividades.registroActividades.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlerEntityNotFoundException(){
        return ResponseEntity.notFound().build();
    }


    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity handlerSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler( DataIntegrityValidationException.class)
    public ResponseEntity  handlerDataIntegrityValidationException( DataIntegrityValidationException e) {
        var errors = e.getValidationExceptions().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
    }


    private record DatosErrorValidacion(String field, String error){
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }

        public DatosErrorValidacion(CustomValidationException e) {
            this(e.getField(), e.getMessage());
        }
    }
}
