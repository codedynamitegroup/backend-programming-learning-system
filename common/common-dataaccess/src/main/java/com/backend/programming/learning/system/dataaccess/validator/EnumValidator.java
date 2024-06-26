package com.backend.programming.learning.system.dataaccess.validator;


import com.backend.programming.learning.system.dataaccess.validator.implement.EnumValidatorImpl;
import jakarta.validation.*;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface EnumValidator {

    Class<? extends Enum<?>> enumClass();

    String message() default "Invalid value. Value must be any of enum {enumClass}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}


