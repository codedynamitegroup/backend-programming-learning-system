package com.backend.programming.learning.system.code.assessment.service.domain.dto.validator.OneNotNull;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class OneNotNullValidator implements ConstraintValidator<OneNotNull, Object> {
    private String[] fields;

    @Override
    public void initialize(final OneNotNull combinedNotNull) {
        fields = combinedNotNull.fields();
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(obj);

        return Arrays.stream(fields)
                .map(beanWrapper::getPropertyValue)
                .anyMatch(Objects::nonNull);
    }
}