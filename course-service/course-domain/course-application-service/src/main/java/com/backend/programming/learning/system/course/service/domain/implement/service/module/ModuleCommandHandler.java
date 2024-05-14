package com.backend.programming.learning.system.course.service.domain.implement.service.module;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.module.DeleteModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.module.QueryAllModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.module.UpdateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.module.UpdateModuleResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.mapper.module.ModuleDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class ModuleCommandHandler {
    private final ModuleDeleteHelper moduleDeleteHelper;
    private final ModuleCreateHelper moduleCreateHelper;
    private final ModuleUpdateHelper moduleUpdateHelper;
    private final ModuleQueryHelper moduleQueryHelper;
    private final ModuleDataMapper moduleDataMapper;

    @Transactional
    public CreateModuleResponse createModule(CreateModuleCommand createModuleCommand) {
        Module module = moduleCreateHelper.createModule(createModuleCommand);
        return moduleDataMapper.moduleToCreateModuleResponse(module,"Module is created successfully");
    }

    @Transactional
    public UpdateModuleResponse updateModule(UUID moduleId, UpdateModuleCommand updateModuleCommand) {
        Module module = moduleUpdateHelper.updateModule(moduleId, updateModuleCommand);
        return moduleDataMapper.moduleToUpdateModuleResponse(module,"Module is updated successfully");
    }

    @Transactional
    public DeleteModuleResponse deleteModule(UUID moduleId) {
        moduleDeleteHelper.deleteModule(moduleId);
        return DeleteModuleResponse.builder()
                .moduleId(moduleId)
                .build();
    }

    @Transactional(readOnly = true)
    public QueryAllModuleResponse queryAllBySectionId(UUID sectionId) {
        List<Module> modules = moduleQueryHelper.queryAllBySectionId(sectionId);
        return moduleDataMapper.modulesToQueryAllModuleResponse(modules);
    }
}
