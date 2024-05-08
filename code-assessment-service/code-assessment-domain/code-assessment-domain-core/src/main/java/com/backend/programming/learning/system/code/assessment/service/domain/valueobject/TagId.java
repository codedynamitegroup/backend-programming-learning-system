package com.backend.programming.learning.system.code.assessment.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class TagId extends BaseId<UUID> {
    public TagId(UUID id){
        super(id);
    }
}
