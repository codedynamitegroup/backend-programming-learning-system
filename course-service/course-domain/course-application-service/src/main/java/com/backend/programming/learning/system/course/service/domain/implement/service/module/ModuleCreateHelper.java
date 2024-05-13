package com.backend.programming.learning.system.course.service.domain.implement.service.module;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.module.ModuleDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ModuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class ModuleCreateHelper {

    private final CourseDomainService courseDomainService;
    private final ModuleDataMapper moduleDataMapper;
    private final CourseRepository courseRepository;
    private final MoodleCommandHandler moodleCommandHandler;

    private final ModuleRepository moduleRepository;

    public ModuleCreateHelper(CourseDomainService courseDomainService, ModuleDataMapper moduleDataMapper, CourseRepository courseRepository, MoodleCommandHandler moodleCommandHandler, ModuleRepository moduleRepository) {
        this.courseDomainService = courseDomainService;
        this.moduleDataMapper = moduleDataMapper;
        this.courseRepository = courseRepository;
        this.moodleCommandHandler = moodleCommandHandler;
        this.moduleRepository = moduleRepository;
    }

    @Transactional
    public void createModule(WebhookMessage webhookMessage, Section section) {


    }

    @Transactional
    public Module createModule(CreateModuleCommand createModuleCommand) {
        Module module = moduleDataMapper.createModuleCommandToModule(createModuleCommand);
        courseDomainService.createModule(module);
        Module createResult = moduleRepository.save(module);
        log.info("Module is created with id: {}", createResult.getId());
        return createResult;
    }
}

