package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.container.CoreServiceApplication;
import com.backend.programming.learning.system.core.service.dataaccess.code_questions_update_outbox.entity.CodeQuestionsUpdateOutboxEntity;
import com.backend.programming.learning.system.core.service.dataaccess.code_questions_update_outbox.repository.CodeQuestionsUpdateOutboxJpaRepository;
import com.backend.programming.learning.system.core.service.domain.dto.message.CodeQuestionsUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.code_questions.CodeQuestionUpdateRequestMessageListener;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.code_assessment.SagaConstants;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest(classes = CoreServiceApplication.class)
public class CodeQuestionUpdateRequestMessageListenerTest {
    @Autowired
    private CodeQuestionUpdateRequestMessageListener listener;

    @Autowired
    private CodeQuestionsUpdateOutboxJpaRepository jpaRepository;

    private final static String QUESTION_ID = "b6484e21-6937-489c-b031-b71767994221";
    @Test
    void testDoublePersist() {
        String sagaId = UUID.randomUUID().toString();
        CodeQuestionsUpdateRequest request = getCodeQuestionRequest(sagaId);
        listener.persistCodeQuestion(request);
        try {
            listener.persistCodeQuestion(request);
        } catch (DataAccessException e) {
            log.error("DataAccessException occurred with sql state: {}",
                    ((PSQLException) Objects.requireNonNull(e.getRootCause())).getSQLState());
        }
        assertCodeQuestionOutbox(sagaId);
    }
    @Test
    void testDoublePersistWithThreads() {
        String sagaId = UUID.randomUUID().toString();
        ExecutorService executor = null;
        CodeQuestionsUpdateRequest request = getCodeQuestionRequest(sagaId);


        try {
            executor = Executors.newFixedThreadPool(2);
            List<Callable<Object>> tasks = new ArrayList<>();

            tasks.add(Executors.callable(() -> {
                try {
                    listener.persistCodeQuestion(request);
                } catch (DataAccessException e) {
                    log.error("DataAccessException occurred for thread 1 with sql state: {}",
                            ((PSQLException) Objects.requireNonNull(e.getRootCause())).getSQLState());
                }
            }));

            tasks.add(Executors.callable(() -> {
                try {
                    listener.persistCodeQuestion(request);
                } catch (DataAccessException e) {
                    log.error("DataAccessException occurred for thread 2 with sql state: {}",
                            ((PSQLException) Objects.requireNonNull(e.getRootCause())).getSQLState());
                }
            }));

            executor.invokeAll(tasks);

            assertCodeQuestionOutbox(sagaId);
        } catch (InterruptedException e) {
            log.error("Error calling complete payment!", e);
        } finally {
            if (executor != null) {
                executor.shutdown();
            }
        }
    }


    private CodeQuestionsUpdateRequest getCodeQuestionRequest(String sagaId) {
        return CodeQuestionsUpdateRequest.builder()
                .id(UUID.randomUUID().toString())
                .codeQuestionId(UUID.randomUUID().toString())
                .sagaId(sagaId)
                .questionId(QUESTION_ID)
                .problemStatement("pro")
                .inputFormat("in")
                .outputFormat("out")
                .constraints("constraints")
                .state(CopyState.CREATING.name())
                .build();
    }

    private void assertCodeQuestionOutbox(String sagaId) {
        Optional<CodeQuestionsUpdateOutboxEntity> entityOptional = jpaRepository
                .findByTypeAndSagaIdAndCopyStateAndOutboxStatus(SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME,
                        UUID.fromString(sagaId),
                        CopyState.CREATED,
                        OutboxStatus.STARTED);
        assertTrue(entityOptional.isPresent());
        assertEquals(entityOptional.get().getSagaId().toString(), sagaId);
    }
}
