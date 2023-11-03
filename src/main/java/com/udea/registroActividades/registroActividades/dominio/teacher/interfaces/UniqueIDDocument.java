package com.udea.registroActividades.registroActividades.dominio.teacher.interfaces;

import com.udea.registroActividades.registroActividades.dominio.teacher.validations.UniqueEmailValidator;
import com.udea.registroActividades.registroActividades.dominio.teacher.validations.UniqueIDDocumentValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueIDDocumentValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueIDDocument {
    String message() default "The document number already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
