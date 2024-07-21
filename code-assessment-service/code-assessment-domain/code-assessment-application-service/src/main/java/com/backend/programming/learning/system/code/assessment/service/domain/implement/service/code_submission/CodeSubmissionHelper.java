package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.config.CodeAssessmentServiceConfigData;
import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.ExecuteCodeWithTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.*;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.event.code_submission.CodeSubmissionUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_submission.CodeSubmissionNotFound;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.programming_language.ProgrammingLanguageNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GeneralSagaHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GenericHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_submission_update_outbox.CodeSubmissionUpdateOutboxHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.GradingStatus;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class CodeSubmissionHelper {
    private final CodeAssessmentDomainService codeAssessmentDomainService;
    private final CodeSubmissionDataMapper codeSubmissionDataMapper;
    private final CodeSubmissionRepository codeSubmissionRepository;

    private final CodeSubmissionTestCaseRepository codeSubmissionTestCaseRepository;
    private final GenericHelper genericHelper;
    private final CodeAssessmentServiceConfigData codeAssessmentServiceConfigData;
    private final ValidateHelper validateHelper;
    private final CodeSubmissionUpdateOutboxHelper codeSubmissionUpdateOutboxHelper;
    private final GeneralSagaHelper generalSagaHelper;
    private final ObjectMapper objectMapper;

    @Transactional
    public CodeSubmissionUpdatedEvent createCodeSubmission(CreateCodeSubmissionCommand command){
        User user = validateHelper.validateUserByEmail(command.getEmail());

        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(command.getCodeQuestionId());
        CodeSubmission codeSubmission = codeSubmissionDataMapper.createCodeSubmissionCommandToCodeSubmission(command, codeQuestion, user);


        ProgrammingLanguage programmingLanguage = validateHelper.validateLanguage(command.getLanguageId(), command.getCodeQuestionId());
        if(!programmingLanguage.getIsActive())
            throw new ProgrammingLanguageNotFoundException("Language id "+ command.getLanguageId() + " is not available");
        ProgrammingLanguageCodeQuestion plcq =
                validateHelper.validateProgrammingLanguageCodeQuestion(command.getLanguageId(), command.getCodeQuestionId());
        if(!plcq.getActive())
            throw new ProgrammingLanguageNotFoundException("Code question " + command.getCodeQuestionId() + " with language id "+ command.getLanguageId() + " is not available");

        List<TestCase> testCases =  validateHelper.validateTestCasesByCodeQuestionId(command.getCodeQuestionId());
        CodeSubmissionUpdatedEvent event = codeAssessmentDomainService.initiateCodeSubmission(codeSubmission, testCases, plcq, programmingLanguage);

        codeSubmissionRepository.save(codeSubmission);
        if(command.getCertificateCourseId() != null)
            codeSubmissionRepository.saveCerCourse(codeSubmission.getId(), command.getCertificateCourseId());
        if(command.getContestId() != null)
            codeSubmissionRepository.saveContest(codeSubmission.getId(), command.getContestId());
        codeSubmissionTestCaseRepository.save(codeSubmission.getCodeSubmissionTestCaseList());

        return event;
    }



    @Transactional
    public CodeSubmissionTestCase handleTestCaseResult(UpdateCodeSubmissionTestCaseCommand command) {
        CodeSubmissionTestCase cstc = codeSubmissionDataMapper.updateCodeSubmissionTestCaseCommandToCodeSubmissionTestCase(command);
        Optional<CodeSubmissionTestCase> cstcExist = codeSubmissionTestCaseRepository.findByToken(command.getToken());

        if(cstcExist.isPresent()){
            CodeSubmissionTestCase cstcRepo = cstcExist.get();
            genericHelper.mapRepositoryAttributeToUpdateAttribute(cstcRepo , cstc, CodeSubmissionTestCase.class);
//            log.info("jfdk {}", cstc.getCodeSubmission().toString());
            codeSubmissionTestCaseRepository.save(cstcRepo);
            return cstcRepo;
        }
        return null;
    }

    @Transactional
    public void increaseCodeSubmissionGradedTestCase(CodeSubmissionTestCase codeSubmissionTestCase) {
        codeSubmissionRepository.updateOneTestCase(codeSubmissionTestCase.getCodeSubmission().getId());
    }
    private boolean checkGraded(List<CodeSubmissionTestCase> cstc){
        return cstc.stream().noneMatch(item-> item.getStatusDescription() == null);
    }


    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean updateCodeSubmissionWhenAllTestCaseAssessed(CodeSubmissionId id) {
        CodeSubmission codeSubmission = validateHelper.validateCodeSubmission(id);
        List<CodeSubmissionTestCase> cstc= codeSubmissionTestCaseRepository.findByCodeSubmissionId(id);
//        log.info("ccccc {} {}", codeSubmission.getNumOfTestCase(), codeSubmission.getNumOfTestCaseGraded());

        if(checkGraded(cstc)){
            codeAssessmentDomainService.calculateAvgTimeAndMemoryAndGrade(codeSubmission, cstc, codeAssessmentServiceConfigData.getAcceptedStatusDescription());

            codeSubmissionRepository.save(codeSubmission);

            CodeSubmissionUpdatedEvent event = new CodeSubmissionUpdatedEvent(codeSubmission, ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));

            GetCodeSubmissionResponseItem item = codeSubmissionDataMapper.codeSubmissionToGetCodeSubmissionResponseItem(codeSubmission);
            CodeSubmissionTestCase cstcFailed = findFirstNonAcceptedTestCase(codeSubmission.getId());
            Integer countNonAcceptedTestCase = countNonAcceptedTestCase(codeSubmission.getId());
            item.setNumOfTestCaseFailed(countNonAcceptedTestCase);
            item.setFirstFailTestCase(codeSubmissionDataMapper.codeSubmissionTestCaseToFirstFailTestCase(cstcFailed));
            item.setSourceCode(null);

            String resultContent = null;
            try {
                resultContent = objectMapper.writeValueAsString(item);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            codeSubmissionUpdateOutboxHelper.saveCodeSubmissionUpdateOutboxMessage(
                    codeSubmissionDataMapper.codeSubmissionUpdatedEventToCodeSubmissionUpdatePayload(
                            event, null, null, CopyState.UPDATING, resultContent
                    ),
                    event.getCodeSubmission().getCopyState(),
                    generalSagaHelper.copyStateToSagaStatus(CopyState.UPDATING),
                    OutboxStatus.STARTED,
                    UUID.randomUUID()
            );

            return true;
        }else if(!codeSubmission.getGradingStatus().equals(GradingStatus.GRADING))
            return true;
        return false;
    }

    @Transactional
    public Page<CodeSubmission> getCodeSubmissionsByUserId(GetCodeSubmissionsByUserIdCommand command) {
        User user = validateHelper.validateUserByEmail(command.getEmail());
        Page<CodeSubmission> codeSubmissions
                = codeSubmissionRepository
                .findByUserIdAndQuestionId(
                        user.getId(),
                        new CodeQuestionId(command.getCodeQuestionId()),
                        command.getContestId(),
                        command.getCerCourseId(),
                        command.getPageNum(),
                        command.getPageSize());

        findDescriptionStatus(codeSubmissions);
        return codeSubmissions;
    }

    private void findDescriptionStatus(Page<CodeSubmission> codeSubmissions) {
        codeSubmissions.forEach(codeSubmission -> {
            if(codeSubmission.getRunTime() != null)
                codeSubmission.setStatusDescription(codeAssessmentServiceConfigData.getAcceptedStatusDescription());
            else
            {
                Optional<CodeSubmissionTestCase> cstc = codeSubmissionTestCaseRepository.findFirstNonAcceptedByCodeSubmissionId(codeSubmission.getId());
                if(cstc.isPresent()){
                    codeSubmission.setStatusDescription(cstc.get().getStatusDescription());
                }else codeSubmission.setStatusDescription(null);
            }
        });
    }

    @Transactional
    public CodeSubmission getCodeSubmissionsById(GetDetailCodeSubmissionsByIdCommand command) {
        validateHelper.validateUserByEmail(command.getEmail());

        Optional<CodeSubmission> codeSubmissionOpt = codeSubmissionRepository.findById(new CodeSubmissionId(command.getCodeSubmissionId()));
        if(codeSubmissionOpt.isPresent())
            return codeSubmissionOpt.get();
        else throw new CodeSubmissionNotFound("CodeSubmission with id " + command.getCodeSubmissionId() + " not found");
    }

    @Transactional
    public CodeSubmissionTestCase findFirstNonAcceptedTestCase(CodeSubmissionId codeSubmissionId) {
        Optional<CodeSubmissionTestCase> cstcOpt = codeSubmissionTestCaseRepository.findFirstNonAcceptedByCodeSubmissionId(codeSubmissionId);
        return cstcOpt.orElse(null);
    }
    @Transactional
    public Integer countNonAcceptedTestCase(CodeSubmissionId codeSubmissionId) {
        Integer cstcOpt = codeSubmissionTestCaseRepository.countNonAcceptedByCodeSubmissionId(codeSubmissionId);
        if(cstcOpt == null) cstcOpt = 0;
        return cstcOpt;
    }

    @Transactional
    public GetMemoryAndTimeRankingResponse getMemoryAndRunTimeRanking(GetMemoryAndTimeRankingCommand command) {
        CodeSubmission codeSubmission = validateHelper.validateCodeSubmission(new CodeSubmissionId(command.getCodeSubmissionId()));

        Integer memoryRank = codeSubmission.getMemory() != null? codeSubmissionRepository.findNumberOfSubmissionUnderMySubmissionByMemory(codeSubmission.getId()): null;
        Integer runTimeRank = memoryRank != null? codeSubmissionRepository.findNumberOfSubmissionUnderMySubmissionByRunTime(codeSubmission.getId()): null;
        Integer totalSubmissionHavingAvgMemoryAndRunTime = memoryRank != null? codeSubmissionRepository.totalSubmissionHavingAvgMemoryAndRunTime(codeSubmission.getCodeQuestion().getId()): null;

        Integer numberOfSubmissionUnderYouByScore = codeSubmission.getGrade() != null? codeSubmissionRepository.findNumberOfSubmissionUnderMySubmissionByScore(codeSubmission.getId()): null;
        Integer totalSubmissionHavingScore = numberOfSubmissionUnderYouByScore != null? codeSubmissionRepository.totalSubmissionHavingScore(codeSubmission.getCodeQuestion().getId()): null;
        Integer yourScoreRank = numberOfSubmissionUnderYouByScore != null? codeSubmissionRepository.findYourScoreRank(codeSubmission.getId()): null;

        return GetMemoryAndTimeRankingResponse.builder()
                .totalSubmissionHavingAvgMemoryAndRunTime(totalSubmissionHavingAvgMemoryAndRunTime)
                .numberOfSubmissionUnderYouByMemory(memoryRank)
                .numberOfSubmissionUnderYouByRunTime(runTimeRank)

                .totalSubmissionHavingScore(totalSubmissionHavingScore)
                .yourScoreRank(yourScoreRank)
                .numberOfSubmissionUnderYouByScore(numberOfSubmissionUnderYouByScore)
                .build();

    }

    @Transactional
    public void setUnavailable(CodeSubmission codeSubmission) {
        codeSubmission.setGradingStatus(GradingStatus.GRADING_SYSTEM_UNAVAILABLE);
        codeSubmissionRepository.save(codeSubmission);
        codeSubmissionUpdateOutboxHelper.saveCodeSubmissionUpdateOutboxMessage(
                codeSubmissionDataMapper.codeSubmissionUpdatedEventToCodeSubmissionUpdatePayload(
                        codeSubmission, null, null, CopyState.UPDATING, null
                ),
                CopyState.UPDATING,
                generalSagaHelper.copyStateToSagaStatus(CopyState.UPDATING),
                OutboxStatus.STARTED,
                UUID.randomUUID()
        );
    }

    public String executeCodeWithTestCase(ExecuteCodeWithTestCaseCommand command) {
        WebClient client = WebClient.create("http://" + codeAssessmentServiceConfigData.getAssessmentExternalServiceIp() + ":" + codeAssessmentServiceConfigData.getAssessmentExternalServicePort());
        String result = client.post()
                .uri("/submissions?base64_encoded=true&wait=true")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(command), ExecuteCodeWithTestCaseCommand.class)
                .retrieve()
//                .onStatus(HttpStatus::is5xxServerError,
//                        clientResponse ->
//                                Mono.error(new CodeSubmissionJudgingServiceUnavailableException("Judgement services are unavailable now. Please, try again later")))
                .bodyToMono(String.class)
                .block();

        return result;
    }

    public Page<CodeSubmission> getAdminCodeSubmissions(AdminCodeSubmissionQuery query) {
        User user = validateHelper.validateUserByEmail(query.getEmail());
        Page<CodeSubmission> codeSubmissions = codeSubmissionRepository.findByQuestionId(
                null,
                query.getContestId(),
                query.getCerCourseId(),
                query.getPageNum(),
                query.getPageSize());

        findDescriptionStatus(codeSubmissions);
        return codeSubmissions;
    }

    public Page<CodeSubmission> getUserRecentCodeSubmissions(UserCodeSubmissionQuery query) {
        User user = validateHelper.validateUserByEmail(query.getEmail());
        Page<CodeSubmission> codeSubmissions = codeSubmissionRepository.findByUserId(
                user.getId(),
                query.getPageNum(),
                query.getPageSize());

        findDescriptionStatus(codeSubmissions);
        return codeSubmissions;
    }

    public Page<CodeQuestion> getUserRecentCodeQuestion(UserRecentCodeQuestionQuery query) {
        User user = validateHelper.validateUserByEmail(query.getEmail());
        return codeSubmissionRepository.getUserRecentCodeQuestion(
                user.getId(),
                query.getPageNum(),
                query.getPageSize());
    }

    public List<HeatMapItem> getHeatMap(String email, Integer year) {
        User user = validateHelper.validateUserByEmail(email);
        return codeSubmissionRepository.getHeatMap(user.getId(), year);
    }
}
