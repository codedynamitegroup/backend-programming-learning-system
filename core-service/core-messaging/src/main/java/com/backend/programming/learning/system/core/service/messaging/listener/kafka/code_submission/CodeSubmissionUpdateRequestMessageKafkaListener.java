package com.backend.programming.learning.system.core.service.messaging.listener.kafka.code_submission;

import com.backend.programming.learning.system.core.service.domain.exception.CoreApplicationServiceException;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeCodeQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.code_submission.CodeSubmissionUpdateRequestMessageListener;
import com.backend.programming.learning.system.core.service.messaging.mapper.CodeSubmissionMessagingDataMapper;
import com.backend.programming.learning.system.kafka.code.assessment.code.submission.avro.model.CodeSubmissionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PSQLState;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Component
public class CodeSubmissionUpdateRequestMessageKafkaListener implements KafkaConsumer<CodeSubmissionUpdateRequestAvroModel> {
    final CodeSubmissionMessagingDataMapper dataMapper;
    final CodeSubmissionUpdateRequestMessageListener listener;

    public CodeSubmissionUpdateRequestMessageKafkaListener(CodeSubmissionMessagingDataMapper dataMapper, CodeSubmissionUpdateRequestMessageListener listener) {
        this.dataMapper = dataMapper;
        this.listener = listener;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.code-submission-update-consumer-group-id}",
            topics = "${core-service.code-submission-update-request-to-core-service-topic-name}")
    public void receive(@Payload List<CodeSubmissionUpdateRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of code-submission-update-request received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(avroModel -> {
            try {
                switch (avroModel.getCopyState()){
                    case CREATING ->{
                        log.info("Processing update for code submission id: {}", avroModel.getCodeSubmisisonId());
                        listener.persistCodeSubmission(dataMapper
                                .codeSubmissionUpdateRequestAvroModelToCodeSubmissionUpdateRequest(avroModel));
                    }
                    case UPDATING ->{
                        log.info("Processing update for code question id: {}", avroModel.getCodeQuestionId());
                        listener.updateCodeSubmission(dataMapper
                                .codeSubmissionUpdateRequestAvroModelToCodeSubmissionUpdateRequest(avroModel));
                    }
                }
            } catch (DataAccessException e) {
                SQLException sqlException = (SQLException) e.getRootCause();
                if (sqlException != null && sqlException.getSQLState() != null &&
                        PSQLState.UNIQUE_VIOLATION.getState().equals(sqlException.getSQLState())) {
                    //NO-OP for unique constraint exception
                    log.error("Caught unique constraint exception with sql state: {} " +
                                    "in CodeQuestionsUpdateRequestMessageKafkaListener for code question id: {}",
                            sqlException.getSQLState(), avroModel.getCodeQuestionId());
                } else {
                    throw new CoreApplicationServiceException("Throwing DataAccessException in" +
                            " CodeQuestionsUpdateRequestMessageKafkaListener: " + e.getMessage(), e);
                }
            } catch (QtypeCodeQuestionNotFoundException e) {
                //NO-OP for PaymentNotFoundException
                log.error("No code question found for id: {}", avroModel.getCodeQuestionId());
            }
        });
    }
}
