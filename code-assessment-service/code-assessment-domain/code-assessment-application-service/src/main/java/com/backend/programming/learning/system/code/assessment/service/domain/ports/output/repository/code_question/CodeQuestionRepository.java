package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestionTag;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguageCodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Tag;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag.CodeQuestionTagId;
import com.backend.programming.learning.system.domain.valueobject.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CodeQuestionRepository {
    CodeQuestion save(CodeQuestion codeQuestion);
    Optional<CodeQuestion> findById(CodeQuestionId codeQuestionId);
    Optional<CodeQuestion> findByQuestionId(UUID questionId);
    void deleteCodeQuestionById(UUID id);

    void saveTags(List<CodeQuestionTagId> codeQuestionTagIds);

    Integer countAllCodeQuestion();

    Page<CodeQuestion> findAll(UserId id, List<TagId> tagIds, QueryOrderBy orderBy, CodeQuestion.Fields sortBy, Integer pageNum, Integer pageSize, QuestionDifficulty difficulty, Boolean solved, String search, boolean isPulic);

    void saveNewLanguage(List<ProgrammingLanguageCodeQuestion> plcqs);

    void deleteLanguage(List<ProgrammingLanguageId> list);

    void addTag(CodeQuestionId id, List<Tag> tags);

    Optional<CodeQuestionTag> findCodeQuestionTagById(CodeQuestionTagId id);

    void deleteCodeQuestionTag(List<CodeQuestionTag> tags);

    List<CodeQuestion> findTop3ByTop100RecentSubmitData();
}
