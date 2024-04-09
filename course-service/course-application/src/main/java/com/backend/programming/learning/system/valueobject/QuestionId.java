package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.rmi.server.UID;

public class QuestionId extends BaseId<UID> {
    public QuestionId(UID value) {
        super(value);
    }
}
