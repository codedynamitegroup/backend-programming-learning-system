package com.backend.programming.learning.system.code.assessment.service.domain.dto.validator.OneNotNull;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = OneNotNullValidator.class)
public @interface OneNotNull {
    String message() default "One of the fields must not be null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Fields to validate against null.
     */
    String[] fields() default {};
    Class<?>[] clazz() default {};
}