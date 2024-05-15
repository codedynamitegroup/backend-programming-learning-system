package com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question;

import com.backend.programming.learning.system.domain.valueobject.BaseId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;

public class ProgrammingLanguageCodeQuestionId extends BaseId<ProgrammingLanguageCodeQuestionCombineId>{
    public ProgrammingLanguageCodeQuestionId(ProgrammingLanguageId programmingLanguageId, CodeQuestionId codeQuestionId) {
        super(new ProgrammingLanguageCodeQuestionCombineId(programmingLanguageId,codeQuestionId));
    }
}
