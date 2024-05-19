package com.backend.programming.learning.system.course.service.dataaccess.role_moodle.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.entity.RoleMoodleEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.RoleMoodle;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.RoleMoodleId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleMoodleDataAccessMapper {

    public RoleMoodleEntity roleMoodleToRoleMoodleEntity(RoleMoodle roleMoodle) {
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