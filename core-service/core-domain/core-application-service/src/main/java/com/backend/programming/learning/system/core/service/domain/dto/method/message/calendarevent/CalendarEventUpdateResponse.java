package com.backend.programming.learning.system.core.service.domain.dto.method.message.calendarevent;

import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CalendarEventUpdateResponse {
    private String id;
    private String sagaId;
    private UpdateState updateCalendarEventState;
    private List<String> failureMessages;
}
