package com.backend.programming.learning.system.course.service.domain.ports.output.repository;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleRepository {

    Module save(Module module);

    Module findById(UUID moduleId);

    Optional<Module> findByCmidAndSectionId(Integer cmid,UUID sectionId);

    List<Module> findBySectionId(UUID sectionId);

    void deleteById(UUID moduleId);


    Optional<Module> findByExamId(ExamId examId);

    Optional<Module> findByAssignmentId(UUID value);

}
