package com.backend.programming.learning.system.course.service.dataaccess.module.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.module.entity.ModuleEntity;
import com.backend.programming.learning.system.course.service.dataaccess.section.entity.SectionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.section.mapper.SectionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
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
    private final AssignmentDataAccessMapper assignmentDataAccessMapper;

    public ModuleEntity moduleToModuleEntity(Module module) {
        SectionEntity section = sectionDataAccessMapper.sectionToSectionEntity(module.getSection());
        AssignmentEntity assignment = assignmentDataAccessMapper.assignmentToAssignmentEntity(module.getAssignment());

        return ModuleEntity.builder()
                .id(module.getId().getValue())
                .assignment(assignment)
                .cmid(module.getCmid())
                .name(module.getName())
                .visible(module.getVisible())
                .section(section)
                .content(module.getContent())
                .typeModule(module.getTypeModule())
                .timeOpen(module.getTimeOpen())
                .timeClose(module.getTimeClose())
                .build();
    }

    public Module moduleEntityToModule(ModuleEntity moduleEntity) {
        Assignment assignment = assignmentDataAccessMapper.assignmentEntityToAssignment(moduleEntity.getAssignment());
        return Module.builder()
                .id(new ModuleId(moduleEntity.getId()))
                .assignment(assignment)
                .cmid(moduleEntity.getCmid())
                .name(moduleEntity.getName())
                .visible(moduleEntity.getVisible())
                .content(moduleEntity.getContent())
                .typeModule(moduleEntity.getTypeModule())
                .section(sectionDataAccessMapper.sectionEntityToSection(moduleEntity.getSection()))
                .timeOpen(moduleEntity.getTimeOpen())
                .timeClose(moduleEntity.getTimeClose())
                .build();

    }

    public List<Module> moduleEntityListToModuleList(List<ModuleEntity> bySectionId) {
        return bySectionId.stream().map(this::moduleEntityToModule).toList();
    }
}
