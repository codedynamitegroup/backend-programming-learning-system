package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.tag;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.tag.CreateTagsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.tag.DeleteTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.tag.GetTagsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.tag.TagDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.TagRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TagHelper {
    final TagRepository tagRepository;
    final CodeAssessmentDomainService codeAssessmentDomainService;
    final CodeQuestionRepository codeQuestionRepository;
    final TagDataMapper tagDataMapper;

    public TagHelper(TagRepository tagRepository, CodeAssessmentDomainService codeAssessmentDomainService, CodeQuestionRepository codeQuestionRepository, TagDataMapper tagDataMapper) {
        this.tagRepository = tagRepository;
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.codeQuestionRepository = codeQuestionRepository;
        this.tagDataMapper = tagDataMapper;
    }

    @Transactional
    public void createTags(CreateTagsCommand command) {
        List<Tag> tags = command.getTagNames().stream().map(tagDataMapper::createTagCommandToTag).toList();
        codeAssessmentDomainService.initiateTags(tags);
        tagRepository.saveAll(tags);
    }

    @Transactional
    public void deleteTag(DeleteTagCommand command) {
        tagRepository.deleteTag(new TagId(command.getTagId()));
    }

    @Transactional
    public List<Tag> getTags(GetTagsCommand command) {
        if(command.getCountCodeQuestion()){
            List<Tag> tags = new ArrayList<>(tagRepository.getTags());
            Integer countAllCodeQuestion = codeQuestionRepository.countAllCodeQuestion();
            tags.add(Tag.builder().name("All").numOfCodeQuestion(countAllCodeQuestion).build());
            return tags;
        }
        else
            return tagRepository.getTagsExcludeCountCodeQuestion();
    }
}
