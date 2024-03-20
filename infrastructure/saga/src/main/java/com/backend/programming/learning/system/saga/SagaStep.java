package com.backend.programming.learning.system.saga;

/**
 * com.backend.programming.learning.system.saga
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 12:01 AM
 * Description: ...
 */
public interface SagaStep<T> {
    void process(T data);
    void rollback(T data);
}

