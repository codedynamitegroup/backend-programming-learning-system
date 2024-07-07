package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.redis;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;

public interface CodeQuestionRedisService {
    void clearAllCodeQuestions();
    GetCodeQuestionsResponse getAllCodeQuestions(Integer pageNo,
                                                 Integer pageSize,
                                                 QueryOrderBy orderBy,
                                                 QuestionDifficulty difficulty);
    void saveAllCodeQuestions(GetCodeQuestionsResponse getCodeQuestionsResponse,
                              Integer pageNo,
                              Integer pageSize,
                              QueryOrderBy orderBy,
                              QuestionDifficulty difficulty);
}
