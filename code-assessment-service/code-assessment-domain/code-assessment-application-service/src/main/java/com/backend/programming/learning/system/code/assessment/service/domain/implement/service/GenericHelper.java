package com.backend.programming.learning.system.code.assessment.service.domain.implement.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class GenericHelper {
    //not use for objects that have final field(s)
    public <T> T mapNullAttributeToRepositoryAttribute(T nullAttributeObject, T repositoryObject, Class<T> tClass){
        List<Field> parentClassField = Arrays.asList(tClass.getSuperclass().getDeclaredFields());
        List<Field> classField = Arrays.asList(tClass.getDeclaredFields());
        List<Field> allFields = Stream.concat(parentClassField.stream(), classField.stream()).toList();
        for(Field field: allFields){
            field.setAccessible(true);
            try {
                Object nullAttributeObjectField = field.get(nullAttributeObject);
                Object repositoryObjectField = field.get(repositoryObject);

                if(nullAttributeObjectField == null)
                    field.set(nullAttributeObject, repositoryObjectField);
            } catch (IllegalAccessException e) {
                log.error("Can not copy attribute {} of object of {} class", field.getName(), repositoryObject.getClass().getName());
            }
            field.setAccessible(false);
        }
        return nullAttributeObject;
    }
}
