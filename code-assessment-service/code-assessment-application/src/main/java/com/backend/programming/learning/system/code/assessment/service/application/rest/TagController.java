package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TagDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.tag.CreateTagsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.tag.CreateTagsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.tag.DeleteTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.tag.GetTagsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.TagApplicationService;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/code-assessment/tag",
        produces = "application/vnd.api.v1+json")
@Slf4j
public class TagController {
    final TagApplicationService tagApplicationService;

    public TagController(TagApplicationService tagApplicationService) {
        this.tagApplicationService = tagApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateTagsResponse> createTag(@RequestBody List<TagDto> tags){
        CreateTagsCommand command = CreateTagsCommand.builder().tags(tags).build();

        CreateTagsResponse response = tagApplicationService.createTags(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping
    public ResponseEntity deleteTag(@RequestBody UUID tagId){
        DeleteTagCommand command = DeleteTagCommand.builder().tagId(tagId).build();
        tagApplicationService.deleteTag(command);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TagDto>> getTags(
            @RequestParam(value = "countCodeQuestion", required = false) Boolean countCodeQuestion,
            @RequestParam(value = "tagType", required = false) TagType tagType
    ){
        if(countCodeQuestion == null)
            countCodeQuestion = false;

        GetTagsCommand command = GetTagsCommand.builder()
                .countCodeQuestion(countCodeQuestion)
                .tagType(tagType)
                .build();
        List<TagDto> response = tagApplicationService.getTags(command);
        return ResponseEntity.ok(response);
    }



}
