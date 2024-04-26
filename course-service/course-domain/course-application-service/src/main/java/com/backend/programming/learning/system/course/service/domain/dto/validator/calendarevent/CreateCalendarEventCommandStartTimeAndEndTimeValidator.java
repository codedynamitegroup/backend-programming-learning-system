package com.backend.programming.learning.system.course.service.domain.dto.validator.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.validator.implement.calendarevent.CreateCalendarEventCommandStartTimeAndEndTimeValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CreateCalendarEventCommandStartTimeAndEndTimeValidatorImpl.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateCalendarEventCommandStartTimeAndEndTimeValidator {
    String message() default "Start time should not be greater than or equal to end time.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}


