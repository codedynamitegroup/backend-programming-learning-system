package com.backend.programming.learning.system.course.service.domain.dto.method.query.activity_attachment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryActivityAttachmentCommand {
    private UUID assignmentId;
}
