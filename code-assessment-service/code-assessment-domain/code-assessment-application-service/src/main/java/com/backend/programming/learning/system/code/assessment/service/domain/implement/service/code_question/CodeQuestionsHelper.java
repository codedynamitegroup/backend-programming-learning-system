package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.ProgrammingLanguageDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.langauge.UpdateLanguageOfCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.tag.AddTagToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.language.DeleteLanguageToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.tag.DeleteCodeQuestionTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.AdminDetailCodeQuestionQuery;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsQuery;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetDetailCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_question.UpdateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.event.code_question.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GenericHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_question.CodeQuestionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.redis.CodeQuestionRedisService;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.ProgrammingLanguageCodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.ProgrammingLanguageRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.TestCaseRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag.CodeQuestionTagId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Component
public class CodeQuestionsHelper {
    private final CodeAssessmentDomainService codeAssessmentDomainService;
    private final CodeQuestionRedisService codeQuestionRedisService;

    private final CodeQuestionRepository codeQuestionRepository;
//    private final QuestionRepository   questionRepository;
    private final CodeQuestionDataMapper codeQuestionDataMaper;
    private final ValidateHelper validateHelper;
    private final GenericHelper genericHelper;
    private final CodeSubmissionRepository codeSubmissionRepository;
    private final TestCaseRepository testCaseRepository;
    private final ProgrammingLanguageRepository programmingLanguageRepository;
    private final ProgrammingLanguageCodeQuestionRepository programmingLanguageCodeQuestionRepository;

    public CodeQuestionsHelper(CodeAssessmentDomainService codeAssessmentDomainService, CodeQuestionRedisService codeQuestionRedisService, CodeQuestionRepository codeQuestionRepository, CodeQuestionDataMapper codeQuestionDataMaper, ValidateHelper validateHelper, GenericHelper genericHelper, CodeSubmissionRepository codeSubmissionRepository, TestCaseRepository testCaseRepository, ProgrammingLanguageRepository programmingLanguageRepository, ProgrammingLanguageCodeQuestionRepository programmingLanguageCodeQuestionRepository) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.codeQuestionRedisService = codeQuestionRedisService;
        this.codeQuestionRepository = codeQuestionRepository;
        this.codeQuestionDataMaper = codeQuestionDataMaper;
        this.validateHelper = validateHelper;
        this.genericHelper = genericHelper;
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.testCaseRepository = testCaseRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.programmingLanguageCodeQuestionRepository = programmingLanguageCodeQuestionRepository;
    }

    @Transactional
    public CodeQuestionsUpdatedEvent persistCodeQuestion(CreateCodeQuestionCommand command){
//        checkQuestion(command.getQuestionId());
//        validateHelper.validateCodeQuestionNotHaveName(command.getName());
        User user = validateHelper.validateUserByEmail(command.getEmail());
        CodeQuestion codeQuestion = codeQuestionDataMaper.createCodeQuestionCommandToCodeQuestion(command, user);

        CodeQuestionsUpdatedEvent codeQuestionCreatedEvent
                = codeAssessmentDomainService.validateAndInitiateCodeQuestion(codeQuestion);
        CodeQuestion codeQuestionRes = saveCodeQuestion(codeQuestion);
        log.info("Code question is created, id: {}", codeQuestionCreatedEvent.getCodeQuestion().getId().getValue());

        if(command.getCategoryBankId() != null){
            codeQuestionRepository.saveCategory(codeQuestionRes.getId(), command.getCategoryBankId());
        }

        //save tag;
        if(command.getTagIds() != null && !command.getTagIds().isEmpty()){
            List<CodeQuestionTagId> codeQuestionTagIds = command.getTagIds().stream()
                    .filter(Objects::nonNull)
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

        //save language
        if(command.getProgrammingLanuages() != null && !command.getProgrammingLanuages().isEmpty()){
            List<ProgrammingLanguageCodeQuestion> programmingLanguageCodeQuestions = command.getProgrammingLanuages()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(item->{
                        try {
                            ProgrammingLanguage programmingLanguage = validateHelper.validateProgrammingLanguage(new ProgrammingLanguageId(item.getId()));
                            ProgrammingLanguageCodeQuestion programmingLanguageCodeQuestion
                                    = codeAssessmentDomainService.initProgrammingLanguageCodeQuestion(
                                            item.getTimeLimit(),
                                            item.getMemoryLimit(),
                                            item.getHeadCode(),
                                            item.getBodyCode(),
                                            item.getTailCode(),
                                            codeQuestionRes.getId(),
                                            item.getId());
                            return programmingLanguageCodeQuestion;
                        } catch (Exception e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .toList();
            codeQuestionRepository.saveNewLanguage(programmingLanguageCodeQuestions);
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
    public Page<CodeQuestion> getPublicCodeQuestions(GetCodeQuestionsQuery query) {
        User user = query.getEmail() != null ? validateHelper.validateUserByEmail(query.getEmail()): null;

        Page<CodeQuestion> codeQuestions = null;

        if (user == null &&
                (query.getTagIds() == null || query.getTagIds().isEmpty())
                && (query.getSearch() == null || query.getSearch().trim().isEmpty() || query.getSearch().trim().isBlank())
                    && query.getSolved() == null) {
            try {
                GetCodeQuestionsResponse response = codeQuestionRedisService.getAllCodeQuestions(
                        query.getPageNum(), query.getPageSize(), query.getOrderBy(), query.getDifficulty());
                if (response != null) {
                    log.info("Get code questions from redis");
                    List<CodeQuestionDto> codeQuestionDtos = response.getCodeQuestions();
                    Pageable pageable = PageRequest.of(response.getCurrentPage(), query.getPageSize());
                    Page<CodeQuestionDto> codeQuestionDtoPage =
                            new PageImpl<>(codeQuestionDtos, pageable, response.getTotalItems());
                    codeQuestions = codeQuestionDtoPage.map(codeQuestionDataMaper::codeQuestionDtoToCodeQuestion);
                } else {
                    log.info("response in redis is null");
                    log.info("Get code questions from database");
                    codeQuestions = codeQuestionRepository
                            .findAll(user != null ? user.getId(): null,
                                    new ArrayList<>(),
                                    query.getOrderBy(),
                                    query.getSortBy(),
                                    query.getPageNum(),
                                    query.getPageSize(),
                                    query.getDifficulty(),
                                    query.getSolved(),
                                    query.getSearch(),
                                    true);
                }
            } catch (Exception e) {
                log.error("Error while getting code questions from redis", e);
                log.info("Get code questions from database");
                codeQuestions = codeQuestionRepository
                        .findAll(user != null ? user.getId(): null,
                                new ArrayList<>(),
                                query.getOrderBy(),
                                query.getSortBy(),
                                query.getPageNum(),
                                query.getPageSize(),
                                query.getDifficulty(),
                                query.getSolved(),
                                query.getSearch(),
                                true);
                GetCodeQuestionsResponse response =
                        codeQuestionDataMaper.pagableCodeQuestionsToGetCodeQuestionsResponse(codeQuestions);
                codeQuestionRedisService.saveAllCodeQuestions(
                        response,
                        query.getPageNum(),
                        query.getPageSize(),
                        query.getOrderBy(),
                        query.getDifficulty());
            }
        } else {
            List<TagId> tagIds = query.getTagIds() == null || query.getTagIds().isEmpty()? null:
                    query.getTagIds().stream().map(item->{
                                try {
                                    return validateHelper.validateTagById(item).getId();
                                } catch (Exception e) {
                                    return null;
                                }
                            })
                            .filter(Objects::nonNull)
                            .toList();

            codeQuestions = codeQuestionRepository
                    .findAll(user != null ? user.getId(): null,
                            tagIds,
                            query.getOrderBy(),
                            query.getSortBy(),
                            query.getPageNum(),
                            query.getPageSize(),
                            query.getDifficulty(),
                            query.getSolved(),
                            query.getSearch(),
                            true);
        }
        if (codeQuestions != null) {
            codeQuestions.map(item->{
                Integer countPeople = codeSubmissionRepository.countPeopleAttend(item.getId());
                item.setNumberOfPeopleAttend(countPeople);
                return item;
            });
        }
        return codeQuestions;
    }

    @Transactional
    public CodeQuestionsUpdatedEvent updateCodeQuestion(UpdateCodeQuestionCommand command) {
        User user = validateHelper.validateUserByEmail(command.getEmail());
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());
//        if(!user.getId().equals(codeQuestion.getUserId()))
//            throw new CodeAssessmentDomainException("User " + user.getId().getValue() + " does not possess code question " + codeQuestion.getId().getValue());

        CodeQuestion codeQuestionUpdate = codeQuestionDataMaper.updateCodeQuestionCommandToCodeQuestion(command, user);
        genericHelper.mapRepositoryAttributeToUpdateAttribute(codeQuestion, codeQuestionUpdate, CodeQuestion.class);
        CodeQuestionsUpdatedEvent event = codeAssessmentDomainService.updateCodeQuestion(codeQuestion);
        codeQuestionRepository.save(codeQuestion);

        if(command.getCategoryBankId() != null){
            codeQuestionRepository.saveCategory(codeQuestion.getId(), command.getCategoryBankId());
        }else {
            codeQuestionRepository.deleteCategory(codeQuestion.getId());
        }

        if(command.getNewTagIds() !=null && !command.getNewTagIds().isEmpty()) {
            List<Tag> tags = validateHelper.validateTagsById(command.getNewTagIds());
            codeQuestionRepository.addTag(codeQuestion.getId(), tags);
        }
        if(command.getDeletedTagIds() != null && !command.getDeletedTagIds().isEmpty())
        {
            List<CodeQuestionTagId> cqts = command
                    .getDeletedTagIds()
                    .stream()
                    .map(TagId::new)
                    .map(item->codeQuestionDataMaper
                            .codeQuestionIdAndTagIdToCodeQuestionTagId(codeQuestion.getId(), item))
                    .toList();
            List<CodeQuestionTag> tags = validateHelper.validateCodeQuestionTagsById(cqts);
            codeQuestionRepository.deleteCodeQuestionTag(tags);

        }
        return event;

    }

    @Transactional
    public List<CodeQuestion> getDetailCodeQuestion(GetDetailCodeQuestionCommand command) {
        User user = command.getEmail() != null? validateHelper.validateUserByEmail(command.getEmail()) : null;

        return command.getCodeQuestionIds().stream().map(codeQuestionId-> {
            CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(codeQuestionId);

            List<TestCase> sampleTestCase = testCaseRepository.getSampleTestCase(codeQuestion.getId());

            List<CodeSubmission> codeSubmissions = List.of();//user == null ? List.of() : codeSubmissionRepository.findLatestSubmissionEachLanguage(codeQuestion.getId(), user.getId());

            List<ProgrammingLanguageCodeQuestion> languages = programmingLanguageCodeQuestionRepository.findByCodeQuestionId(codeQuestion.getId());

            return codeAssessmentDomainService.getDetailCodeQuestion(codeQuestion, sampleTestCase, codeSubmissions, languages);
        }).toList();
    }

    @Transactional
    public void updateLanguageOfCodeQuestion(UpdateLanguageOfCodeQuestionCommand command) {
        validateHelper.validateUserByEmail(command.getEmail());
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());

//        if(!codeQuestion.getUserId().equals(user.getId()))
//            throw new CodeAssessmentDomainException("User " + codeQuestion.getUserId() + " does not possess code question " + command.getCodeQuestionId());

        validateHelper.validateProgrammingLanguage(command.getUpdatedLanguages().stream().map(ProgrammingLanguageDto::getId).toList());
        validateHelper.validateProgrammingLanguage(command.getDeletedLangaugeIds());

        List<ProgrammingLanguageCodeQuestion> plcqs = initLanguageCodeQuestion(command.getUpdatedLanguages(), codeQuestion);

        codeQuestionRepository.saveNewLanguage(plcqs);

        codeQuestionRepository.deleteLanguages(command.getDeletedLangaugeIds().stream().map(ProgrammingLanguageId::new).toList(), codeQuestion.getId());
    }

    private List<ProgrammingLanguageCodeQuestion> initLanguageCodeQuestion(List<ProgrammingLanguageDto> languages, CodeQuestion codeQuestion) {
        List<ProgrammingLanguageCodeQuestion> result = new ArrayList<>();
        for(int i = 0; i<languages.size(); ++i){
            result.add(codeAssessmentDomainService.initProgrammingLanguageCodeQuestion(
                    languages.get(i).getTimeLimit(),
                    languages.get(i).getMemoryLimit(),
                    languages.get(i).getBodyCode(),
                    codeQuestion.getId(),
                    languages.get(i).getId()));
        }
        return result;
    }

    @Transactional
    public void deleteProgrammingLanguageCodeQuestion(DeleteLanguageToCodeQuestionCommand command) {
        User user = validateHelper.validateUser(command.getUserId());
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());

//        if(!codeQuestion.getUserId().equals(user.getId()))
//            throw new CodeAssessmentDomainException("User " + codeQuestion.getUserId() + " does not possess code question " + command.getCodeQuestionId());

        List<ProgrammingLanguage> programmingLanguages = validateHelper.validateProgrammingLanguage(command.getLanguageIds());

        codeQuestionRepository.deleteLanguages(programmingLanguages.stream().map(BaseEntity::getId).toList(), codeQuestion.getId());
    }

    @Transactional
    public void addTagToCodeQuestion(AddTagToCodeQuestionCommand command) {
        if(command.getTagIds().isEmpty())
            return;

        User user = validateHelper.validateUser(command.getUserId());
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());

//        if(!codeQuestion.getUserId().equals(user.getId()))
//            throw new CodeAssessmentDomainException("User " + codeQuestion.getUserId() + " does not possess code question " + command.getCodeQuestionId());

        List<Tag> tags = validateHelper.validateTagsById(command.getTagIds());

        codeQuestionRepository.addTag(codeQuestion.getId(), tags);
    }

    public void deleteCodeQuestionTag(DeleteCodeQuestionTagCommand command) {
        if(command.getTagIds().isEmpty())
            return;

        User user = validateHelper.validateUser(command.getUserId());
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());

//        if(!codeQuestion.getUserId().equals(user.getId()))
//            throw new CodeAssessmentDomainException("User " + codeQuestion.getUserId() + " does not possess code question " + command.getCodeQuestionId());

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

    @Transactional
    public List<CodeQuestion> getRecommendedCodeQuestion(String email) {
        List<CodeQuestion> codeQuestions = new ArrayList<>();
        if(email == null)// not login
            codeQuestions = codeQuestionRepository.findTop3ByTop100RecentSubmitData();
        else{
            User user = validateHelper.validateUserByEmail(email);
            List<Tag> tags = codeSubmissionRepository.findTagByLastestSubmission(user.getId());
            if(!tags.isEmpty()) {//find base on previous tag
                codeQuestions.addAll(codeQuestionRepository.findByNotSolvedTagsAndUserId(tags, user.getId()));
                codeQuestions.addAll(codeQuestionRepository.findTop3ByTop100RecentSubmitData());
            }
            else//if no tag found
                codeQuestions = codeQuestionRepository.findTop3ByTop100RecentSubmitData();
        }

        //count people attend
        codeQuestions.stream().forEach(item->{
            Integer countPeople = codeSubmissionRepository.countPeopleAttend(item.getId());
            item.setNumberOfPeopleAttend(countPeople);
        });
        return codeQuestions;
    }

    public Page<CodeQuestion> getAdminCodeQuestions(GetCodeQuestionsQuery query) {
        User user = validateHelper.validateUserByEmail(query.getEmail());
        List<TagId> tagIds = query.getTagIds() == null || query.getTagIds().isEmpty()? null:
                query.getTagIds().stream().map(item->{
                            try {
                                return validateHelper.validateTagById(item).getId();
                            } catch (Exception e) {
                                return null;
                            }
                        })
                        .filter(Objects::nonNull)
                        .toList();

        Page<CodeQuestion> codeQuestions = codeQuestionRepository
                .adminFindAll(user.getId(),
                        tagIds,
                        query.getOrderBy(),
                        query.getSortBy(),
                        query.getPageNum(),
                        query.getPageSize(),
                        query.getDifficulty(),
                        query.getSearch(),
                        query.getIsPublic());
        return codeQuestions;
    }

    public CodeQuestion getAdminDetailCodeQuestion(AdminDetailCodeQuestionQuery query) {
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(query.getCodeQuestionId());

        List<TestCase> sampleTestCase = testCaseRepository.getTestCaseByCodeQuestionId(codeQuestion.getId());

        List<ProgrammingLanguageCodeQuestion> languages = programmingLanguageCodeQuestionRepository.findByCodeQuestionId(codeQuestion.getId());

        List<Tag> tags = codeQuestionRepository.findTagByCodeQuestionId(codeQuestion.getId());

        return codeAssessmentDomainService.getAdminDetailCodeQuestion(codeQuestion, sampleTestCase, languages, tags);
    }

    @Transactional
    public CodeQuestionsUpdatedEvent deleteCodeQuestion(UUID codeQuestionId) {
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(codeQuestionId);
        CodeQuestionsUpdatedEvent event = codeAssessmentDomainService.deleteCodeQuestion(codeQuestion);
        codeQuestionRepository.deleteById(codeQuestion.getId());
        return event;
    }
}
