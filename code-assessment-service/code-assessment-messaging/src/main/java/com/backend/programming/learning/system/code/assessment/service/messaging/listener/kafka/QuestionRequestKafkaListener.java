package com.backend.programming.learning.system.code.assessment.service.messaging.listener.kafka;

import com.backend.programming.learning.system.code.assessment.service.domain.exception.CodeAssessmentApplicationServiceException;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.QuestionRequestMessageListener;
import com.backend.programming.learning.system.code.assessment.service.messaging.mapper.QuestionMessagingDataMapper;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionRequestAvroModel;
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
public class QuestionRequestKafkaListener implements KafkaConsumer<QuestionRequestAvroModel> {
    private final QuestionMessagingDataMapper questionMessagingDataMapper;
    private final QuestionRequestMessageListener questionMessageListener;

    public QuestionRequestKafkaListener(
            QuestionMessagingDataMapper questionMessagingDataMapper,
            QuestionRequestMessageListener questionMessageListener) {
        this.questionMessagingDataMapper = questionMessagingDataMapper;
        this.questionMessageListener = questionMessageListener;
    }


    @Override
    @KafkaListener(id = "${kafka-consumer-config.question-request-consumer-group-id}",
            topics = "${code-assessment-service.question-request-code-assessment-topic-name}")
    public void receive(
            @Payload List<QuestionRequestAvroModel> messages,
            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
            @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of question request received with keys: {}, partitions: {} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(questionRequestAvroModel -> {
            try {
                switch (questionRequestAvroModel.getCopyState()) {
                    case DELETING:
                        log.info("Deleting question with id {}", questionRequestAvroModel.getId());
                        questionMessageListener.deleteQuestion(questionMessagingDataMapper
                                .questionRequestAvroModelToQuestionDeleteRequest(questionRequestAvroModel));
                        break;
                    case DELETE_ROLLBACKING:
                        log.info("Rollbacking delete question with id {}", questionRequestAvroModel.getId());
//                        questionMessageListener.rollbackDeleteQuestion(questionMessagingDataMapper
//                                .questionRequestAvroModelToQuestionDeleteRequest(questionRequestAvroModel));
                        break;
                }
            }
            catch (DataAccessException e) {
                SQLException sqlException = (SQLException) e.getRootCause();

                if (sqlException != null && sqlException.getSQLState() != null &&
                        PSQLState.UNIQUE_VIOLATION.getState().equals(sqlException.getSQLState())) {
                    //NO-OP for unique constraint exception
                    log.error("Caught unique constraint exception with sql state: {} " +
                                    "in QuestionRequestKafkaListener for user id: {}",
                            sqlException.getSQLState(), questionRequestAvroModel.getId());
                } else {
                    throw new CodeAssessmentApplicationServiceException("Throwing DataAccessException in" +
                            " CodeAssessmentRequestKafkaListener: " + e.getMessage(), e);
                }
            }
            catch (QuestionNotFoundException e) {
                //NO-OP for OrderNotFoundException
                log.error("No question found for question id: {}", questionRequestAvroModel.getId());
            }
        });
    }
}
