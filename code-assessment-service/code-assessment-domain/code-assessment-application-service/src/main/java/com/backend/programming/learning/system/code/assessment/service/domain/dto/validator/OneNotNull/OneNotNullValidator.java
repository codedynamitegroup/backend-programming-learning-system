package com.backend.programming.learning.system.code.assessment.service.domain.dto.validator.OneNotNull;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

@Component
public class OneNotNullValidator implements ConstraintValidator<OneNotNull, Object> {
    private String[] fields;

    @Override
    public void initialize(final OneNotNull combinedNotNull) {
        fields = combinedNotNull.fields() != null && combinedNotNull.fields().length > 0?
                combinedNotNull.fields():
                combinedNotNull.clazz() == null? null :
                Arrays.stream(combinedNotNull.clazz().getClass().getDeclaredFields()).map(Field::getName).toList().toArray(new String[0]);
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(obj);
        if(fields == null || fields.length < 1)
            return true;
        return Arrays.stream(fields)
                .map(beanWrapper::getPropertyValue)
                .anyMatch(Objects::nonNull);
    }
}