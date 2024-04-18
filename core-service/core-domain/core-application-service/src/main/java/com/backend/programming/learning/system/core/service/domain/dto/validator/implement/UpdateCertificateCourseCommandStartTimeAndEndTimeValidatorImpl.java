package com.backend.programming.learning.system.core.service.domain.dto.validator.implement;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.validator.CreateCertificateCourseCommandStartTimeAndEndTimeValidator;
import com.backend.programming.learning.system.core.service.domain.dto.validator.UpdateCertificateCourseCommandStartTimeAndEndTimeValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpdateCertificateCourseCommandStartTimeAndEndTimeValidatorImpl implements ConstraintValidator<
        UpdateCertificateCourseCommandStartTimeAndEndTimeValidator, UpdateCertificateCourseCommand> {
    @Override
    public void initialize(UpdateCertificateCourseCommandStartTimeAndEndTimeValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(UpdateCertificateCourseCommand updateCertificateCourseCommand,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (updateCertificateCourseCommand.getEndTime() == null) {
            return true;
        }

        return updateCertificateCourseCommand.getStartTime().isBefore(updateCertificateCourseCommand.getEndTime());
    }
}
