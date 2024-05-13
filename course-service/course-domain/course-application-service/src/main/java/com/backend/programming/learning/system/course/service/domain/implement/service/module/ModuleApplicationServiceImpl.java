package com.backend.programming.learning.system.course.service.domain.implement.service.module;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.module.DeleteModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.module.DeleteModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.module.QueryAllModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.module.QueryModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.module.UpdateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.module.UpdateModuleResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.module.ModuleApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class ModuleApplicationServiceImpl implements ModuleApplicationService {
    private final ModuleCommandHandler moduleCommandHandler;

    @Override
    public CreateModuleResponse createModule(CreateModuleCommand createModuleCommand) {
        return moduleCommandHandler.createModule(createModuleCommand);
    }

    @Override
    public UpdateModuleResponse updateModule(UUID moduleId, UpdateModuleCommand updateModuleCommand) {
        return moduleCommandHandler.updateModule(moduleId, updateModuleCommand);
    }

    @Override
    public DeleteModuleResponse deleteModule(DeleteModuleCommand deleteModuleCommand) {
        return moduleCommandHandler.deleteModule(deleteModuleCommand.getModuleId());
    }

    @Override
    public QueryAllModuleResponse queryAllBySectionId(QueryModuleCommand queryModuleCommand) {
        return moduleCommandHandler.queryAllBySectionId(queryModuleCommand.getSectionId());
    }
}
