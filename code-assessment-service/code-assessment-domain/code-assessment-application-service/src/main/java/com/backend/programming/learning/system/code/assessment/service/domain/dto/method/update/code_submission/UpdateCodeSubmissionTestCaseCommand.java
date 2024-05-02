package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class UpdateCodeSubmissionTestCaseCommand {
    String stdout;
    Float time;
    Float memory;
    @NotNull
    String token;
    String compile_output;
    String message;
    @NotNull
    Status status;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Status {
        @NotNull
        Integer id;
        @NotNull
        String description;
    }
    @Override
    public String toString() {
        return "UpdateCodeSubmissionTestCaseCommand{" +
                "stdout='" + stdout + '\'' +
                ", time=" + time +
                ", memory=" + memory +
                ", token='" + token + '\'' +
                ", compileOutput='" + compile_output + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status.description +
                '}';
    }
}
