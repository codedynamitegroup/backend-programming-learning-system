package com.backend.programming.learning.system.dto.method.delete.exam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.delete.exam
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 11:18 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class DeleteExamCommand {
    private final UUID examId;
}
