package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.rmi.server.UID;

public class QuestionId extends BaseId<UID> {
    public QuestionId(UID value) {
        super(value);
    }
}
