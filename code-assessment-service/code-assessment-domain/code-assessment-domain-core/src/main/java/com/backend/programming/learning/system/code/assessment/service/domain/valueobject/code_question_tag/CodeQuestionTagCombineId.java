package com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.Objects;

public class CodeQuestionTagCombineId {
    final CodeQuestionId codeQuestionId;
    final TagId tagId;

    public CodeQuestionTagCombineId(CodeQuestionId codeQuestionId, TagId tagId) {
        this.codeQuestionId = codeQuestionId;
        this.tagId = tagId;
    }

    public CodeQuestionId getCodeQuestionId() {
        return codeQuestionId;
    }

    public TagId getTagId() {
        return tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeQuestionTagCombineId that = (CodeQuestionTagCombineId) o;
        return Objects.equals(codeQuestionId, that.codeQuestionId) && Objects.equals(tagId, that.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeQuestionId, tagId);
    }
}
