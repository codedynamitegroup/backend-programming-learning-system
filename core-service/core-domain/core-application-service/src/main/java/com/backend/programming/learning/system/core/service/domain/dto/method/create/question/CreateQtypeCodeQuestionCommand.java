package com.backend.programming.learning.system.core.service.domain.dto.method.create.question;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class CreateQtypeCodeQuestionCommand extends CreateQuestionCommand {
    @NotNull(message = "inputFormat must not be null")
    private String inputFormat;

    @NotNull(message = "outputFormat must not be null")
    private String outputFormat;

    @NotNull(message = "constraint must not be null")
    private String constraint;

    @NotNull(message = "isPublic must not be null")
    private Boolean isPublic;

    @NotNull(message = "allowImport must not be null")
    private Boolean allowImport;

    public CreateQtypeCodeQuestionCommand(
            @NotNull(message = "Organization ID is required") UUID organizationId,
            @NotNull(message = "Created by is required") UUID createdBy,
            @NotNull(message = "Updated by is required") UUID updatedBy,
            @NotNull(message = "Difficulty by is required") String difficulty,
            @NotNull(message = "Name is required") String name,
            @NotNull(message = "Question text is required") String questionText,
            @NotNull(message = "General feedback is required") String generalFeedback,
            @NotNull(message = "Default mark is required") @DecimalMin(value = "0.0", inclusive = false, message = "Default mark must be greater than 0") @Digits(integer = 5, fraction = 2, message = "Default mark must have up to 5 digits and 2 decimals") BigDecimal defaultMark,
            @NotNull(message = "Question type is required") String qType,
            @NotNull(message = "Answers is required") List<AnswerOfQuestion> answers,
            UUID questionBankCategoryId,
            Boolean isOrgQuestionBank,
            String inputFormat,
            String outputFormat,
            String constraint,
            Boolean allowImport,
            Boolean isPublic
            ) {
        super(organizationId,
                createdBy,
                updatedBy,
                difficulty,
                name,
                questionText,
                generalFeedback,
                defaultMark,
                qType,
                answers,
                questionBankCategoryId,
                isOrgQuestionBank);
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.constraint = constraint;
        this.allowImport = allowImport;
        this.isPublic = isPublic;
    }
}
