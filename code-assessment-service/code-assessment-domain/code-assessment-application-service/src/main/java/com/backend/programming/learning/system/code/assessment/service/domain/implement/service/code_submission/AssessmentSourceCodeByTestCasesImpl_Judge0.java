package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.config.CodeAssessmentServiceConfigData;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmissionTestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_submission.CodeSubmissionJudgingServiceUnavailableException;
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
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Slf4j
public class AssessmentSourceCodeByTestCasesImpl_Judge0 implements AssessmentSourceCodeByTestCases {

    private final CodeSubmissionRepository codeSubmissionRepository;
    private final CodeSubmissionTestCaseRepository codeSubmissionTestCaseRepository;
    private final CodeAssessmentServiceConfigData codeAssessmentServiceConfigData;

    public AssessmentSourceCodeByTestCasesImpl_Judge0(CodeSubmissionRepository codeSubmissionRepository, CodeSubmissionTestCaseRepository codeSubmissionTestCaseRepository, CodeAssessmentServiceConfigData codeAssessmentServiceConfigData) {
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.codeSubmissionTestCaseRepository = codeSubmissionTestCaseRepository;
        this.codeAssessmentServiceConfigData = codeAssessmentServiceConfigData;
    }

    @Override
    public void judge(CodeSubmission codeSubmission) {
        Thread thread1 = new Thread(()-> {
            try {
                this.processSending(codeSubmission);
            } catch (Exception e) {
                if (e instanceof ReadTimeoutException || e instanceof WebClientRequestException || e instanceof UnknownHostException){
                    //change codesubmission state if sending failed and throw error
                    codeSubmission.setGradingStatus(GradingStatus.GRADING_SYSTEM_UNAVAILABLE);
                    codeSubmissionRepository.save(codeSubmission);
                    throw new CodeSubmissionJudgingServiceUnavailableException("Judgement services are unavailable now. Please, try again later");
                }
                log.error("{}, message: {}",e.getClass().getCanonicalName() ,e.getMessage());
            }
        });

        thread1.start();

    }
    private void processSending(CodeSubmission codeSubmission) throws UnknownHostException {
        WebClient client = WebClient.create("http://" + codeAssessmentServiceConfigData.getAssessmentExternalServiceIp() + ":" + codeAssessmentServiceConfigData.getAssessmentExternalServicePort());
//        String hostAddress = "gnkjb06l-8183.asse.devtunnels.ms";
        String hostAddress = InetAddress.getLocalHost().getHostAddress();

        List<RequestBody> requestBodies = codeSubmissionToRequestBody(codeSubmission, hostAddress);

        List<Token> tokens = new ArrayList<>();
        requestBodies.forEach(requestBody -> {
            Token[] result = client.post()
                .uri("/submissions/batch?base64_encoded=true")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(requestBody), RequestBody.class)
                .retrieve()
//                .onStatus(HttpStatus::is5xxServerError,
//                        clientResponse ->
//                                Mono.error(new CodeSubmissionJudgingServiceUnavailableException("Judgement services are unavailable now. Please, try again later")))
                .bodyToMono(Token[].class)
                .block();
            if(result != null)
                tokens.addAll(List.of(result));
        });

        for (int i = 0; i < tokens.size(); ++i)
            codeSubmission.getCodeSubmissionTestCaseList().get(i).setJudgeToken(tokens.get(i).token.toString());

        codeSubmissionTestCaseRepository.save(codeSubmission.getCodeSubmissionTestCaseList());


    }
    List<RequestBody> codeSubmissionToRequestBody(CodeSubmission codeSubmission, String hostAddress) {
        String callbackUrl = "http://" + hostAddress + ":" + codeAssessmentServiceConfigData.getServerPort().toString() + "/code-assessment/code-submission/test-case-token";
//        String callbackUrl = "http://" + hostAddress + "/code-assessment/code-submission/test-case-token";

        List<CodeSubmissionTestCase> baseList = codeSubmission.getCodeSubmissionTestCaseList();
        Integer n = baseList.size();

        List<CodeSubmissionTestCase> splitList = new ArrayList<>();

        List<RequestBody> result = new ArrayList<>();

        String base64SourceCode = getBase64SourceCode(codeSubmission.getHeadCode(), codeSubmission.getBodyCode(), codeSubmission.getTailCode());

        for(int i = 0;i < n; ++i){
            splitList.add(baseList.get(i));
            if((i + 1) % 5 == 0) {
                result.add(initRequestionBody(codeSubmission, splitList, callbackUrl, base64SourceCode));
                splitList = new ArrayList<>();
            }
        }
        if(!splitList.isEmpty())
            result.add(initRequestionBody(codeSubmission, splitList, callbackUrl, base64SourceCode));
        return result;
    }
    RequestBody initRequestionBody(CodeSubmission codeSubmission, List<CodeSubmissionTestCase> splitList, String callbackUrl, String base64SourceCode){
        return RequestBody.builder()
                .submissions(
                        splitList.stream()
                                .map(codeSubmissionTestCase -> RequestTestCase.builder()
                                        .language_id(codeSubmission.getProgrammingLangaugeJudge0Id())
                                        .source_code(base64SourceCode)
                                        .stdin(Base64.getEncoder().encodeToString(codeSubmissionTestCase.getTestCase().getInputData().getBytes()))
                                        .expected_output(Base64.getEncoder().encodeToString(codeSubmissionTestCase.getTestCase().getOutputData().getBytes()))
                                        .cpu_time_limit(codeSubmission.getProgrammingLanguageCodeQuestion().getTimeLimit())
                                        .memory_limit(codeSubmission.getProgrammingLanguageCodeQuestion().getMemoryLimit())
                                        .callback_url(callbackUrl)
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
    }

    private String getBase64SourceCode(String headCode, String bodyCode, String tailCode) {
        String source = decodeBase64ToString(headCode)+ decodeBase64ToString(bodyCode)+ decodeBase64ToString(tailCode);
        String base64Source = Base64.getEncoder().encodeToString(source.getBytes());
        return base64Source;
    }
    private String decodeBase64ToString(String str){
        if(str == null) return null;
        String nonEnterstr = str.replace("\n","");
        try {
            return new String(Base64.getDecoder().decode(nonEnterstr.getBytes()), StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error("not base64 {}", str);
            return str;
        }

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
