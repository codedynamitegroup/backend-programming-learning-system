package com.backend.programming.learning.system.course.service.domain.mapper.module;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.module.QueryAllModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.module.UpdateModuleResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.module.ModuleResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module.ModuleModel;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SectionRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.TypeModule;
import org.springframework.stereotype.Component;
import com.backend.programming.learning.system.course.service.domain.entity.Module;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Component

public class ModuleDataMapper {
   private final SectionRepository sectionRepository;

    public ModuleDataMapper(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Module moduleModelToModule(ModuleModel moduleModel, Section section) {
        return Module.builder()
                .name(moduleModel.getName())
                .visible(moduleModel.getVisible())
                .section(section)
                .typeModule(TypeModule.fromLabel(moduleModel.getModplural()))
                .timeClose(ZonedDateTime
                        .from(Instant.ofEpochSecond(moduleModel.getDates().get(1).getTimestamp())
                                .atZone(ZoneId.of("UTC"))))
                .build();
    }

    public Module createModuleCommandToModule(CreateModuleCommand createModuleCommand) {
        Section section = sectionRepository.findById(createModuleCommand.getSectionId());
        return Module.builder()
                .name(createModuleCommand.getName())
                .visible(createModuleCommand.getVisible())
                .section(section)
                .timeClose((createModuleCommand.getTimeClose()))
                .build();
    }

    public CreateModuleResponse moduleToCreateModuleResponse(Module module,String message) {
        return CreateModuleResponse.builder()
                .sectionId(module.getSection().getId().getValue())
                .name(module.getName())
                .visible(module.getVisible())
                .message(message)
                .build();
    }

    public UpdateModuleResponse moduleToUpdateModuleResponse(Module module, String moduleIsUpdatedSuccessfully) {
        return UpdateModuleResponse.builder()
                .sectionId(module.getSection().getId().getValue())
                .name(module.getName())
                .visible(module.getVisible())
                .message(moduleIsUpdatedSuccessfully)
                .build();
    }


    public ModuleResponseEntity moduleToModuleResponseEntity(Module module) {
        return ModuleResponseEntity.builder()
                .moduleId(module.getId().getValue())
                .name(module.getName())
                .visible(module.getVisible())
                .typeModule(module.getTypeModule().getLabel())
                .content(module.getContent())
                .build();
    }

    public QueryAllModuleResponse modulesToQueryAllModuleResponse(List<Module> modules) {
        return QueryAllModuleResponse.builder()
                .sectionId(modules.get(0).getSection().getId().getValue())
                .modules(modules.stream().map(this::moduleToModuleResponseEntity).toList())
                .build();
    }
}
