package com.backend.programming.learning.system.auth.service.application.rest.module;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/module", produces = "application/vnd.api.v1+json")
public class ModuleController {
    private final ModuleApplicationService moduleApplicationService;

    @PostMapping("/create")
    public ResponseEntity<CreateModuleResponse> createModule(@RequestBody CreateModuleCommand createModuleCommand) {
        CreateModuleResponse response = moduleApplicationService.createModule(createModuleCommand);
        return ResponseEntity.status(HttpStatus.CREATED ).body(response);
    }

    @GetMapping("/{sectionId}")
    public ResponseEntity<QueryAllModuleResponse> queryAllModules(@PathVariable UUID sectionId) {
        QueryAllModuleResponse response = moduleApplicationService.queryAllBySectionId(new QueryModuleCommand(sectionId));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{moduleId}")
    public ResponseEntity<DeleteModuleResponse> deleteModule(@PathVariable UUID moduleId) {
        DeleteModuleResponse response = moduleApplicationService.deleteModule(new DeleteModuleCommand(moduleId));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{moduleId}")
    public ResponseEntity<UpdateModuleResponse> updateModule(@PathVariable UUID moduleId, @RequestBody UpdateModuleCommand updateModuleCommand) {
        UpdateModuleResponse response = moduleApplicationService.updateModule(moduleId, updateModuleCommand);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
