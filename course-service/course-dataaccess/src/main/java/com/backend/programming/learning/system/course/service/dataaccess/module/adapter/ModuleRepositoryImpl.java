package com.backend.programming.learning.system.course.service.dataaccess.module.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.module.mapper.ModuleDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.module.repository.ModuleJpaRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ModuleRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.backend.programming.learning.system.course.service.domain.entity.Module;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ModuleRepositoryImpl implements ModuleRepository {

    private final ModuleJpaRepository moduleJpaRepository;
    private final ModuleDataAccessMapper moduleDataAccessMapper;


    @Override
    public Module save(Module module) {
        return moduleDataAccessMapper.moduleEntityToModule(moduleJpaRepository
                .saveAndFlush(moduleDataAccessMapper
                        .moduleToModuleEntity(module)));
    }

    @Override
    public Module findById(UUID moduleId) {
        return moduleDataAccessMapper.moduleEntityToModule(moduleJpaRepository
                .findById(moduleId)
                .orElseThrow(() -> new RuntimeException("Module not found")));
    }

    @Override
    public Optional<Module> findByCmidAndSectionId(Integer cmid, UUID sectionId) {
        return moduleJpaRepository.findByCmidAndSectionId(cmid, sectionId)
                .map(moduleDataAccessMapper::moduleEntityToModule);
    }



    @Override
    public List<Module> findBySectionId(UUID sectionId) {
        return moduleDataAccessMapper.moduleEntityListToModuleList(moduleJpaRepository.findBySectionId(sectionId));
    }

    @Override
    public void deleteById(UUID moduleId) {
        moduleJpaRepository.deleteById(moduleId);
    }

    @Override
    public Optional<Module> findByExamId(ExamId examId) {
        return moduleJpaRepository.findByExamId(examId.getValue())
                .map(moduleDataAccessMapper::moduleEntityToModule);
    }

    @Override
    public Optional<Module> findByAssignmentId(UUID value) {
        return moduleJpaRepository.findByAssignmentId(value)
                .map(moduleDataAccessMapper::moduleEntityToModule);
    }
}
