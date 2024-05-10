package com.backend.programming.learning.system.course.service.dataaccess.module.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.module.entity.ModuleEntity;
import com.backend.programming.learning.system.course.service.dataaccess.section.entity.SectionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.section.mapper.SectionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ModuleId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ModuleDataAccessMapper {

    private final SectionDataAccessMapper sectionDataAccessMapper;

    public ModuleEntity moduleToModuleEntity(Module module) {
        SectionEntity section = sectionDataAccessMapper.sectionToSectionEntity(module.getSection());
        return ModuleEntity.builder()
                .id(module.getId().getValue())
                .cmid(module.getCmid())
                .name(module.getName())
                .visible(module.getVisible())
                .section(section)
                .timeOpen(module.getTimeOpen())
                .timeClose(module.getTimeClose())
                .build();
    }

    public Module moduleEntityToModule(ModuleEntity moduleEntity) {
        return Module.builder()
                .id(new ModuleId(moduleEntity.getId()))
                .cmid(moduleEntity.getCmid())
                .name(moduleEntity.getName())
                .visible(moduleEntity.getVisible())
                .section(sectionDataAccessMapper.sectionEntityToSection(moduleEntity.getSection()))
                .timeOpen(moduleEntity.getTimeOpen())
                .timeClose(moduleEntity.getTimeClose())
                .build();

    }

    public List<Module> moduleEntityListToModuleList(List<ModuleEntity> bySectionId) {
        return bySectionId.stream().map(this::moduleEntityToModule).toList();
    }
}
