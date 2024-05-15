package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.ProgrammingLanguageDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.langauge.AddLanguageToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.tag.AddTagToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.language.DeleteLanguageToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.tag.DeleteCodeQuestionTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetDetailCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_question.UpdateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GenericHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_question.CodeQuestionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.ProgrammingLanguageRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.TestCaseRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag.CodeQuestionTagId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Component
public class CodeQuestionsHelper {
    private final CodeAssessmentDomainService codeAssessmentDomainService;

    private final CodeQuestionRepository codeQuestionRepository;
//    private final QuestionRepository   questionRepository;
    private final CodeQuestionDataMapper codeQuestionDataMaper;
    private final ValidateHelper validateHelper;
    private final GenericHelper genericHelper;
    private final CodeSubmissionRepository codeSubmissionRepository;
    private final TestCaseRepository testCaseRepository;
    private final ProgrammingLanguageRepository programmingLanguageRepository;

    public CodeQuestionsHelper(CodeAssessmentDomainService codeAssessmentDomainService, CodeQuestionRepository codeQuestionRepository, CodeQuestionDataMapper codeQuestionDataMaper, ValidateHelper validateHelper, GenericHelper genericHelper, CodeSubmissionRepository codeSubmissionRepository, TestCaseRepository testCaseRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.codeQuestionRepository = codeQuestionRepository;
        this.codeQuestionDataMaper = codeQuestionDataMaper;
        this.validateHelper = validateHelper;
        this.genericHelper = genericHelper;
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.testCaseRepository = testCaseRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Transactional
    public CodeQuestionsUpdatedEvent persistCodeQuestion(CreateCodeQuestionCommand command){
//        checkQuestion(command.getQuestionId());
        CodeQuestion codeQuestion = codeQuestionDataMaper.createCodeQuestionCommandToCodeQuestion(command);
        log.info("ccss {}", command.getIsPublic());

        CodeQuestionsUpdatedEvent codeQuestionCreatedEvent
                = codeAssessmentDomainService.validateAndInitiateCodeQuestion(codeQuestion);
        CodeQuestion codeQuestionRes = saveCodeQuestion(codeQuestion);
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
                    .map(tag -> codeQuestionDataMaper.codeQuestionIdAndTagIdToCodeQuestionTagId(codeQuestionRes.getId(), tag.getId()))
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

    @Transactional
    public Page<CodeQuestion> getCodeQuestions(GetCodeQuestionsCommand command) {
        User user = validateHelper.validateUser(command.getUserId());
        List<TagId> tagIds = command.getTagIds() == null || command.getTagIds().isEmpty()? null:
                command.getTagIds().stream().map(item->{
                            try {
                                return validateHelper.validateTagById(item).getId();
                            } catch (Exception e) {
                                return null;
                            }
                        })
                        .filter(Objects::nonNull)
                        .toList();
        Page<CodeQuestion> codeQuestions = codeQuestionRepository
                .findAll(user.getId(),
                        tagIds,
                        command.getOrderBy(),
                        command.getSortBy(),
                        command.getPageNum(),
                        command.getPageSize());
        return codeQuestions;
    }

    @Transactional
    public void updateCodeQuestion(UpdateCodeQuestionCommand command) {
        User user = validateHelper.validateUser(command.getUserId());
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());
        if(!user.getId().equals(codeQuestion.getUserId()))
            throw new CodeAssessmentDomainException("User " + user.getId().getValue() + " does not possess code question " + codeQuestion.getId().getValue());

        CodeQuestion codeQuestionUpdate = codeQuestionDataMaper.updateCodeQuestionCommandToCodeQuestion(command);
        genericHelper.mapRepositoryAttributeToUpdateAttribute(codeQuestion, codeQuestionUpdate, CodeQuestion.class);
        codeQuestionRepository.save(codeQuestion);

    }

    @Transactional
    public CodeQuestion getDetailCodeQuestion(GetDetailCodeQuestionCommand command) {
        User user = command.getUserId() != null? validateHelper.validateUser(command.getUserId()): null;

        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());

        List<TestCase> sampleTestCase = testCaseRepository.getSampleTestCase(codeQuestion.getId());

        Optional<CodeSubmission> codeSubmissionOptional = user == null? Optional.empty(): codeSubmissionRepository.findLatestSubmission(codeQuestion.getId(), user.getId());
        CodeSubmission codeSubmission = codeSubmissionOptional.orElse(null);

        List<ProgrammingLanguage> languages = programmingLanguageRepository.findByCodeQuestionId(codeQuestion.getId());

        CodeQuestion result = codeAssessmentDomainService.getDetailCodeQuestion(codeQuestion, sampleTestCase, codeSubmission, languages);
        return result;
    }

    @Transactional
    public void addLanguageToCodeQuestion(AddLanguageToCodeQuestionCommand command) {
        User user = validateHelper.validateUser(command.getUserId());
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());

        if(!codeQuestion.getUserId().equals(user.getId()))
            throw new CodeAssessmentDomainException("User " + codeQuestion.getUserId() + " does not possess code question " + command.getCodeQuestionId());

        List<ProgrammingLanguage> programmingLanguages = validateHelper.validateProgrammingLanguage(command.getLanguages().stream().map(ProgrammingLanguageDto::getId).toList());
        List<ProgrammingLanguageCodeQuestion> plcqs = initLanguageCodeQuestion(command.getLanguages(), codeQuestion);
        codeQuestionRepository.saveNewLanguage(plcqs);
    }

    private List<ProgrammingLanguageCodeQuestion> initLanguageCodeQuestion(List<ProgrammingLanguageDto> languages, CodeQuestion codeQuestion) {
        List<ProgrammingLanguageCodeQuestion> result = new ArrayList<>();
        for(int i = 0; i<languages.size(); ++i){
            result.add(codeAssessmentDomainService.initProgrammingLanguageCodeQuestion(languages.get(i).getTimeLimit(), languages.get(i).getMemoryLimit(), codeQuestion.getId(), languages.get(i).getId()));
        }
        return result;
    }

    @Transactional
    public void deleteProgrammingLanguageCodeQuestion(DeleteLanguageToCodeQuestionCommand command) {
        User user = validateHelper.validateUser(command.getUserId());
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());

        if(!codeQuestion.getUserId().equals(user.getId()))
            throw new CodeAssessmentDomainException("User " + codeQuestion.getUserId() + " does not possess code question " + command.getCodeQuestionId());

        List<ProgrammingLanguage> programmingLanguages = validateHelper.validateProgrammingLanguage(command.getLanguageIds());

        codeQuestionRepository.deleteLanguage(programmingLanguages.stream().map(BaseEntity::getId).toList());
    }

    @Transactional
    public void addTagToCodeQuestion(AddTagToCodeQuestionCommand command) {
        if(command.getTagIds().isEmpty())
            return;

        User user = validateHelper.validateUser(command.getUserId());
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());

        if(!codeQuestion.getUserId().equals(user.getId()))
            throw new CodeAssessmentDomainException("User " + codeQuestion.getUserId() + " does not possess code question " + command.getCodeQuestionId());

        List<Tag> tags = validateHelper.validateTagsById(command.getTagIds());

        codeQuestionRepository.addTag(codeQuestion.getId(), tags);
    }

    public void deleteCodeQuestionTag(DeleteCodeQuestionTagCommand command) {
        if(command.getTagIds().isEmpty())
            return;

        User user = validateHelper.validateUser(command.getUserId());
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());

        if(!codeQuestion.getUserId().equals(user.getId()))
            throw new CodeAssessmentDomainException("User " + codeQuestion.getUserId() + " does not possess code question " + command.getCodeQuestionId());

        List<CodeQuestionTagId> cqts = command
                .getTagIds()
                .stream()
                .map(TagId::new)
                .map(item->codeQuestionDataMaper
                        .codeQuestionIdAndTagIdToCodeQuestionTagId(codeQuestion.getId(), item))
                .toList();
        List<CodeQuestionTag> tags = validateHelper.validateCodeQuestionTagsById(cqts);

        codeQuestionRepository.deleteCodeQuestionTag(tags);
    }
}
