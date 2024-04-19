package com.backend.programming.learning.system.domain.socket.emitter;

import com.backend.programming.learning.system.domain.socket.DomainSocketMessage;

public interface DomainSocketMessageEmitter<T extends DomainSocketMessage> {
    void emit(T domainMessage);
}
