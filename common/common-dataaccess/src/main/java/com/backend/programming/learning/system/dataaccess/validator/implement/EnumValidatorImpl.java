package com.backend.programming.learning.system.dataaccess.validator.implement;

import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {

    Set<String> valueList;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return true;
        return valueList.contains(value.toUpperCase());
    }

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        valueList = Stream.of(constraintAnnotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }

}
