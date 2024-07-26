package com.backend.programming.learning.system.course.service.domain.implement.service.module;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.module.UpdateModuleCommand;
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
import java.util.UUID;

@Slf4j
@Component
public class ModuleUpdateHelper {
    private final CourseDomainService courseDomainService;
    private final ModuleDataMapper moduleDataMapper;
    private final CourseRepository courseRepository;
    private final MoodleCommandHandler moodleCommandHandler;
    private final AssignmentRepository assignmentRepository;

    private final SectionRepository sectionRepository;

    private final ModuleRepository moduleRepository;

    public ModuleUpdateHelper(CourseDomainService courseDomainService,
                              ModuleDataMapper moduleDataMapper,
                              CourseRepository courseRepository,
                              MoodleCommandHandler moodleCommandHandler,
                              AssignmentRepository assignmentRepository, SectionRepository sectionRepository, ModuleRepository moduleRepository) {
        this.courseDomainService = courseDomainService;
        this.moduleDataMapper = moduleDataMapper;
        this.courseRepository = courseRepository;
        this.moodleCommandHandler = moodleCommandHandler;
        this.assignmentRepository = assignmentRepository;
        this.sectionRepository = sectionRepository;
        this.moduleRepository = moduleRepository;
    }

    @Transactional
    public Module updateModule(UUID moduleId, UpdateModuleCommand updateModuleCommand) {
       Module module =moduleRepository.findById(moduleId);
       Module response = moduleRepository.save(module);
        log.info("Module is updated with id: {}", module.getId());
        return response;
    }

    @Transactional
    public Boolean updateModule(WebhookMessage webhookMessage, Organization organization) {
        String apiKey = organization.getApiKey();
        String moodleUrl = organization.getMoodleUrl();


        ModuleDetailResponse moduleDetailResponse = moodleCommandHandler.
                getModuleDetail(webhookMessage.getObjectId(), apiKey, moodleUrl);
        if(moduleDetailResponse.getCm()==null)
            return false;
        Optional<Course> course = courseRepository.findByCourseIdMoodleAndOrganizationId(moduleDetailResponse.getCm().getCourse(), organization.getId().getValue());

        if(moduleDetailResponse.getCm().getModname().equals("assign")){
            List<AssignmentCourseModel> assignmentCourseModels = moodleCommandHandler.getAllAssignments(moduleDetailResponse.getCm().getCourse().toString(),apiKey,moodleUrl);
            List<AssignmentModel> assignmentModels = assignmentCourseModels.get(0).getAssignments();
            moodleCommandHandler.updateAssignment(assignmentModels,course.get(),moduleDetailResponse.getCm().getInstance());
        }


        Optional<Assignment> assignment = assignmentRepository.findByAssignmentIdMoodleAndCourseId(moduleDetailResponse.getCm().getInstance(), course.get().getId().getValue());
        Optional<Section> section = sectionRepository.findBySectionMoodleIdAndCourseId(moduleDetailResponse.getCm().getSection(),course.get().getId().getValue());
        if (assignment.isPresent() && section.isPresent()) {
            Optional<Module> module = moduleRepository.findByCmidAndSectionId(moduleDetailResponse.getCm().getId(),section.get().getId().getValue());
            Module createResult = moduleRepository.save(module.get());
            log.info("Module is updated with id: {}", createResult.getId());
            return true;
        }
        return false;
    }
}
