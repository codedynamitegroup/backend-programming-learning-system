package com.backend.programming.learning.system.course.service.messaging.listener.kafka;

import com.backend.programming.learning.system.course.service.domain.exception.CourseApplicationServiceException;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.question.QuestionMessageListener;
import com.backend.programming.learning.system.course.service.messaging.mapper.QuestionMessagingMapper;
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
    private final QuestionMessagingMapper questionMessagingDataMapper;
    private final QuestionMessageListener questionMessageListener;

    public QuestionRequestKafkaListener(QuestionMessagingMapper questionMessagingDataMapper,
                                              QuestionMessageListener questionMessageListener) {
        this.questionMessagingDataMapper = questionMessagingDataMapper;
        this.questionMessageListener = questionMessageListener;
    }


    @Override
    @KafkaListener(id = "${kafka-consumer-config.question-request-consumer-group-id}", topics = "${course-service.question-request-topic-name}")
    public void receive(
            @Payload List<QuestionRequestAvroModel> messages,
            @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
            @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
            @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

        log.info("{} number of question request received with keys: {}, partitions: {} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(questionRequestAvroModel -> {
            try {
                switch (questionRequestAvroModel.getCopyState()) {
                    case CREATING:
                        log.info("Creating question with id {}", questionRequestAvroModel.getId());
                        questionMessageListener.createQuestion(questionMessagingDataMapper
                                .questionRequestAvroModelToQuestionCreateRequest(questionRequestAvroModel));
                        break;
                    case UPDATING:
                        log.info("Updating question with id {}", questionRequestAvroModel.getId());
                        questionMessageListener.updateQuestion(questionMessagingDataMapper
                                .questionRequestAvroModelToQuestionUpdateRequest(questionRequestAvroModel));
                        break;
                    case DELETING:
                        log.info("Deleting question with id {}", questionRequestAvroModel.getId());
                        questionMessageListener.deleteQuestion(questionMessagingDataMapper
                                .questionRequestAvroModelToQuestionDeleteRequest(questionRequestAvroModel));
                        break;
                    case CREATE_ROLLBACKING:
                        log.info("Rolling back create question with id {}", questionRequestAvroModel.getId());
                        break;
                    case UPDATE_ROLLBACKING:
                        log.info("Rolling back update question with id {}", questionRequestAvroModel.getId());
                        break;
                    case DELETE_ROLLBACKING:
                        log.info("Rolling back delete question with id {}", questionRequestAvroModel.getId());
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
                    throw new CourseApplicationServiceException("Throwing DataAccessException in" +
                            " CourseRequestKafkaListener: " + e.getMessage(), e);
                }
            }
            catch (QuestionNotFoundException e) {
                    //NO-OP for OrderNotFoundException
                    log.error("No question found for question id: {}", questionRequestAvroModel.getId());
            }
        });
    }
}
