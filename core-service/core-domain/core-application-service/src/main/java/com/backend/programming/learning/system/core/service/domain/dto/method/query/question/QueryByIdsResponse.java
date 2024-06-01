package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * com.backend.programming.learning.system.core.service.domain.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 5/31/2024 - 11:26 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryByIdsResponse {
    List<Object> questionResponses;
}
