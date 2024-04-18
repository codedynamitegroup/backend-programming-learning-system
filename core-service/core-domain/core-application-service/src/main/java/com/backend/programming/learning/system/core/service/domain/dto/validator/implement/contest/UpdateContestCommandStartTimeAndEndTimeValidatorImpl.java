package com.backend.programming.learning.system.core.service.domain.dto.validator.implement.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.validator.certificatecourse.UpdateCertificateCourseCommandStartTimeAndEndTimeValidator;
import com.backend.programming.learning.system.core.service.domain.dto.validator.contest.UpdateContestCommandStartTimeAndEndTimeValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpdateContestCommandStartTimeAndEndTimeValidatorImpl implements ConstraintValidator<
        UpdateContestCommandStartTimeAndEndTimeValidator, UpdateContestCommand> {
    @Override
    public void initialize(UpdateContestCommandStartTimeAndEndTimeValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(UpdateContestCommand updateContestCommand,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (updateContestCommand.getEndTime() == null) {
            return true;
        }

        return updateContestCommand.getStartTime().isBefore(updateContestCommand.getEndTime());
    }
}
