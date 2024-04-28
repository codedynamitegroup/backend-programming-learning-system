package com.backend.programming.learning.system.code.assessment.service.domain.implement.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Slf4j
public class GenericHelper {
    //not use for objects that have final field(s)
    public <T> void mapNullAttributeToRepositoryAttribute(T nullAttributeObject, T repositoryObject, Class<T> tClass){
        Field[] fields = tClass.getDeclaredFields();
        for(Field field: fields){
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
    }
}
