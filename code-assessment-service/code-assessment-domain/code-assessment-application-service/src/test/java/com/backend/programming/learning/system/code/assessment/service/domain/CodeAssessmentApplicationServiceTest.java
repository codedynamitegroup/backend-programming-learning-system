package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Question;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.CodeQuestionDataMaper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeQuestionApplicationService;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = CodeAssessmentTestConfiguration.class)
public class CodeAssessmentApplicationServiceTest {
    @Autowired
    private CodeQuestionApplicationService codeQuestionApplicationService;
    @Autowired
    private CodeQuestionDataMaper codeQuestionDataMaper;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CodeQuestionRepository codeQuestionRepository;

    private CreateCodeQuestionCommand command;
    private final UUID QUESTION_ID = UUID.fromString("9b1deb4d-3b7d-4bad-9bdd-2b0d7b3dcb6d");
    private final UUID CODEQUESTION_ID = UUID.fromString("9b1deb4d-3b7d-4bad-9bdd-2b0d7b3dcb61");

    @BeforeAll
    public void init(){
        command = CreateCodeQuestionCommand.builder()
                .questionId(QUESTION_ID)
                .dslTemplate("haha")
                .isDeleted(false)
                .problemStatement("haa")
                .inputFormat("ha")
                .outputFormat("hah")
                .build();
        Question question = Question.builder()
                .questionId(new QuestionId(QUESTION_ID))
                .generalFeedback("haha")
                .build();
        CodeQuestion codeQuestion = codeQuestionDataMaper.createCodeQuestionCommandToCodeQuestion(command);
        codeQuestion.setId(new CodeQuestionId(CODEQUESTION_ID));
        when(questionRepository.findQuestionInformation(QUESTION_ID)).thenReturn(Optional.of(question));

        when(codeQuestionRepository.save(any(CodeQuestion.class))).thenReturn(codeQuestion);
    }
    @Test
    public void testCreateCodeQuestion(){
        CreateCodeQuestionResponse response
                = codeQuestionApplicationService.createCodeQuestion(command);
        assertEquals(response.getMessage(), "Code question created successfully");
    }
}
