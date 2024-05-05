package com.backend.programming.learning.system.gateway.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoreServiceFallbackModel {
    private String fallbackMessage;
}