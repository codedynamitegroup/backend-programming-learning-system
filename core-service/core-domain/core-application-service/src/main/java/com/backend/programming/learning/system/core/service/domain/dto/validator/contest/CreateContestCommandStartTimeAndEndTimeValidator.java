package com.backend.programming.learning.system.core.service.domain.dto.validator.contest;


import com.backend.programming.learning.system.core.service.domain.dto.validator.implement.certificatecourse.CreateCertificateCourseCommandStartTimeAndEndTimeValidatorImpl;
import com.backend.programming.learning.system.core.service.domain.dto.validator.implement.contest.CreateContestCommandStartTimeAndEndTimeValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CreateContestCommandStartTimeAndEndTimeValidatorImpl.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateContestCommandStartTimeAndEndTimeValidator {
    String message() default "Start time should not be greater than or equal to end time.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}


