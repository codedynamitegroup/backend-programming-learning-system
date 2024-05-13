package com.backend.programming.learning.system.course.service.domain.implement.service.module;

import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ModuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class ModuleQueryHelper {

    private final ModuleRepository moduleRepository;

    public ModuleQueryHelper(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Transactional(readOnly = true)
    public List<Module> queryAllBySectionId(UUID sectionId) {
        return moduleRepository.findBySectionId(sectionId);
    }

}
