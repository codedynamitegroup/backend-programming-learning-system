package com.backend.programming.learning.system.core.service.messaging.listener.kafka.user.code_questions;

import com.backend.programming.learning.system.core.service.domain.exception.CoreApplicationServiceException;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeCodeQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.code_questions.CodeQuestionUpdateRequestMessageListener;
import com.backend.programming.learning.system.core.service.messaging.mapper.CodeQuestionsMessagingDataMapper;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateRequestAvroModel;
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
public class CodeQuestionsUpdateRequestMessageKafkaListener
    implements KafkaConsumer<CodeQuestionUpdateRequestAvroModel>
{
    private final CodeQuestionsMessagingDataMapper dataMapper;
    private final CodeQuestionUpdateRequestMessageListener listener;
    public CodeQuestionsUpdateRequestMessageKafkaListener(CodeQuestionsMessagingDataMapper dataMapper, CodeQuestionUpdateRequestMessageListener listener) {
        this.dataMapper = dataMapper;
        this.listener = listener;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.code-question-update-consumer-group-id}",
            topics = "${core-service.code-question-update-request-to-core-service-topic-name}")
    public void receive(@Payload List<CodeQuestionUpdateRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets){
        log.info("{} number of code-question-update-request received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(avroModel -> {
            try {
                switch (avroModel.getCopyState()){
                    case CREATING ->{
                        log.info("Processing update for code question id: {}", avroModel.getCodeQuestionId());
                        listener.persistCodeQuestion(dataMapper
                                .codeQuestionUpdateRequestAvroModelToCodeQuestionsUpdateRequest(avroModel));
                    }
                    case UPDATING ->{
                        log.info("Processing update for code question id: {}", avroModel.getCodeQuestionId());
                        listener.updateCodeQuestion(dataMapper
                                .codeQuestionUpdateRequestAvroModelToCodeQuestionsUpdateRequest(avroModel));
                    }
                    case DELETING ->{
                        log.info("Processing update for code question id: {}", avroModel.getCodeQuestionId());
                        listener.deleteCodeQuestion(dataMapper
                                .codeQuestionUpdateRequestAvroModelToCodeQuestionsUpdateRequest(avroModel));
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
