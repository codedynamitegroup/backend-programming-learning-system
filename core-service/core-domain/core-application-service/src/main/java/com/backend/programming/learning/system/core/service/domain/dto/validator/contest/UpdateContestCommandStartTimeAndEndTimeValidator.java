package com.backend.programming.learning.system.core.service.domain.dto.validator.contest;


import com.backend.programming.learning.system.core.service.domain.dto.validator.implement.certificatecourse.UpdateCertificateCourseCommandStartTimeAndEndTimeValidatorImpl;
import com.backend.programming.learning.system.core.service.domain.dto.validator.implement.contest.UpdateContestCommandStartTimeAndEndTimeValidatorImpl;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UpdateContestCommandStartTimeAndEndTimeValidatorImpl.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UpdateContestCommandStartTimeAndEndTimeValidator {
    String message() default "Start time should not be greater than or equal to end time.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}


