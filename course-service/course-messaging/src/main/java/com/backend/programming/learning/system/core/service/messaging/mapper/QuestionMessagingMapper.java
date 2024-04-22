package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.dto.method.message.QuestionDeleteRequest;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionDeleteRequestAvroModel;
import org.springframework.stereotype.Component;

@Component
public class QuestionMessagingMapper {
    public QuestionDeleteRequest questionDeleteRequestAvroModelToQuestionDeleteRequest(QuestionDeleteRequestAvroModel questionDeleteRequestAvroModel) {
        return QuestionDeleteRequest.builder()
                .id(questionDeleteRequestAvroModel.getId())
                .build();
    }


}
