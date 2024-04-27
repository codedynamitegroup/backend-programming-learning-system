package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.codequestion.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.codequestion.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Question;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_question.CodeQuestionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdatePayload;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeQuestionApplicationService;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionsUpdateOutboxRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import com.backend.programming.learning.system.saga.code_assessment.SagaConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;
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
    private CodeQuestionDataMapper codeQuestionDataMaper;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CodeQuestionRepository codeQuestionRepository;
    @Autowired
    private CodeQuestionsUpdateOutboxRepository codeQuestionsUpdateOutboxRepository;
    @Autowired
    private ObjectMapper objectMapper;

    private CreateCodeQuestionCommand command;
    private final UUID QUESTION_ID = UUID.fromString("9b1deb4d-3b7d-4bad-9bdd-2b0d7b3dcb6d");
    private final UUID CODEQUESTION_ID = UUID.fromString("9b1deb4d-3b7d-4bad-9bdd-2b0d7b3dcb61");
    private final UUID SAGA_ID = UUID.fromString("9b1deb4d-3b7d-4bad-9bdd-2b0d7b3dc100");

    @BeforeAll
    public void init(){
        command = CreateCodeQuestionCommand.builder()
                .questionId(QUESTION_ID)
                .dslTemplate("haha")
                .problemStatement("haa")
                .inputFormat("ha")
                .outputFormat("hah")
                .constraints("haha")
                .build();
        Question question = Question.builder()
                .questionId(new QuestionId(QUESTION_ID))
                .generalFeedback("haha")
                .build();
        CodeQuestion codeQuestion = codeQuestionDataMaper.createCodeQuestionCommandToCodeQuestion(command);
        codeQuestion.setId(new CodeQuestionId(CODEQUESTION_ID));
        when(questionRepository.findQuestionInformation(QUESTION_ID)).thenReturn(Optional.of(question));

        when(codeQuestionRepository.save(any(CodeQuestion.class))).thenReturn(codeQuestion);
        when(codeQuestionsUpdateOutboxRepository.save(any(CodeQuestionsUpdateOutboxMessage.class)))
                .thenReturn(getCodeQuestionsUpdateOutboxMessage());
    }
    private CodeQuestionsUpdateOutboxMessage getCodeQuestionsUpdateOutboxMessage(){
        CodeQuestionsUpdatePayload codeQuestionsUpdatePayload
                = CodeQuestionsUpdatePayload.builder()
                .id(CODEQUESTION_ID.toString())
                .questionId(QUESTION_ID.toString())
                .problemStatement("haa")
                .inputFormat("ha")
                .outputFormat("hah")
                .constraints("haha")
                .copyState(CopyState.CREATING.name())
                .build();
        return CodeQuestionsUpdateOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(SAGA_ID)
                .createdAt(ZonedDateTime.now())
                .type(SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME)
                .payload(createPayload(codeQuestionsUpdatePayload))
                .copyState(CopyState.CREATING)
                .sagaStatus(SagaStatus.STARTED)
                .outboxStatus(OutboxStatus.STARTED)
                .version(0)
                .build();

    }
    private String createPayload(CodeQuestionsUpdatePayload payload) {
        try {
            return objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            throw new CodeAssessmentDomainException("Cannot create CodeQuestionsUpdatePayload object!");
        }
    }
    @Test
    public void testCreateCodeQuestion(){
        CreateCodeQuestionResponse response
                = codeQuestionApplicationService.createCodeQuestion(command);
        assertEquals(response.getMessage(), "Code question created successfully");
    }
}
