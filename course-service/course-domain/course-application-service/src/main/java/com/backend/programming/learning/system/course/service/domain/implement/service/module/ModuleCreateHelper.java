package com.backend.programming.learning.system.course.service.domain.implement.service.module;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module.ModuleDetailResponse;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.module.ModuleDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ModuleRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ModuleCreateHelper {

    private final CourseDomainService courseDomainService;
    private final ModuleDataMapper moduleDataMapper;
    private final CourseRepository courseRepository;
    private final MoodleCommandHandler moodleCommandHandler;

    private final ModuleRepository moduleRepository;
    private final AssignmentRepository assignmentRepository;
    private final SectionRepository sectionRepository;


    public ModuleCreateHelper(CourseDomainService courseDomainService, ModuleDataMapper moduleDataMapper, CourseRepository courseRepository, MoodleCommandHandler moodleCommandHandler, ModuleRepository moduleRepository, AssignmentRepository assignmentRepository, SectionRepository sectionRepository) {
        this.courseDomainService = courseDomainService;
        this.moduleDataMapper = moduleDataMapper;
        this.courseRepository = courseRepository;
        this.moodleCommandHandler = moodleCommandHandler;
        this.moduleRepository = moduleRepository;
        this.assignmentRepository = assignmentRepository;
        this.sectionRepository = sectionRepository;
    }


    @Transactional
    public Module createModule(CreateModuleCommand createModuleCommand) {
        Module module = moduleDataMapper.createModuleCommandToModule(createModuleCommand);
        courseDomainService.createModule(module);
        Module createResult = moduleRepository.save(module);
        log.info("Module is created with id: {}", createResult.getId());
        return createResult;
    }

    @Transactional
    public Boolean createModule(WebhookMessage webhookMessage, Organization organization) {
        String apiKey = organization.getApiKey();
        String moodleUrl = organization.getMoodleUrl();


        ModuleDetailResponse moduleDetailResponse = moodleCommandHandler.
                getModuleDetail(webhookMessage.getObjectId(), apiKey, moodleUrl);
        if(moduleDetailResponse.getCm()==null)
            return false;
        Optional<Course> course = courseRepository.findByCourseIdMoodle(moduleDetailResponse.getCm().getCourse());

        if(moduleDetailResponse.getCm().getModname().equals("assign")){
            List<AssignmentCourseModel> assignmentCourseModels = moodleCommandHandler.getAllAssignments(moduleDetailResponse.getCm().getCourse().toString(),apiKey,moodleUrl);
            List<AssignmentModel> assignmentModels = assignmentCourseModels.get(0).getAssignments();
            moodleCommandHandler.createAssignment(assignmentModels,course.get(),moduleDetailResponse.getCm().getInstance());
        }


        Optional<Assignment> assignment = assignmentRepository.findByAssignmentIdMoodle(moduleDetailResponse.getCm().getInstance());
        Optional<Section> section = sectionRepository.findBySectionMoodleIdAndCourseId(moduleDetailResponse.getCm().getSection(),course.get().getId().getValue());
        if (assignment.isPresent() && section.isPresent()) {
            Module module = moduleDataMapper.moduleDetailResponseToModule(moduleDetailResponse, section.get(), assignment.get());
            courseDomainService.createModule(module);
            Module createResult = moduleRepository.save(module);
            log.info("Module is created with id: {}", createResult.getId());
            return true;
        }
        return false;
    }
}
