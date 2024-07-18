package com.backend.programming.learning.system.course.service.domain.ports.output.repository;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleRepository {

    Module save(Module module);

    Module findById(UUID moduleId);

    Optional<Module> findByCmid(Integer cmid);

    List<Module> findBySectionId(UUID sectionId);

    void deleteById(UUID moduleId);


    Optional<Module> findByExamId(ExamId examId);
}
