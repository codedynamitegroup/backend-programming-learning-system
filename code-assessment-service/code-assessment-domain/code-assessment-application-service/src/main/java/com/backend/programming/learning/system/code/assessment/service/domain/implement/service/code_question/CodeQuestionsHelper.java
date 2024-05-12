package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.codequestion.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_question.CodeQuestionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag.CodeQuestionTagId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class CodeQuestionsHelper {
    private final CodeAssessmentDomainService codeAssessmentDomainService;

    private final CodeQuestionRepository codeQuestionRepository;
//    private final QuestionRepository   questionRepository;
    private final CodeQuestionDataMapper codeQuestionDataMaper;
    private final ValidateHelper validateHelper;

    public CodeQuestionsHelper(CodeAssessmentDomainService codeAssessmentDomainService, CodeQuestionRepository codeQuestionRepository, CodeQuestionDataMapper codeQuestionDataMaper, ValidateHelper validateHelper) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.codeQuestionRepository = codeQuestionRepository;
        this.codeQuestionDataMaper = codeQuestionDataMaper;
        this.validateHelper = validateHelper;
    }

    @Transactional
    public CodeQuestionsUpdatedEvent persistCodeQuestion(CreateCodeQuestionCommand command){
//        checkQuestion(command.getQuestionId());
        CodeQuestion codeQuestion = codeQuestionDataMaper.createCodeQuestionCommandToCodeQuestion(command);
        log.info("ccss {}", command.getIsPublic());

        CodeQuestionsUpdatedEvent codeQuestionCreatedEvent
                = codeAssessmentDomainService.validateAndInitiateCodeQuestion(codeQuestion);
        saveCodeQuestion(codeQuestion);
        log.info("Code question is created, id: {}", codeQuestionCreatedEvent.getCodeQuestion().getId().getValue());


        //save tag;
        if(command.getTagIds() != null && !command.getTagIds().isEmpty()){
            List<CodeQuestionTagId> codeQuestionTagIds = command.getTagIds().stream()
                    .map(item->{
                        try {
                            return validateHelper.validateTagById(item);
                        } catch (Exception e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .map(tag -> codeQuestionDataMaper.codeQuestionIdAndTagIdToCodeQuestionTagId(codeQuestion.getId(), tag.getId()))
                    .toList();
            codeQuestionRepository.saveTags(codeQuestionTagIds);
        }

        return codeQuestionCreatedEvent;
    }
//    private void checkQuestion(UUID questionId) {
//        Optional<Question> question = questionRepository.findQuestionInformation(questionId);
//        if(question.isEmpty()){
//            log.warn("Could not find question id: {}", questionId);
//            throw new CodeQuestionDomainException("Could not find question id: " + questionId);
//        }
//    }
    private CodeQuestion saveCodeQuestion(CodeQuestion codeQuestion){
        CodeQuestion codeQuestionResult = codeQuestionRepository.save(codeQuestion);
        if(codeQuestionResult == null){
            log.error("Can not save code question id");
            throw new CodeAssessmentDomainException("Can not save code question");
        }
        log.info("Code question is save with id: {}", codeQuestionResult.getId().getValue());
        return codeQuestionResult;
    }
}
