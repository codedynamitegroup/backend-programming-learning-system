package com.backend.programming.learning.system.core.service.domain.dto.validator.implement.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.validator.certificatecourse.CreateCertificateCourseCommandStartTimeAndEndTimeValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateCertificateCourseCommandStartTimeAndEndTimeValidatorImpl implements ConstraintValidator<
        CreateCertificateCourseCommandStartTimeAndEndTimeValidator, CreateCertificateCourseCommand> {
    @Override
    public void initialize(CreateCertificateCourseCommandStartTimeAndEndTimeValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateCertificateCourseCommand createCertificateCourseCommand,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (createCertificateCourseCommand.getEndTime() == null) {
            return true;
        }

        return createCertificateCourseCommand.getStartTime().isBefore(createCertificateCourseCommand.getEndTime());
    }
}
