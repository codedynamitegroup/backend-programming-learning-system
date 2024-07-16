package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.category_bank.CodeQuestionCategoryBankEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.tag.CodeQuestionTagEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.tag.CodeQuestionTagEntityId;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.mapper.CodeQuestionDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.mapper.CodeQuestionTagDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository.CodeQuestionCategoryBankJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository.CodeQuestionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository.CodeQuestionTagJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.repository.CodeSubmissionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.general_mapper.GeneralMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.mapper.ProgrammingLanguageCodeQuestionDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.repository.ProgrammingLanguageCodeQuestionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.tag.mapper.TagDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag.CodeQuestionTagId;
import com.backend.programming.learning.system.domain.valueobject.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class CodeQuestionRepositoryImpl implements CodeQuestionRepository {
    private final CodeQuestionJpaRepository codeQuestionJpaRepository;
    private final CodeQuestionDataAccessMapper codeQuestionDataAccessMapper;
    private final CodeQuestionTagJpaRepository codeQuestionTagJpaRepository;
    private final CodeQuestionTagDataAccessMapper codeQuestionTagDataAccessMapper;
    private final GeneralMapper generalMapper;
    private final CodeSubmissionJpaRepository codeSubmissionJpaRepository;
    private final ProgrammingLanguageCodeQuestionJpaRepository programmingLanguageCodeQuestionJpaRepository;
    private final ProgrammingLanguageCodeQuestionDataAccessMapper programmingLanguageCodeQuestionDataAccessMapper;
    private final TagDataAccessMapper tagDataAccessMapper;
    private final CodeQuestionCategoryBankJpaRepository codeQuestionCategoryBankJpaRepository;

    public CodeQuestionRepositoryImpl(CodeQuestionJpaRepository codeQuestionJpaRepository, CodeQuestionDataAccessMapper codeQuestionDataAccessMapper, CodeQuestionTagJpaRepository codeQuestionTagJpaRepository, CodeQuestionTagDataAccessMapper codeQuestionTagDataAccessMapper, GeneralMapper generalMapper, CodeSubmissionJpaRepository codeSubmissionJpaRepository, ProgrammingLanguageCodeQuestionJpaRepository programmingLanguageCodeQuestionJpaRepository, ProgrammingLanguageCodeQuestionDataAccessMapper programmingLanguageCodeQuestionDataAccessMapper, TagDataAccessMapper tagDataAccessMapper, CodeQuestionCategoryBankJpaRepository codeQuestionCategoryBankJpaRepository) {
        this.codeQuestionJpaRepository = codeQuestionJpaRepository;
        this.codeQuestionDataAccessMapper = codeQuestionDataAccessMapper;
        this.codeQuestionTagJpaRepository = codeQuestionTagJpaRepository;
        this.codeQuestionTagDataAccessMapper = codeQuestionTagDataAccessMapper;
        this.generalMapper = generalMapper;
        this.codeSubmissionJpaRepository = codeSubmissionJpaRepository;
        this.programmingLanguageCodeQuestionJpaRepository = programmingLanguageCodeQuestionJpaRepository;
        this.programmingLanguageCodeQuestionDataAccessMapper = programmingLanguageCodeQuestionDataAccessMapper;
        this.tagDataAccessMapper = tagDataAccessMapper;
        this.codeQuestionCategoryBankJpaRepository = codeQuestionCategoryBankJpaRepository;
    }

    @Override
    public CodeQuestion save(CodeQuestion codeQuestion) {

        CodeQuestionEntity codeQuestionEntity = codeQuestionDataAccessMapper.codeQuestionToCodeQuestionEntity(codeQuestion);
        CodeQuestionEntity codeQuestionEntityRes = codeQuestionJpaRepository
                .save(codeQuestionEntity);

        return
        codeQuestionDataAccessMapper.codeQuestionEntityToCodeQuestion(codeQuestionEntityRes);
    }

    @Override
    public Optional<CodeQuestion> findById(CodeQuestionId codeQuestionId) {
        return codeQuestionJpaRepository
                .findById(codeQuestionId.getValue())
                .map(codeQuestionDataAccessMapper::codeQuestionEntityToCodeQuestion);
    }

    @Override
    public Optional<CodeQuestion> findByQuestionId(UUID questionId) {
        return codeQuestionJpaRepository.findByQuestionId(questionId)
                .map(codeQuestionDataAccessMapper::codeQuestionEntityToCodeQuestion);
    }

    @Override
    public void deleteCodeQuestionById(UUID id){
        codeQuestionJpaRepository.deleteById(id);
    }

    @Override
    public void saveTags(List<CodeQuestionTagId> codeQuestionTagIds) {
        codeQuestionTagIds.stream().map(codeQuestionTagDataAccessMapper::idToEntity)
                .forEach(item ->{
                    try {
                        codeQuestionTagJpaRepository.save(item);
                    } catch (Exception e) {
                        log.error("Can not save tag {} with code question {}", item.getTag().getId(), item.getCodeQuestion().getId());
                    }
                });
    }

    @Override
    public Integer countAllCodeQuestion() {
        return (int) codeQuestionJpaRepository.count();
    }

    @Override
    public Page<CodeQuestion> findAll(UserId userId, List<TagId> tagIds, QueryOrderBy orderBy, CodeQuestion.Fields sortBy, Integer pageNum, Integer pageSize, QuestionDifficulty difficulty, Boolean solved, String search, boolean isPublic) {
        Pageable pageable
                = PageRequest
                .of(pageNum, pageSize);
//                                codeQuestionDataAccessMapper.codeQuestionFieldToCodeQuestionEntityField(sortBy.name())));

        List<UUID> tagEntityId = tagIds == null? List.of(): tagIds.stream().map(BaseId::getValue).toList();

        List<String> splitedSearch = codeQuestionDataAccessMapper.splitWords(search);

        String searchFinalWord = splitedSearch != null && !splitedSearch.isEmpty()? splitedSearch.get(splitedSearch.size() - 1): null;

        if(splitedSearch != null && !splitedSearch.isEmpty())
            splitedSearch.remove(splitedSearch.size() - 1);

        String searchExcludeFinalWord =  splitedSearch != null && !splitedSearch.isEmpty()? String.join(" ", splitedSearch) : null;

        Page<CodeQuestionEntity> codeQuestionEntityPageable =
                codeQuestionJpaRepository.findAndFilterByTagIds(
                        tagEntityId,
                        searchExcludeFinalWord,
                        searchFinalWord,
                        difficulty == null? null: difficulty.name(),
                        solved,
                        userId != null ? userId.getValue(): null,
                        isPublic,
                        search,
                        pageable);

        Page<CodeQuestion> codeQuestions = codeQuestionEntityPageable.map(item->{
            //if userId == null then done = false
            boolean done = false;

            //if solved does not exist, then we must find the done in every question
            if (userId != null && solved == null) {
                Optional<CodeSubmissionEntity> submissionEntity
                        = codeSubmissionJpaRepository
                        .findFirstByUserIdAndCodeQuestionIdAndGrade(
                                userId.getValue(),
                                item.getId(),
                                item.getMaxGrade().doubleValue());
                if(submissionEntity.isPresent())
                    done = true;
            }
            //if solved exist then the result follow by solved
            if(userId != null && solved != null)
                done = solved;

            return codeQuestionDataAccessMapper.codeQuestionEntityToCodeQuestion(item, done);
        });

        return codeQuestions;
    }

    @Override
    public void saveNewLanguage(List<ProgrammingLanguageCodeQuestion> plcqs) {
        programmingLanguageCodeQuestionJpaRepository
                .saveAll(plcqs.stream()
                        .map(programmingLanguageCodeQuestionDataAccessMapper::domainObjectToEntity)
                        .toList());
    }

    @Override
    public void deleteLanguages(List<ProgrammingLanguageId> list, CodeQuestionId id) {
        programmingLanguageCodeQuestionJpaRepository
                .deleteAllById(list.stream()
                        .map(item->
                                programmingLanguageCodeQuestionDataAccessMapper.programmingLanguageIdAndCodeQuesitonIdToEntityId(item, id))
                        .toList());
    }

    @Override
    public void addTag(CodeQuestionId id, List<Tag> tags) {

        List<CodeQuestionTagEntity> entities = tags.stream()
                        .map(item->codeQuestionTagDataAccessMapper.codeQuestionIdAndTagIdToEntity(id, item.getId()))
                                .toList();
        codeQuestionTagJpaRepository.saveAll(entities);
    }

    @Override
    public Optional<CodeQuestionTag> findCodeQuestionTagById(CodeQuestionTagId id) {
        return codeQuestionTagJpaRepository.findById(codeQuestionTagDataAccessMapper.idToEntityId(id)).map(codeQuestionTagDataAccessMapper::entityToCodeQuestionTag);
    }

    @Override
    public void deleteCodeQuestionTag(List<CodeQuestionTag> tags) {
        List<CodeQuestionTagEntityId> cqteids = tags.stream().map(item->codeQuestionTagDataAccessMapper.idToEntityId(item.getId())).toList();
        codeQuestionTagJpaRepository.deleteAllById(cqteids);
    }

    @Override
    public List<CodeQuestion> findTop3ByTop100RecentSubmitData() {
        List<CodeQuestionEntity> entities = codeQuestionJpaRepository.findTop3ByTop100RecentSubmitData();
//        List<UUID> ids = codeQuestionJpaRepository.findTop3ByTop100RecentSubmitData();
//        List<CodeQuestionEntity> entities = ids.stream().map(id->{
//            Optional<CodeQuestionEntity> entity = codeQuestionJpaRepository.findById(id);
//            return entity.orElse(null);
//        }).filter(Objects::nonNull)
//                .toList();
        return entities.stream().map(codeQuestionDataAccessMapper::codeQuestionEntityToCodeQuestion).toList();
    }

    @Override
    public List<CodeQuestion> findByNotSolvedTagsAndUserId(List<Tag> tags, UserId id) {
        List<UUID> tagIds = tags.stream().map(i->i.getId().getValue()).toList();
        List<CodeQuestionEntity> codeQuestionEntities = codeQuestionJpaRepository.findByNotSolvedTagsAndUserId(tagIds, id.getValue());
        return codeQuestionEntities.stream().map(codeQuestionDataAccessMapper::codeQuestionEntityToCodeQuestion).toList();
    }

    @Override
    public Page<CodeQuestion> adminFindAll(UserId userId, List<TagId> tagIds, QueryOrderBy orderBy, CodeQuestion.Fields sortBy, Integer pageNum, Integer pageSize, QuestionDifficulty difficulty, String search, Boolean isPublic) {
        Pageable pageable
                = PageRequest
                .of(pageNum, pageSize);
//                                codeQuestionDataAccessMapper.codeQuestionFieldToCodeQuestionEntityField(sortBy.name())));

        List<UUID> tagEntityId = tagIds == null? List.of(): tagIds.stream().map(BaseId::getValue).toList();

        List<String> splitedSearch = codeQuestionDataAccessMapper.splitWords(search);

        String searchFinalWord = splitedSearch != null && !splitedSearch.isEmpty()? splitedSearch.get(splitedSearch.size() - 1): null;

        if(splitedSearch != null && !splitedSearch.isEmpty())
            splitedSearch.remove(splitedSearch.size() - 1);

        String searchExcludeFinalWord =  splitedSearch != null && !splitedSearch.isEmpty()? String.join(" ", splitedSearch) : null;

        Page<CodeQuestionEntity> codeQuestionEntityPageable =
                codeQuestionJpaRepository.adminFindAndFilterByTagIds(
                        tagEntityId,
                        searchExcludeFinalWord,
                        searchFinalWord,
                        difficulty == null? null: difficulty.name(),
                        isPublic,
                        search,
                        pageable);

        Page<CodeQuestion> codeQuestions = codeQuestionEntityPageable.map(codeQuestionDataAccessMapper::codeQuestionEntityToCodeQuestion);

        return codeQuestions;
    }

    @Override
    public Optional<CodeQuestion> findByName(String name) {
        return codeQuestionJpaRepository.findByName(name).map(codeQuestionDataAccessMapper::codeQuestionEntityToCodeQuestion);
    }

    @Override
    public List<Tag> findTagByCodeQuestionId(CodeQuestionId id) {
        List<CodeQuestionTagEntity> entities = codeQuestionTagJpaRepository.findAllByCodeQuestionId(id.getValue());

        return entities.stream().map(CodeQuestionTagEntity::getTag).map(tagDataAccessMapper::entityToTagIgnoreLazy).toList();
    }

    @Override
    public void saveCategory(CodeQuestionId id, UUID categoryBankId) {
        codeQuestionCategoryBankJpaRepository.save(CodeQuestionCategoryBankEntity.builder()
                        .categoryBankId(categoryBankId)
                        .codeQuestionId(id.getValue())
                .build());
    }

    @Override
    public void deleteCategory(CodeQuestionId id) {
        codeQuestionCategoryBankJpaRepository.deleteById(id.getValue());
    }

    @Override
    public void deleteById(CodeQuestionId id) {
        codeQuestionJpaRepository.deleteById(id.getValue());
    }


    @Override
    public Optional<CodeQuestion> findQuestionId(UUID id) {
        return codeQuestionJpaRepository.findByQuestionId(id)
                .map(codeQuestionDataAccessMapper::codeQuestionEntityToCodeQuestion);
    }
}
