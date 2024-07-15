package com.backend.programming.learning.system.auth.service.application.rest.section;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.section.CreateSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.section.CreateSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.section.DeleteSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.section.DeleteSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.section.QueryAllSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.section.QuerySectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.section.UpdateSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.section.UpdateSectionResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.section.SectionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/section", produces = "application/vnd.api.v1+json")
public class SectionController {
    private final SectionApplicationService sectionApplicationService;

    @PostMapping("/course/{courseId}")
    public ResponseEntity<CreateSectionResponse> createSection(
            @PathVariable UUID courseId,
            @RequestBody CreateSectionCommand createSectionCommand) {
        CreateSectionResponse response = sectionApplicationService.createSection(CreateSectionCommand.builder()
                .courseId(courseId)
                .name(createSectionCommand.getName())
                .visible(createSectionCommand.getVisible())
                .build());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<QueryAllSectionResponse> queryAllSections(@PathVariable UUID courseId) {
        QueryAllSectionResponse response = sectionApplicationService.queryAllSections(new QuerySectionCommand(courseId));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{sectionId}")
    public ResponseEntity<DeleteSectionResponse> deleteSection(@PathVariable UUID sectionId) {
        DeleteSectionResponse response = sectionApplicationService.deleteSection(new DeleteSectionCommand(sectionId));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{sectionId}")
    public ResponseEntity<UpdateSectionResponse> updateSection(@PathVariable UUID sectionId, @RequestBody UpdateSectionCommand updateSectionCommand) {
       UpdateSectionResponse response = sectionApplicationService.updateSection(sectionId, UpdateSectionCommand.builder()
                .name(updateSectionCommand.getName())
                .visible(updateSectionCommand.getVisible())
                .sectionId(sectionId)
               .build());
         return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
