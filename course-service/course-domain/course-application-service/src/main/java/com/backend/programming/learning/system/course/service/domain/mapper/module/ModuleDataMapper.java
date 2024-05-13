package com.backend.programming.learning.system.course.service.domain.mapper.module;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module.ModuleModel;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import org.springframework.stereotype.Component;
import com.backend.programming.learning.system.course.service.domain.entity.Module;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component

public class ModuleDataMapper {
    public Module moduleModelToModule(ModuleModel moduleModel, Section section) {
        return Module.builder()
                .name(moduleModel.getName())
                .visible(moduleModel.getVisible())
                .section(section)
                .timeClose(ZonedDateTime
                        .from(Instant.ofEpochSecond(moduleModel.getDates().get(1).getTimestamp())
                                .atZone(ZoneId.of("UTC"))))
                .build();
    }
}
