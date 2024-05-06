package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.config.CodeAssessmentServiceConfigData;
import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetCodeSubmissionsByUserIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetDetailCodeSubmissionsByIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.*;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_submission.CodeSubmissionNotFound;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GenericHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.assessment.AssessmentSourceCodeByTestCases;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class CodeSubmissionHelper {
    private final CodeAssessmentDomainService codeAssessmentDomainService;
    private final CodeSubmissionDataMapper codeSubmissionDataMapper;
    private final CodeSubmissionRepository codeSubmissionRepository;

    private final CodeSubmissionTestCaseRepository codeSubmissionTestCaseRepository;
    private final AssessmentSourceCodeByTestCases assessmentSourceCodeByTestCases;
    private final GenericHelper genericHelper;
    private final CodeAssessmentServiceConfigData codeAssessmentServiceConfigData;
    private final ValidateHelper validateHelper;

    public CodeSubmissionHelper(CodeAssessmentDomainService codeAssessmentDomainService, CodeSubmissionDataMapper codeSubmissionDataMapper, CodeSubmissionRepository codeSubmissionRepository, CodeSubmissionTestCaseRepository codeSubmissionTestCaseRepository, AssessmentSourceCodeByTestCases assessmentSourceCodeByTestCases, GenericHelper genericHelper, CodeAssessmentServiceConfigData codeAssessmentServiceConfigData, ValidateHelper validateHelper) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.codeSubmissionDataMapper = codeSubmissionDataMapper;
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.codeSubmissionTestCaseRepository = codeSubmissionTestCaseRepository;
        this.assessmentSourceCodeByTestCases = assessmentSourceCodeByTestCases;
        this.genericHelper = genericHelper;
        this.codeAssessmentServiceConfigData = codeAssessmentServiceConfigData;
        this.validateHelper = validateHelper;
    }

    //don't use @transactional here
    public CodeSubmission createCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand) {
        CodeSubmission codeSubmission = initAndSaveCodeSubmission(createCodeSubmissionCommand);
        //send judge to get token and store token if success
        assessmentSourceCodeByTestCases.judge(codeSubmission);


        return codeSubmission;
    }
    @Transactional
    public CodeSubmission initAndSaveCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand){
        CodeSubmission codeSubmission = codeSubmissionDataMapper.createCodeSubmissionCommandToCodeSubmission(createCodeSubmissionCommand);

        validateHelper.validateUser(createCodeSubmissionCommand.getUserId());
        CodeQuestion codeQuestion = validateHelper.validateCodeQuestion(createCodeSubmissionCommand.getCodeQuestionId());
        ProgrammingLangauge programmingLangauge = validateHelper.validateLanguage(createCodeSubmissionCommand.getLanguageId(), createCodeSubmissionCommand.getCodeQuestionId());
        ProgrammingLanguageCodeQuestion plcq =
                validateHelper.validateProgrammingLanguageCodeQuestion(createCodeSubmissionCommand.getLanguageId(), createCodeSubmissionCommand.getCodeQuestionId());

        List<TestCase> testCases =  validateHelper.validateTestCasesByCodeQuestionId(createCodeSubmissionCommand.getCodeQuestionId());
        codeAssessmentDomainService.initiateCodeSubmission(codeSubmission, codeQuestion, testCases, plcq, programmingLangauge);

        codeSubmissionRepository.save(codeSubmission);
        codeSubmissionTestCaseRepository.save(codeSubmission.getCodeSubmissionTestCaseList());

        return codeSubmission;
    }



    @Transactional
    public CodeSubmissionTestCase handleTestCaseResult(UpdateCodeSubmissionTestCaseCommand command) {
        CodeSubmissionTestCase cstc = codeSubmissionDataMapper.updateCodeSubmissionTestCaseCommandToCodeSubmissionTestCase(command);
        Optional<CodeSubmissionTestCase> cstcExist = codeSubmissionTestCaseRepository.findByToken(command.getToken());

        if(cstcExist.isPresent()){
            genericHelper.mapNullAttributeToRepositoryAttribute(cstc, cstcExist.get(), CodeSubmissionTestCase.class);
//            log.info("jfdk {}", cstc.getCodeSubmission().toString());
            codeSubmissionTestCaseRepository.save(cstc);
        }
        return cstc;
    }

    @Transactional
    public void increaseCodeSubmissionGradedTestCase(CodeSubmissionTestCase codeSubmissionTestCase) {
        codeSubmissionRepository.updateOneTestCase(codeSubmissionTestCase.getCodeSubmission().getId());
    }

    @Transactional
    public void updateCodeSubmissionWhenAllTestCaseAssessed(CodeSubmissionId id) {
        Optional<CodeSubmission> codeSubmissionOpt = codeSubmissionRepository.findById(id);

        if(codeSubmissionOpt.isPresent()){
            CodeSubmission codeSubmission = codeSubmissionOpt.get();

            if(codeSubmission.getNumOfTestCaseGraded().equals(codeSubmission.getNumOfTestCase())){
                List<CodeSubmissionTestCase> cstc = codeSubmissionTestCaseRepository.findByCodeSubmissionId(id);

                codeAssessmentDomainService.calculateAvgTimeAndMemoryAndGrade(codeSubmission, cstc, codeAssessmentServiceConfigData.getAcceptedStatusDescription());

                codeSubmissionRepository.save(codeSubmission);
            }
        }
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
}
