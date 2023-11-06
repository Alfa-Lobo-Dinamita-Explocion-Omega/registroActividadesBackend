package com.udea.registroActividades.registroActividades.validation.unique;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
    String message() default "The value already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    UniqueFields field();
}

