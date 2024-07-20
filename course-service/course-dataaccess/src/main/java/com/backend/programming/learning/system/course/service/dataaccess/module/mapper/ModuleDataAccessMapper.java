package com.backend.programming.learning.system.course.service.dataaccess.module.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam.mapper.ExamDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.module.entity.ModuleEntity;
import com.backend.programming.learning.system.course.service.dataaccess.section.entity.SectionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.section.mapper.SectionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
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
    private final ExamDataAccessMapper examDataAccessMapper;

    public ModuleEntity moduleToModuleEntity(Module module) {
        SectionEntity section = sectionDataAccessMapper.sectionToSectionEntity(module.getSection());

        return ModuleEntity.builder()
                .id(module.getId().getValue())
                .assignment(module.getAssignment() == null ? null : assignmentDataAccessMapper.assignmentToAssignmentEntity(module.getAssignment()))
                .exam(module.getExam() == null ? null : examDataAccessMapper.examToExamEntity(module.getExam()))
                .cmid(module.getCmid())
                .typeModule(module.getTypeModule())
                .section(section)
                .build();
    }

    public Module moduleEntityToModule(ModuleEntity moduleEntity) {
        return Module.builder()
                .id(new ModuleId(moduleEntity.getId()))
                .assignment(moduleEntity.getAssignment() == null ? null : assignmentDataAccessMapper.assignmentEntityToAssignment(moduleEntity.getAssignment()))
                .cmid(moduleEntity.getCmid())
                .typeModule(moduleEntity.getTypeModule())
                .exam(moduleEntity.getExam() == null ? null : examDataAccessMapper.examEntityToExam(moduleEntity.getExam()))
                .section(sectionDataAccessMapper.sectionEntityToSection(moduleEntity.getSection()))
                .build();

    }

    public List<Module> moduleEntityListToModuleList(List<ModuleEntity> bySectionId) {
        return bySectionId.stream().map(this::moduleEntityToModule).toList();
    }
}
