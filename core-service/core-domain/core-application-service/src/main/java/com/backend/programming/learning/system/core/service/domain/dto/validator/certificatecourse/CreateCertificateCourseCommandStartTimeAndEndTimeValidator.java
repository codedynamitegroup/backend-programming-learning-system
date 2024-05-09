package com.backend.programming.learning.system.core.service.domain.dto.validator.certificatecourse;


import com.backend.programming.learning.system.core.service.domain.dto.validator.implement.certificatecourse.CreateCertificateCourseCommandStartTimeAndEndTimeValidatorImpl;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CreateCertificateCourseCommandStartTimeAndEndTimeValidatorImpl.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateCertificateCourseCommandStartTimeAndEndTimeValidator {
    String message() default "Start time should not be greater than or equal to end time.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}


