package com.backend.programming.learning.system.course.service.domain.mapper.module;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateExamModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.module.QueryAllModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.module.UpdateModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.module.ModuleResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module.ModuleDetailResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module.ModuleModel;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.mapper.assignment.AssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.exam.ExamDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SectionRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.course.service.domain.valueobject.TypeModule;
import org.springframework.stereotype.Component;
import com.backend.programming.learning.system.course.service.domain.entity.Module;

import java.util.List;
import java.util.Optional;

@Component

public class ModuleDataMapper {
   private final SectionRepository sectionRepository;
   private final ExamRepository examRepository;
   private final AssignmentRepository assignmentRepository;
   private final ExamDataMapper examDataMapper;
   private final AssignmentDataMapper assignmentDataMapper;

    public ModuleDataMapper(SectionRepository sectionRepository, ExamRepository examRepository, AssignmentRepository assignmentRepository, ExamDataMapper examDataMapper, AssignmentDataMapper assignmentDataMapper) {
        this.sectionRepository = sectionRepository;
        this.examRepository = examRepository;
        this.assignmentRepository = assignmentRepository;
        this.examDataMapper = examDataMapper;
        this.assignmentDataMapper = assignmentDataMapper;
    }

    public Module moduleModelToModule(ModuleModel moduleModel, Section section) {
        return Module.builder()
                .section(section)
                .typeModule(TypeModule.fromLabel(moduleModel.getModplural()))
                .build();
    }

    public Module createModuleCommandToModule(CreateModuleCommand createModuleCommand) {
        Optional<Section> section = sectionRepository.findById(createModuleCommand.getSectionId());
        if (section.isEmpty()) {
            throw new CourseDomainException("Section is not found with id: " + createModuleCommand.getSectionId());
        }
        Assignment assignmentResult = null;
        Exam examResult=null;
        if(createModuleCommand.getType().equals("ASSIGNMENT"))
        {
            Optional<Assignment> assignment =assignmentRepository.findById(createModuleCommand.getAssignmentId());
            assignmentResult=assignment.get();
        }
        else if(createModuleCommand.getType().equals("QUIZ"))
        {
            Exam exam =examRepository.findBy(new ExamId(createModuleCommand.getExamId()));
            examResult=exam;
        }
        return Module.builder()
                .section(section.get())
                .cmid(createModuleCommand.getCmid())
                .assignment(assignmentResult)
                .exam(examResult)
                .typeModule(TypeModule.fromLabel(createModuleCommand.getType()))
                .build();
    }

    public CreateModuleResponse moduleToCreateModuleResponse(Module module,String message) {
        return CreateModuleResponse.builder()
                .sectionId(module.getSection().getId().getValue())
                .message(message)
                .build();
    }

    public UpdateModuleResponse moduleToUpdateModuleResponse(Module module, String moduleIsUpdatedSuccessfully) {
        return UpdateModuleResponse.builder()
                .sectionId(module.getSection().getId().getValue())
                .message(moduleIsUpdatedSuccessfully)
                .build();
    }


    public ModuleResponseEntity moduleToModuleResponseEntity(Module module) {
        return ModuleResponseEntity.builder()
                .moduleId(module.getId().getValue())
                .assignment(module.getAssignment() == null ? null : assignmentDataMapper.assignmentToAssignmentResponseEntity(module.getAssignment()))
                .exam(module.getExam() == null ? null : examDataMapper.examToExamResponseEntity(module.getExam()))
                .typeModule(module.getTypeModule().getLabel())
                .build();
    }

    public QueryAllModuleResponse modulesToQueryAllModuleResponse(List<Module> modules) {
        return QueryAllModuleResponse.builder()
                .sectionId(modules.get(0).getSection().getId().getValue())
                .modules(modules.stream().map(this::moduleToModuleResponseEntity).toList())
                .build();
    }

    public Module moduleDetailResponseToModule(ModuleDetailResponse moduleDetailResponse, Section section, Assignment assignment) {
        String typeModule = moduleDetailResponse.getCm().getModname();
        if(typeModule.equals("assign"))
            typeModule="ASSIGNMENT";
        return Module.builder()
                .section(section)
                .cmid(moduleDetailResponse.getCm().getId())
                .assignment(assignment)
                .typeModule(TypeModule.valueOf(typeModule))
                .build();
    }

    public Module createExamModuleCommandToModule(CreateExamModuleCommand createExamModuleCommand) {
        Optional<Section> section = sectionRepository.findById(createExamModuleCommand.getSectionId());
        if (section.isEmpty()) {
            throw new CourseDomainException("Section is not found with id: " + createExamModuleCommand.getSectionId());
        }
        Exam exam = examRepository.findBy(new ExamId(createExamModuleCommand.getExamId()));
        return Module.builder()
                .section(section.get())
                .exam(exam)
                .typeModule(TypeModule.QUIZ)
                .build();
    }
}
