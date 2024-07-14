package com.backend.programming.learning.system.course.service.domain.implement.service.module;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.module.UpdateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.module.ModuleDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ModuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
public class ModuleUpdateHelper {
    private final CourseDomainService courseDomainService;
    private final ModuleDataMapper moduleDataMapper;
    private final CourseRepository courseRepository;
    private final MoodleCommandHandler moodleCommandHandler;

    private final ModuleRepository moduleRepository;

    public ModuleUpdateHelper(CourseDomainService courseDomainService,
                              ModuleDataMapper moduleDataMapper,
                              CourseRepository courseRepository,
                              MoodleCommandHandler moodleCommandHandler,
                              ModuleRepository moduleRepository) {
        this.courseDomainService = courseDomainService;
        this.moduleDataMapper = moduleDataMapper;
        this.courseRepository = courseRepository;
        this.moodleCommandHandler = moodleCommandHandler;
        this.moduleRepository = moduleRepository;
    }

    @Transactional
    public Module updateModule(UUID moduleId, UpdateModuleCommand updateModuleCommand) {
       Module module =moduleRepository.findById(moduleId);
       Module response = moduleRepository.save(module);
        log.info("Module is updated with id: {}", module.getId());
        return response;
    }
}
