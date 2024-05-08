package com.backend.programming.learning.system.core.service.domain.dto.validator.implement.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.validator.certificatecourse.UpdateCertificateCourseCommandStartTimeAndEndTimeValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

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
