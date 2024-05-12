package com.backend.programming.learning.system.course.service.domain.mapper.module;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import org.springframework.stereotype.Component;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
@Component

public class ModuleDataMapper {
    public Module createModuleCommandToModule(CreateModuleCommand createModuleCommand) {
        return Module.builder()
                .name(createModuleCommand.getName())
                .cmid(createModuleCommand.getCmid())

                .build();
    }
}
