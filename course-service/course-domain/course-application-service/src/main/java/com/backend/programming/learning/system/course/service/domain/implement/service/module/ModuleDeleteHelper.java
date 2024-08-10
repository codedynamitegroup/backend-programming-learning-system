package com.backend.programming.learning.system.course.service.domain.implement.service.module;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
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
public class ModuleDeleteHelper {
    private final CourseDomainService courseDomainService;
    private final ModuleDataMapper moduleDataMapper;
    private final CourseRepository courseRepository;
    private final MoodleCommandHandler moodleCommandHandler;

    private final ModuleRepository moduleRepository;
    private final AssignmentRepository assignmentRepository;



    public ModuleDeleteHelper(CourseDomainService courseDomainService,
                              ModuleDataMapper moduleDataMapper,
                              CourseRepository courseRepository,
                              MoodleCommandHandler moodleCommandHandler,
                              ModuleRepository moduleRepository, AssignmentRepository assignmentRepository) {
        this.courseDomainService = courseDomainService;
        this.moduleDataMapper = moduleDataMapper;
        this.courseRepository = courseRepository;
        this.moodleCommandHandler = moodleCommandHandler;
        this.moduleRepository = moduleRepository;
        this.assignmentRepository = assignmentRepository;
    }

    public void deleteModule(UUID moduleId) {
        moduleRepository.deleteById(moduleId);
        log.info("Module is deleted with id: {}", moduleId);
    }

    @Transactional
    public Boolean deleteModule(WebhookMessage webhookMessage, Organization organization) {
        String apiKey = organization.getApiKey();
        String moodleUrl = organization.getMoodleUrl();

        ModuleDetailResponse moduleDetailResponse = moodleCommandHandler.
                getModuleDetail(webhookMessage.getObjectId(), apiKey, moodleUrl);
        if(moduleDetailResponse.getCm()==null)
            return false;
        Optional<Course> course = courseRepository.findByCourseIdMoodleAndOrganizationId(moduleDetailResponse.getCm().getCourse(), organization.getId().getValue());
        Optional<Assignment> assignment = assignmentRepository.findByAssignmentIdMoodleAndCourseId(moduleDetailResponse.getCm().getInstance(), course.get().getId().getValue());
        assignmentRepository.deleteAssignmentById(assignment.get().getId().getValue());
        return true;
    }
}
