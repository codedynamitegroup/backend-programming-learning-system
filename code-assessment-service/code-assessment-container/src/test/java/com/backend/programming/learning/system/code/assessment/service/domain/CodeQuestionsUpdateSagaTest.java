package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.entity.CodeQuestionsUpdateOutboxEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.repository.CodeQuestionsUpdateOutboxJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.CodeQuestionsUpdateResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.codequestion.CodeQuestionsUpdateSaga;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.saga.SagaStatus;
import com.backend.programming.learning.system.saga.code_assessment.SagaConstants;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest(classes = CodeAssessmentServiceApplication.class)
@Sql(value={"classpath:sql/setup.sql"})
@Sql(value={"classpath:sql/cleanup.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CodeQuestionsUpdateSagaTest {
    @Autowired
    private CodeQuestionsUpdateSaga codeQuestionsUpdateSaga;

    @Autowired
    private CodeQuestionsUpdateOutboxJpaRepository codeQuestionsUpdateOutboxJpaRepository;

    private final UUID SAGA_ID = UUID.fromString("15a497c1-0f4b-4eff-b9f4-c402c8c07afa");
    private final UUID CODE_QUESTION_ID = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb17");
    private final UUID QUESTION_ID = UUID.fromString("f705404f-5971-455e-9c34-93a0ce5b90b3");
//    private final UUID PAYMENT_ID = UUID.randomUUID();

    @Test
    void testDoubleCopy(){
        codeQuestionsUpdateSaga.process(getCodeQuestionsUpdateResponse());
        codeQuestionsUpdateSaga.process(getCodeQuestionsUpdateResponse());
    }

    private CodeQuestionsUpdateResponse getCodeQuestionsUpdateResponse() {
        return CodeQuestionsUpdateResponse.builder()
                .id(UUID.randomUUID())
                .codeQuestionId(CODE_QUESTION_ID)
                .questionId(QUESTION_ID)
                .problemStatement("pro statement")
                .inputFormat("input")
                .outputFormat("output")
                .state(CopyState.CREATED)
                .constraints("constraints")
                .failureMessages(new ArrayList<>())
                .sagaId(SAGA_ID)
                .build();
    }
    @Test
    void testDoubleCopyWithThreads() throws InterruptedException {
        Thread thread1 = new Thread(() -> codeQuestionsUpdateSaga.process(getCodeQuestionsUpdateResponse()));
        Thread thread2 = new Thread(() -> codeQuestionsUpdateSaga.process(getCodeQuestionsUpdateResponse()));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertCodeQuestionsUpdateOutbox();
    }

    private void assertCodeQuestionsUpdateOutbox() {
        Optional<CodeQuestionsUpdateOutboxEntity> entityOptional =
                codeQuestionsUpdateOutboxJpaRepository.findByTypeAndSagaIdAndSagaStatusIn(SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME, SAGA_ID,
                        List.of(SagaStatus.SUCCEEDED));
        assertTrue(entityOptional.isPresent());
    }
}
