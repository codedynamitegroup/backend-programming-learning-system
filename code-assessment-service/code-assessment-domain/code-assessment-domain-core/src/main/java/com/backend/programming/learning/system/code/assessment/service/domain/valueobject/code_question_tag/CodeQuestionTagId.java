package com.backend.programming.learning.system.code.assessment.service.domain.valueobject.code_question_tag;

import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.TagId;
import com.backend.programming.learning.system.domain.valueobject.BaseId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

public class CodeQuestionTagId extends BaseId<CodeQuestionTagCombineId> {
    public CodeQuestionTagId(CodeQuestionId codeQuestionId, TagId tagId) {
        super(new CodeQuestionTagCombineId(codeQuestionId, tagId));
    }
}
