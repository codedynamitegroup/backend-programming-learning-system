package com.backend.programming.learning.system.course.service.dataaccess.role_moodle.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.entity.RoleMoodleEntity;
import com.backend.programming.learning.system.course.service.domain.entity.RoleMoodle;
import com.backend.programming.learning.system.course.service.domain.valueobject.RoleMoodleId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class RoleMoodleDataAccessMapper {

    public RoleMoodleEntity roleMoodleToRoleMoodleEntity(RoleMoodle roleMoodle) {
        if(Objects.isNull(roleMoodle)) return null;
        return RoleMoodleEntity.builder()
                .id(roleMoodle.getId().getValue())
                .name(roleMoodle.getName())
                .build();
    }

    public RoleMoodle roleMoodleEntityToRoleMoodle(RoleMoodleEntity roleMoodleEntity) {
        return RoleMoodle.builder()
                .id(new RoleMoodleId(roleMoodleEntity.getId()))
                .name(roleMoodleEntity.getName())
                .build();
    }

    public List<RoleMoodle> roleMoodleToRoleMoodleEntityList(List<RoleMoodleEntity> roleMoodleList) {
        return roleMoodleList.stream()
                .map(this::roleMoodleEntityToRoleMoodle)
                .toList();
    }
}