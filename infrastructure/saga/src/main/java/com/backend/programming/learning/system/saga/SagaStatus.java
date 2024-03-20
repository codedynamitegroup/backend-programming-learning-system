package com.backend.programming.learning.system.saga;

/**
 * com.backend.programming.learning.system.saga
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 12:00 AM
 * Description: ...
 */
public enum SagaStatus {
    STARTED, FAILED, SUCCEEDED, PROCESSING, COMPENSATING, COMPENSATED
}
