package com.backend.programming.learning.system.course.service.domain.ports.output.repository;
import com.backend.programming.learning.system.course.service.domain.entity.Module;

import java.util.List;
import java.util.UUID;

public interface ModuleRepository {

    Module save(Module module);

    Module findById(UUID moduleId);

    List<Module> findBySectionId(UUID sectionId);

    void deleteById(UUID moduleId);


}
