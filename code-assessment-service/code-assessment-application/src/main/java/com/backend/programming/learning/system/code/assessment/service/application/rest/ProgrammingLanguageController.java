package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.ProgrammingLanguageDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.programming_language.CreateProgammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.ProgrammingLanguageApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/code-assessment/language",
        produces = "application/vnd.api.v1+json")
@Slf4j
public class ProgrammingLanguageController {
    final ProgrammingLanguageApplicationService service;

    public ProgrammingLanguageController(ProgrammingLanguageApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createProgrammingLanguage(@RequestBody CreateProgammingLanguageCommand command){
        if(command.getIsActived() == null)
            command.setIsActived(true);

        service.createProgrammingLanguage(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<ProgrammingLanguageDto>> getProgrammingLanguage(){
        List<ProgrammingLanguageDto> response = service.getLanguage();
        return ResponseEntity.ok(response);
    }
}
