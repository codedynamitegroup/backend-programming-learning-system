package com.backend.programming.learning.system.saga;


public interface SagaStep<T> {
    void process(T data);
    void rollback(T data);
}
