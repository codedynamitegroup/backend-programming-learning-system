package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class PlagiarismDetectionReportId extends BaseId<UUID> {
    public PlagiarismDetectionReportId(UUID value) {
        super(value);
    }
}
