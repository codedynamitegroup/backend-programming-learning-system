package com.backend.programming.learning.system.course.service.domain.ports.input.service.module;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.module.DeleteModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.module.DeleteModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.module.QueryAllModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.module.QueryModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.module.UpdateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.module.UpdateModuleResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface ModuleApplicationService {
    CreateModuleResponse createModule(@Valid CreateModuleCommand createModuleCommand);


    UpdateModuleResponse updateModule(@Valid UUID moduleId, @Valid UpdateModuleCommand updateModuleCommand);

    DeleteModuleResponse deleteModule(@Valid DeleteModuleCommand deleteModuleCommand);

    QueryAllModuleResponse queryAllBySectionId(@Valid QueryModuleCommand queryModuleCommand);
}
