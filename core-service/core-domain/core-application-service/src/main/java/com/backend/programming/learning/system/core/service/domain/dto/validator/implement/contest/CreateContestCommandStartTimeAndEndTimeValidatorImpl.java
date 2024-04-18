package com.backend.programming.learning.system.core.service.domain.dto.validator.implement.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.validator.certificatecourse.CreateCertificateCourseCommandStartTimeAndEndTimeValidator;
import com.backend.programming.learning.system.core.service.domain.dto.validator.contest.CreateContestCommandStartTimeAndEndTimeValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateContestCommandStartTimeAndEndTimeValidatorImpl implements ConstraintValidator<
        CreateContestCommandStartTimeAndEndTimeValidator, CreateContestCommand> {
    @Override
    public void initialize(CreateContestCommandStartTimeAndEndTimeValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateContestCommand createContestCommand,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (createContestCommand.getEndTime() == null) {
            return true;
        }

        return createContestCommand.getStartTime().isBefore(createContestCommand.getEndTime());
    }
}
