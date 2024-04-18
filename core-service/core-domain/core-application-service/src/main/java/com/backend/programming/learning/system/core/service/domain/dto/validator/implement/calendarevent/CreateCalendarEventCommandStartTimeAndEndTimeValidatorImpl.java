package com.backend.programming.learning.system.core.service.domain.dto.validator.implement.calendarevent;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.validator.calendarevent.CreateCalendarEventCommandStartTimeAndEndTimeValidator;
import com.backend.programming.learning.system.core.service.domain.dto.validator.certificatecourse.CreateCertificateCourseCommandStartTimeAndEndTimeValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateCalendarEventCommandStartTimeAndEndTimeValidatorImpl implements ConstraintValidator<
        CreateCalendarEventCommandStartTimeAndEndTimeValidator, CreateCalendarEventCommand> {
    @Override
    public void initialize(CreateCalendarEventCommandStartTimeAndEndTimeValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateCalendarEventCommand createCalendarEventCommand,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (createCalendarEventCommand.getEndTime() == null) {
            return true;
        }

        return createCalendarEventCommand.getStartTime().isBefore(createCalendarEventCommand.getEndTime());
    }
}
