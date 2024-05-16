package com.backend.programming.learning.system.code.assessment.service.domain.implement.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
@Slf4j
public class GenericHelper {

    public <T> T mapRepositoryAttributeToUpdateAttribute(T repositoryObject, T updatedObject, Class<T> tClass){
        List<Field> parentClassField = Arrays.asList(tClass.getSuperclass().getDeclaredFields());
        List<Field> classField = Arrays.asList(tClass.getDeclaredFields());
        List<Field> allFields = Stream.concat(parentClassField.stream(), classField.stream()).toList();
        for(Field field: allFields){
            field.setAccessible(true);
            try {
                Object updatedObjectField = field.get(updatedObject);

                if(updatedObjectField != null)
                    field.set(repositoryObject, updatedObjectField);

            } catch (IllegalAccessException e) {
                log.error("Can not copy attribute {} of object of {} class", field.getName(), tClass.getName());
            }
            field.setAccessible(false);
        }
        return repositoryObject;
    }
}
