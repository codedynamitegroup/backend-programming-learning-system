package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguageCodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag.CodeQuestionTagId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import com.backend.programming.learning.system.domain.valueobject.UserId;
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

    Page<CodeQuestion> findAll(UserId id, List<TagId> tagIds, QueryOrderBy orderBy, CodeQuestion.Fields sortBy, Integer pageNum, Integer pageSize);

    void saveNewLanguage(List<ProgrammingLanguageCodeQuestion> plcqs);

    void deleteLanguage(List<ProgrammingLanguageId> list);
}
