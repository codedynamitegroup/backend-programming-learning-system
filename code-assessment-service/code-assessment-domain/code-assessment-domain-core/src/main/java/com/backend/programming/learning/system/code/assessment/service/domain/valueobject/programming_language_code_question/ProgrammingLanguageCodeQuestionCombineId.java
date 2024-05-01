package com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

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
}