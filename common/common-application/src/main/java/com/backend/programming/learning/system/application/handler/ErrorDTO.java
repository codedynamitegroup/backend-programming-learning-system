package com.backend.programming.learning.system.application.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * com.backend.programming.learning.system.application.handler
 * Create by Dang Ngoc Tien
 * Date 3/20/2024 - 11:21 PM
 * Description: ...
 */
@Data
@Builder
@AllArgsConstructor
public class ErrorDTO {
    private final String code;
    private final String message;
}
