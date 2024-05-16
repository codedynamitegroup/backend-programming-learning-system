package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.ProgrammingLanguageDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.programming_language.CreateProgammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.programming_language.DeleteProgrammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.programming_language.UpdateProgrammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.ProgrammingLanguageApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/code-assessment/language",
        produces = "application/vnd.api.v1+json")
@Slf4j
public class ProgrammingLanguageController {
    final ProgrammingLanguageApplicationService service;

    public ProgrammingLanguageController(ProgrammingLanguageApplicationService service) {
        this.service = service;
    }

    //add outbox
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

    //add outbox
    @DeleteMapping("/{language-id}")
    public ResponseEntity deleteLanguage(@PathVariable(value = "language-id")UUID id){
        DeleteProgrammingLanguageCommand command =  new DeleteProgrammingLanguageCommand(id);
        service.deleteLanguage(command);

        return ResponseEntity.noContent().build();
    }

    //add outbox
    @PutMapping("/{language-id}")
    public ResponseEntity updateLanguage(@PathVariable(value = "language-id")UUID id,
                                         @RequestBody UpdateProgrammingLanguageCommand command){
        command.setLanguageId(id);
        service.updateLanguage(command);
        return ResponseEntity.noContent().build();
    }
}
