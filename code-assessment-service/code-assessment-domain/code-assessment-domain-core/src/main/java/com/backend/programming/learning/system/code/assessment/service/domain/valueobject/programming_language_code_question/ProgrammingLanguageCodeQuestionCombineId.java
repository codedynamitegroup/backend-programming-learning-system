package com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.Objects;

public class ProgrammingLanguageCodeQuestionCombineId {
    private final ProgrammingLanguageId programmingLanguageId;
    private final CodeQuestionId codeQuestionId;

    public ProgrammingLanguageCodeQuestionCombineId(ProgrammingLanguageId programmingLanguageId, CodeQuestionId codeQuestionId) {
        this.programmingLanguageId = programmingLanguageId;
        this.codeQuestionId = codeQuestionId;
    }

    public ProgrammingLanguageId getProgrammingLanguageId() {
        return programmingLanguageId;
    }

    public CodeQuestionId getCodeQuestionId() {
        return codeQuestionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgrammingLanguageCodeQuestionCombineId that = (ProgrammingLanguageCodeQuestionCombineId) o;
        return Objects.equals(programmingLanguageId, that.programmingLanguageId) && Objects.equals(codeQuestionId, that.codeQuestionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmingLanguageId, codeQuestionId);
    }
}