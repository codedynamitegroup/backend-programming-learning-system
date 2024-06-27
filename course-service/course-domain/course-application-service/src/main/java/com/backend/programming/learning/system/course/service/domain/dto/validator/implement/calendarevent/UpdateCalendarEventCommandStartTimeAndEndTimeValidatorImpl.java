package com.backend.programming.learning.system.course.service.domain.dto.validator.implement.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.calendarevent.UpdateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.validator.calendarevent.CreateCalendarEventCommandStartTimeAndEndTimeValidator;
import com.backend.programming.learning.system.course.service.domain.dto.validator.calendarevent.UpdateCalendarEventCommandStartTimeAndEndTimeValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UpdateCalendarEventCommandStartTimeAndEndTimeValidatorImpl implements ConstraintValidator<
        UpdateCalendarEventCommandStartTimeAndEndTimeValidator, UpdateCalendarEventCommand> {
    @Override
    public void initialize(UpdateCalendarEventCommandStartTimeAndEndTimeValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(UpdateCalendarEventCommand updateCalendarEventCommand,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (updateCalendarEventCommand.getEndTime() == null) {
            return true;
        }

        return updateCalendarEventCommand.getStartTime().isBefore(updateCalendarEventCommand.getEndTime());
    }
}
