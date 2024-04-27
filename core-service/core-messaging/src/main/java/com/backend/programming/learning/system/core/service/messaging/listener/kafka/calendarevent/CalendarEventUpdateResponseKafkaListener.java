package com.backend.programming.learning.system.core.service.messaging.listener.kafka.calendarevent;

import com.backend.programming.learning.system.core.service.domain.mapper.calendarevent.CalendarEventDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.calendarevent.CalendarEventUpdateResponseMessageListener;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.CalendarEventUpdateResponseAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CalendarEventUpdateResponseKafkaListener implements KafkaConsumer<CalendarEventUpdateResponseAvroModel> {

    private final CalendarEventUpdateResponseMessageListener calendarEventUpdateResponseMessageListener;
    private final CalendarEventDataMapper calendarEventDataMapper;

    public CalendarEventUpdateResponseKafkaListener(
            CalendarEventUpdateResponseMessageListener calendarEventUpdateResponseMessageListener,
            CalendarEventDataMapper calendarEventDataMapper) {
        this.calendarEventUpdateResponseMessageListener = calendarEventUpdateResponseMessageListener;
        this.calendarEventDataMapper = calendarEventDataMapper;
    }

    @Override
    public void receive(List<CalendarEventUpdateResponseAvroModel> messages,
                        List<String> keys,
                        List<Integer> partitions,
                        List<Long> offsets) {

    }
}
