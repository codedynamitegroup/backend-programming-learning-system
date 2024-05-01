package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_submission.CodeSubmissionJudgingServiceUnavailableException;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.assessment.AssessmentSourceCodeByTestCases;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeSubmissionTestCaseRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.GradingStatus;
import io.netty.handler.timeout.ReadTimeoutException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;

@Component
@Slf4j
public class AssessmentSourceCodeByTestCasesImpl_Assessment0 implements AssessmentSourceCodeByTestCases {

    private final CodeSubmissionRepository codeSubmissionRepository;
    private final CodeSubmissionTestCaseRepository codeSubmissionTestCaseRepository;

    public AssessmentSourceCodeByTestCasesImpl_Assessment0(CodeSubmissionRepository codeSubmissionRepository, CodeSubmissionTestCaseRepository codeSubmissionTestCaseRepository) {
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.codeSubmissionTestCaseRepository = codeSubmissionTestCaseRepository;
    }

    @Override
    public void judge(CodeSubmission codeSubmission) {
        Thread thread = new Thread(()-> {
            try {
                this.processSending(codeSubmission);
            } catch (Exception e) {
                if (e instanceof ReadTimeoutException || e instanceof WebClientRequestException){
                    //change codesubmission state if sending failed and throw error
                    codeSubmission.setGradingStatus(GradingStatus.GRADING_SYSTEM_UNAVAILABLE);
                    codeSubmissionRepository.save(codeSubmission);
                    throw new CodeSubmissionJudgingServiceUnavailableException("Judgement services are unavailable now. Please, try again later");
                }
                throw e;
            }
        });
        thread.start();

    }
    private void processSending(CodeSubmission codeSubmission){
        WebClient client = WebClient.create("http://localhost:2358");
        Token[] result = client.post()
                .uri("/submissions/batch?base64_encoded=true")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(codeSubmissionToRequestBody(codeSubmission)), RequestBody.class)
                .retrieve()
//                .onStatus(HttpStatus::is5xxServerError,
//                        clientResponse ->
//                                Mono.error(new CodeSubmissionJudgingServiceUnavailableException("Judgement services are unavailable now. Please, try again later")))
                .bodyToMono(Token[].class)
                .block();
        if(result != null) {
            for (int i = 0; i < result.length; ++i)
                codeSubmission.getCodeSubmissionTestCaseList().get(i).setJudgeToken(result[i].token.toString());
            codeSubmissionTestCaseRepository.save(codeSubmission.getCodeSubmissionTestCaseList());
        }

    }
    RequestBody codeSubmissionToRequestBody(CodeSubmission codeSubmission){
        return RequestBody.builder()
                .submissions(
                        codeSubmission.getCodeSubmissionTestCaseList().stream()
                                .map(codeSubmissionTestCase -> RequestTestCase.builder()
                                        .language_id(codeSubmission.getProgrammingLangaugeJudge0Id())
                                        .source_code(codeSubmission.getSourceCode())
                                        .stdin(Base64.getEncoder().encodeToString(codeSubmissionTestCase.getTestCase().getInputData().getBytes()))
                                        .expected_output(Base64.getEncoder().encodeToString(codeSubmissionTestCase.getTestCase().getOutputData().getBytes()))
                                        .cpu_time_limit(codeSubmission.getProgrammingLanguageCodeQuestion().getTimeLimit())
                                        .memory_limit(codeSubmission.getProgrammingLanguageCodeQuestion().getMemoryLimit())
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Token{
        UUID token;
    }
    @Builder
    @Getter
    static class RequestTestCase{
        Integer language_id;
        String source_code;
        String stdin;
        String expected_output;
        String callback_url;
        Float cpu_time_limit;
        Float memory_limit;
    }
    @Builder
    @Getter
    static class RequestBody{
        List<RequestTestCase> submissions;
    }
}
