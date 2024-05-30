package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.config.CodeAssessmentServiceConfigData;
import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetCodeSubmissionsByUserIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetDetailCodeSubmissionsByIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetMemoryAndTimeRankingCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetMemoryAndTimeRankingResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.event.code_submission.CodeSubmissionUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_submission.CodeSubmissionNotFound;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GeneralSagaHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GenericHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_submission_update_outbox.CodeSubmissionUpdateOutboxHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.assessment.AssessmentSourceCodeByTestCases;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.GradingStatus;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
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

    public CodeSubmissionHelper(CodeAssessmentDomainService codeAssessmentDomainService, CodeSubmissionDataMapper codeSubmissionDataMapper, CodeSubmissionRepository codeSubmissionRepository, CodeSubmissionTestCaseRepository codeSubmissionTestCaseRepository, GenericHelper genericHelper, CodeAssessmentServiceConfigData codeAssessmentServiceConfigData, ValidateHelper validateHelper, CodeSubmissionUpdateOutboxHelper codeSubmissionUpdateOutboxHelper, GeneralSagaHelper generalSagaHelper) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.codeSubmissionDataMapper = codeSubmissionDataMapper;
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.codeSubmissionTestCaseRepository = codeSubmissionTestCaseRepository;
        this.genericHelper = genericHelper;
        this.codeAssessmentServiceConfigData = codeAssessmentServiceConfigData;
        this.validateHelper = validateHelper;
        this.codeSubmissionUpdateOutboxHelper = codeSubmissionUpdateOutboxHelper;
        this.generalSagaHelper = generalSagaHelper;
    }

    @Transactional
    public CodeSubmissionUpdatedEvent createCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand){
        validateHelper.validateUser(createCodeSubmissionCommand.getUserId());

        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(createCodeSubmissionCommand.getCodeQuestionId());
        CodeSubmission codeSubmission = codeSubmissionDataMapper.createCodeSubmissionCommandToCodeSubmission(createCodeSubmissionCommand, codeQuestion);


        ProgrammingLanguage programmingLanguage = validateHelper.validateLanguage(createCodeSubmissionCommand.getLanguageId(), createCodeSubmissionCommand.getCodeQuestionId());
        ProgrammingLanguageCodeQuestion plcq =
                validateHelper.validateProgrammingLanguageCodeQuestion(createCodeSubmissionCommand.getLanguageId(), createCodeSubmissionCommand.getCodeQuestionId());

        List<TestCase> testCases =  validateHelper.validateTestCasesByCodeQuestionId(createCodeSubmissionCommand.getCodeQuestionId());
        CodeSubmissionUpdatedEvent event = codeAssessmentDomainService.initiateCodeSubmission(codeSubmission, testCases, plcq, programmingLanguage);

        codeSubmissionRepository.save(codeSubmission);
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

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean updateCodeSubmissionWhenAllTestCaseAssessed(CodeSubmissionId id) {
        CodeSubmission codeSubmission = validateHelper.validateCodeSubmission(id);
//        log.info("ccccc {} {}", codeSubmission.getNumOfTestCase(), codeSubmission.getNumOfTestCaseGraded());

        if(codeSubmission.getNumOfTestCaseGraded().equals(codeSubmission.getNumOfTestCase())){
            List<CodeSubmissionTestCase> cstc = codeSubmissionTestCaseRepository.findByCodeSubmissionId(codeSubmission.getId());

            codeAssessmentDomainService.calculateAvgTimeAndMemoryAndGrade(codeSubmission, cstc, codeAssessmentServiceConfigData.getAcceptedStatusDescription());

            codeSubmissionRepository.save(codeSubmission);

            CodeSubmissionUpdatedEvent event = new CodeSubmissionUpdatedEvent(codeSubmission, ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));

            codeSubmissionUpdateOutboxHelper.saveCodeSubmissionUpdateOutboxMessage(
                    codeSubmissionDataMapper.codeSubmissionUpdatedEventToCodeSubmissionUpdatePayload(
                            event, CopyState.UPDATING
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
    public List<CodeSubmission> getCodeSubmissionsByUserId(GetCodeSubmissionsByUserIdCommand command) {
        Optional<List<CodeSubmission>> codeSubmissionsOpt = codeSubmissionRepository.findByUserIdAndQuestionId(new UserId(command.getUserId()), new CodeQuestionId(command.getCodeQuestionId()));
        if(codeSubmissionsOpt.isPresent())
            findDescriptionStatus(codeSubmissionsOpt.get());
        return codeSubmissionsOpt.orElse(null);
    }

    private void findDescriptionStatus(List<CodeSubmission> codeSubmissions) {
        codeSubmissions.forEach(codeSubmission -> {
            if(codeSubmission.getRunTime() != null)
                codeSubmission.setStatusDescription(codeAssessmentServiceConfigData.getAcceptedStatusDescription());
            else
            {
                Optional<CodeSubmissionTestCase> cstc = codeSubmissionTestCaseRepository.findFirstNonAcceptedByCodeSubmissionId(codeSubmission.getId());
                cstc.ifPresent(cstcp -> codeSubmission.setStatusDescription(cstcp.getStatusDescription()));
            }
        });
    }

    @Transactional
    public CodeSubmission getCodeSubmissionsById(GetDetailCodeSubmissionsByIdCommand command) {
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
}
