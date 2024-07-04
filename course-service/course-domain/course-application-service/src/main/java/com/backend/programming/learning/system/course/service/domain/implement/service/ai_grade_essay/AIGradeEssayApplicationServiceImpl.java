package com.backend.programming.learning.system.course.service.domain.implement.service.ai_grade_essay;

import com.backend.programming.learning.system.course.service.config.CourseServiceConfigData;
import com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.rubric.Criteria;
import com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.gemini.GeminiRecord;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.report_grade_essay_ai.ReportGradeEssayAICommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.ai_grade_essay_report.QueryAllAIGradeEssayReportsByAssignmentIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.ai_grade_essay_report.QueryAllAIGradeEssayReportsByAssignmentIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAssignmentAIGradeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllSubmissionAssignmentAIGradeEssayResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllSubmissionnAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.ai_grade_essay_report.AssignmentAIGradeReportEntityResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.entity.AssignmentAIGradeReport;
import com.backend.programming.learning.system.course.service.domain.entity.RubricUser;
import com.backend.programming.learning.system.course.service.domain.exception.AssignmentNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.ai_grade_essay_report.AIGradeEssayReportDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.assignment.AssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment.SubmissionAssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.ai_grade_essay.AIGradeEssayApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.assignment.AssignmentApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment.SubmissionAssignmentApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentAIGradeReportRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.RubricUserRepository;
import com.backend.programming.learning.system.domain.valueobject.AssignmentAIGradeReportStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class AIGradeEssayApplicationServiceImpl implements AIGradeEssayApplicationService {

    private final RestTemplate restTemplate;
    private final SubmissionAssignmentApplicationService submissionAssignmentApplicationService;
    private final AssignmentApplicationService assignmentApplicationService;
    private final SubmissionAssignmentDataMapper submissionAssignmentDataMapper;
    private final AssignmentAIGradeReportRepository assignmentAIGradeReportRepository;
    private final AssignmentDataMapper assignmentDataMapper;
    private final RubricUserRepository rubricUserRepository;
    private final CourseServiceConfigData courseServiceConfigData;
    private final AssignmentRepository assignmentRepository;
    private final AIGradeEssayReportDataMapper aiGradeEssayReportDataMapper;

    @Override
    public void gradeEssay(AssignmentAIGradeReport assignmentAIGradeReport) {
        try {
            String apiUrl = String.format(courseServiceConfigData.getGeminiApiUrl(), courseServiceConfigData.getGeminiApiKey());
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode contentNode = objectMapper.createObjectNode();
            ObjectNode partsNode = objectMapper.createObjectNode();

            String AI_ROLE = """
I. YOUR ROLE:
    A. You are an Automated Essay Grading AI, trained on a massive dataset of essays and feedback from human experts. Your primary function is to evaluate student essays in a fair and consistent manner, providing comprehensive feedback and assigning scores based on the provided criteria.
    
    B. Your expertise lies in the domains of software engineering and programming. You are adept at identifying key concepts, assessing the clarity and structure of arguments, and pinpointing areas for improvement.
        - Identifying key concepts
        - Assessing the clarity, coherence, and structure of arguments
        - Highlighting areas for improvement, focusing on areas directly related to the grading criteria
        
    C. Strive to emulate the qualities of a patient, knowledgeable, and supportive educator who guides students towards academic excellence.                
         """;

            String AI_SYSTEM_INSTRUCTIONS = """
II. SYSTEM_INSTRUCTIONS:
    A. Your Task:
        1. Evaluate student essays based on the provided criteria and rubrics.
        2. Provide detailed feedback based on rubrics and grading criteria is provided by the lecturer to help students improve their writing skills.
        3. Assign scores to each essay based on the grading rubric and guidelines.
        4. Offer constructive criticism and suggestions for improvement to help students enhance their writing skills.
    
    B. Steps for AI to Evaluate Essays:
        1. Understand the Question and Rubric:
            - Question: Carefully read and understand the question provided by the lecturer to know what the students are expected to address in their essays.
            - Rubric: Review the grading rubric to understand the criteria for evaluating the essays, including content, form, and style.
    
        2. Process Each Student Submission:
            - For each student submission, identify the unique ""studentSubmissionId"" and extract the ""studentAnswer"".
        
        3. Evaluate Content Relevance and Accuracy:
            - Relevance: Check if the ""studentAnswer"" is relevant to the provided question.
                + If not relevant, provide feedback on the lack of relevance and assign a score of 0.
            - Accuracy: Assess if the information presented is factually correct and addresses the main points of the question.
        
        4. Assess Structure and Coherence:
            - Logic: Evaluate the logical flow of the argument or explanation in the essay.
            - Coherence: Check if the essay is well-organized and ideas are clearly connected.
        
        5. Use the Rubric to Grade Specific Criteria:
            - Break down the rubric into its specific criteria (e.g., thesis statement, supporting arguments, evidence, conclusion).
            - Assign a score for each criterion based on the student's performance.
        
        6. Provide Constructive Feedback based on Rubric Criteria:
            - Offer detailed feedback for each criterion, highlighting strengths and areas for improvement.
            - Provide specific suggestions for enhancing writing skills and addressing weaknesses.
            - Use clear language and examples to illustrate your points.
            - Feedback for each criterion should be tailored to the student's submission.
        
        7. Calculate Overall Score:
            - Based on the rubric, aggregate the scores from each criterion to determine the overall score.
            - Ensure the overall score is a decimal number between 0 and the maximum score specified in the question.
        
        8. Format Feedback and Score:
            - Ensure the feedback is detailed, specific, and offers suggestions for improvement.
            - You have to feedback based on the grading criteria and rubrics provided by the lecturer.
            - Format the feedback and score into a JSON object as follows:
                {
                    "studentSubmissionId": <student_id>,
                    "feedback": "<detailed_feedback>",
                    "score_overall": <overall_score>
                }
    
        9. Generate Final Output:
            - Compile the feedback and scores for all student submissions into a JSON array.
            - Validate the JSON format to ensure it matches the required structure.
        
    C. Example Process for a Single Submission:
        1. Read Question: "Explain the process of photosynthesis." and Question Max Score: 5.
    
        2. Read Rubric: Criteria include understanding of photosynthesis, clarity of explanation, use of scientific terminology, and overall essay structure.
        
        3. Evaluate Submission:
            - Relevance: Confirm the essay discusses photosynthesis.
            - Content Accuracy: Check for correct descriptions of light-dependent and light-independent reactions.
            - Structure: Assess logical flow from introduction to conclusion.
            - Use of Terminology: Ensure proper use of terms like chlorophyll, ATP, etc.
    
        4. Provide Feedback:
            - Feedback based on each criterion (relevance, accuracy, structure, terminology).
            - Answer: ""\"Relevance: Your explanation of the light-dependent reactions is accurate and well-explained. However, the section on light-independent reactions lacks detail. Consider elaborating on the Calvin cycle. \\nAccuracy: Your description of the Calvin cycle is clear and accurate, demonstrating a good understanding of the process. \\nStructure: The essay is well-structured with a clear introduction and conclusion. However, the transition between the two sections could be smoother. \\nTerminology: You have used scientific terminology effectively, but remember to define complex terms for readers unfamiliar with the topic.""\"
        
        5. Assign Score:
            - Content: 4/5
            - Clarity: 3/5
            - Terminology: 4/5
            - Structure: 3/5
            - Overall Score: 3.5/5
        
        6. Output:
            {
            "studentSubmissionId": 1,
            "feedback": "Relevance: Your explanation of the light-dependent reactions is accurate and well-explained. However, the section on light-independent reactions lacks detail. Consider elaborating on the Calvin cycle. \\nAccuracy: Your description of the Calvin cycle is clear and accurate, demonstrating a good understanding of the process. \\nStructure: The essay is well-structured with a clear introduction and conclusion. However, the transition between the two sections could be smoother. \\nTerminology: You have used scientific terminology effectively, but remember to define complex terms for readers unfamiliar with the topic.",
            "score_overall": 3.5
            }
                """;

            QueryAllSubmissionAssignmentAIGradeEssayResponse queryAllSubmissionAssignmentAIGradeEssayResponse =
                    objectMapper.readValue(assignmentAIGradeReport.getStudentSubmissions(), QueryAllSubmissionAssignmentAIGradeEssayResponse.class);
            long totalSubmissions = queryAllSubmissionAssignmentAIGradeEssayResponse.getTotalItems();
            QueryAssignmentAIGradeResponse queryAssignmentAIGradeResponse =
                    objectMapper.readValue(assignmentAIGradeReport.getQuestion(), QueryAssignmentAIGradeResponse.class);
            String studentSubmissions = objectMapper.writeValueAsString(queryAllSubmissionAssignmentAIGradeEssayResponse.getSubmissionAssignments());
            String questionContent = queryAssignmentAIGradeResponse.getIntro();
            Float questionMaxScore = queryAssignmentAIGradeResponse.getMaxScore();
            String language = assignmentAIGradeReport.getFeedbackLanguage();

            RubricUser rubricUser = assignmentAIGradeReport.getRubricUser();
            String assignmentRubric;
            if (rubricUser == null) {
                assignmentRubric = """
- Criteria: Content (Total score: 80%)
  * Score 1/4: The essay is incomplete, inaccurate, illogical, and uses sources inappropriately
  * Score 2/4: The essay is complete, accurate, but lacks logic, and uses sources somewhat appropriately
  * Score 3/4: The essay is complete, accurate, and logical, and uses sources appropriately
  * Score 4/4: The essay is complete, accurate, logical, creative, and uses sources appropriately
- Criteria: Form (Total score: 10%)
  * Score 1/4: The essay has many errors in grammar, spelling, or punctuation, uses limited vocabulary, and has an unclear layout.
  * Score 2/4: The essay has several errors in grammar, spelling, or punctuation, uses somewhat varied and rich vocabulary, and has a somewhat clear layout.
  * Score 3/4: The essay has few errors in grammar, spelling, or punctuation, uses varied, rich, and appropriate vocabulary, and has a relatively clear layout.
  * Score 4/4: The essay has no errors in grammar, spelling, or punctuation, and uses varied, rich, and appropriate vocabulary with a clear layout
- Criteria: Style (Total score: 10%)
  * Score 1/4: The essay is unclear, not engaging, and not appropriate for the topic, purpose, and audience.
  * Score 2/4: The essay is unclear, lacks engagement, and is somewhat appropriate for the topic, purpose, and audience.
  * Score 3/4: The essay is relatively clear, engaging, and appropriate for the topic, purpose, and audience.
  * Score 4/4: The essay is clear, engaging, and appropriate for the topic, purpose, and audience.
                    """;
            } else {
                List<Criteria> criteria = objectMapper.readValue(rubricUser.getContent(), new TypeReference<List<Criteria>>() {});
                assignmentRubric = formatRubric(criteria);
            }
            String INPUT_OUTPUT = interpolateInputOutput(studentSubmissions, totalSubmissions, questionContent, questionMaxScore, assignmentRubric, language);

            partsNode.put("text", AI_ROLE);
            contentNode.set("parts", objectMapper.createArrayNode().add(partsNode));
            contentNode.put("role", "user");

            ObjectNode contentNode1 = objectMapper.createObjectNode();
            ObjectNode partsNode1 = objectMapper.createObjectNode();
            partsNode1.put("text", AI_SYSTEM_INSTRUCTIONS);
            contentNode1.set("parts", objectMapper.createArrayNode().add(partsNode1));
            contentNode1.put("role", "user");

            ObjectNode contentNode2 = objectMapper.createObjectNode();
            ObjectNode partsNode2 = objectMapper.createObjectNode();
            partsNode2.put("text", INPUT_OUTPUT);
            contentNode2.set("parts", objectMapper.createArrayNode().add(partsNode2));
            contentNode2.put("role", "user");

            ObjectNode requestBodyNode = objectMapper.createObjectNode();
            requestBodyNode.set("contents", objectMapper.createArrayNode().add(contentNode).add(contentNode1).add(contentNode2));

            String requestBody;
            requestBody = objectMapper.writeValueAsString(requestBodyNode);

            HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, String.class);
            GeminiRecord temp = objectMapper.readValue(response.getBody(), GeminiRecord.class);
            String textResponse = temp.getCandidates().get(0).getContent().getParts().get(0).getText();
            Object textResponseObjectValid = objectMapper.readValue(textResponse.replace("```", "").replace("json", ""), Object.class);
            assignmentAIGradeReport.setFeedbackSubmissions(textResponse.replace("```", "").replace("json", ""));
            assignmentAIGradeReport.setStatus(AssignmentAIGradeReportStatus.SUCCESS);

            AssignmentAIGradeReport assignmentAIGradeReportCreated = assignmentAIGradeReportRepository.save(assignmentAIGradeReport);
            log.info("AssignmentAIGradeReport saved: {}", assignmentAIGradeReportCreated.getId());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createReportEssay(ReportGradeEssayAICommand reportGradeEssayAICommand) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        UUID assignmentId = reportGradeEssayAICommand.assignmentId();
        UUID rubricId = reportGradeEssayAICommand.rubricId();
        QueryAllSubmissionAssignmentAIGradeEssayResponse queryAllSubmissionAssignmentResponse =
                submissionAssignmentDataMapper.queryAllSubmissionAssignmentResponseToQueryAllSubmissionAssignmentAIGradeEssayResponse(
                        submissionAssignmentApplicationService
                                .queryAllByAssignmentId(new QueryAllSubmissionnAssignmentCommand(assignmentId, 0, 9999, "", false))
                );
        QueryAssignmentAIGradeResponse queryAssignmentAIGradeResponse = assignmentDataMapper.queryAssignmentResponseToQueryAssignmentAIGradeResponse(
                assignmentApplicationService.queryAssignment(new QueryAssignmentCommand(assignmentId))
        );

        RubricUser rubricUserFound = findRubricUser(rubricId);
        Assignment assignment = queryAssignmentById(assignmentId);

        AssignmentAIGradeReport assignmentAIGradeReport = AssignmentAIGradeReport.builder().build();
        assignmentAIGradeReport.initializeAssignmentAIGradeReport();
        assignmentAIGradeReport.setQuestion(objectMapper.writeValueAsString(queryAssignmentAIGradeResponse));
        assignmentAIGradeReport.setRubricUser(rubricUserFound);
        assignmentAIGradeReport.setStudentSubmissions(objectMapper.writeValueAsString(queryAllSubmissionAssignmentResponse));
        assignmentAIGradeReport.setFeedbackLanguage(reportGradeEssayAICommand.feedbackLanguage());
        assignmentAIGradeReport.setAssignment(assignment);

        AssignmentAIGradeReport assignmentAIGradeReportCreated = assignmentAIGradeReportRepository.save(assignmentAIGradeReport);
        log.info("AssignmentAIGradeReport created: {}", assignmentAIGradeReportCreated.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public QueryAllAIGradeEssayReportsByAssignmentIdResponse queryAllAIGradeEssayReportsByAssignmentId(QueryAllAIGradeEssayReportsByAssignmentIdCommand queryAllAIGradeEssayReportsByAssignmentIdCommand) {
        Page<AssignmentAIGradeReport> assignmentAIGradeReports = assignmentAIGradeReportRepository.findAllByAssignmentId(queryAllAIGradeEssayReportsByAssignmentIdCommand.getAssignmentId(), queryAllAIGradeEssayReportsByAssignmentIdCommand.getPageNo(), queryAllAIGradeEssayReportsByAssignmentIdCommand.getPageSize(), queryAllAIGradeEssayReportsByAssignmentIdCommand.getSearch());
        return aiGradeEssayReportDataMapper.assignmentAIGradeReportsToQueryAllAIGradeEssayReportsByAssignmentId(assignmentAIGradeReports);
    }

    @Override
    @Transactional(readOnly = true)
    public AssignmentAIGradeReportEntityResponse queryAIGradeEssayReportById(UUID assignmentAIGradeReportId) {
        return assignmentAIGradeReportRepository.findByReportId(assignmentAIGradeReportId)
                .map(aiGradeEssayReportDataMapper::assignmentAIGradeReportToAssignmentAIGradeReportEntityResponse)
                .orElse(null);
    }

    public String interpolateInputOutput(String studentSubmissions, long studentSubmissionsLength, String questionContent, Float questionMaxScore, String assignmentRubric, String language) {
        String template = """
III. INPUT AND OUTPUT:
    A. Input:
        The list of student submissions is provided in JSON format (SubmissionStudent[]). There are two attributes {{studentSubmissionId}} and {{studentAnswer}} for each student submission:
            - SubmissionStudent[]: The data structure for a list of student submissions.
            [
            {
                studentSubmissionId: A unique identifier for the student's essay (number).
                studentAnswer: The content of the student's essay (string).
            },
            {
                studentSubmissionId: A unique identifier for the student's essay (number).
                studentAnswer: The content of the student's essay (string).
            },
            ...
            ]
        
        You will provide feedback for the attribute {{studentAnswer}} (the content of the student's essay) for each student's submission (identified by {{id}}):
            ""\"
            ${studentSubmissions}
            ""\"
    
    B. Output:
        The feedback results will have {{${studentSubmissionsLength}}} elements. Each element is based on question details below and {{studentAnswer}} to grade and provide feedback to user:
        
        From the students' submission data above, please give me the grading and feedback suggestions for each student's submission. The {{studentSubmissionId}} should match the {{student's submission ID}} above. It must follow {{JSON format}}. According to the following structure:
            - IFeedbackGradingAI[]: The feedback results will have {{${studentSubmissionsLength}}} elements. The data structure for a list of feedback.
            [
            {
                studentSubmissionId: string (uuid),
                feedback: string (uuid),
                score_overall: number
            },
            {
                studentSubmissionId: string (uuid),
                feedback: string,
                score_overall: number
            },
            ...
            ]
        
        - Description: Each feedback has two attributes studentSubmissionId and feedback for each feedback (IFeedbackGradingAI):
            + studentSubmissionId: (string (uuid)) A unique identifier that matches the student's submission ID in the list of student submissions.
            + feedback (string) Focused and specific feedback provided to the student based on the {{grading criteria}} and {{rubrics}} below. The feedback should be constructive, specific, and offer suggestions for improvement, highlighting the identified areas for improvement. Followed by {{Markdown format}}.
            + score_overall: (number) The overall score assigned to the student's submission based on the grading criteria and rubrics. The score should be a decimal number between 0 and {{${questionMaxScore}}} and reflect the quality of the student's essay and how well it meets the grading criteria.
            
        Here is a {{question}} is provided by lecturer which is covered by triple quotes:
        ""\"
        ${questionContent}
        ""\"
        
        - Note for question:
            + The {{question}} is provided by the lecturer and you need to use this content to evaluate the student's submission if {{studentAnswer}} of each student is relevant to the question. If the student's submission is not relevant to the question, you should provide feedback on the lack of relevance and assign a score of 0.
            + And then you need to evaluate the student's submission based on the {{grading criteria}} and {{rubric}} provided below.
        
        Question max score which is covered by double brackets: {{${questionMaxScore}}}
        - Note for question max score: The max score for this question is {{${questionMaxScore}}}. You need to assign a score between 0 and {{${questionMaxScore}}} based on the quality of the student's submission and how well it meets the grading criteria.
        
        Rubric for grading which is covered by triple quotes, {{feedback}} and {{score_overall}} of each student's submission have to be evaluated based on this rubrics:
        ""\"
        ${questionRubrics}
        ""\"
        
        - Note for rubric: Steps to base on {{rubric above}} to grade the {{student's submission}}:
            + Step 1: Evaluate the content of the essay is accurate and relevant to the {{question}} provided above.
            + Step 2: Assess the logic and coherence of the argument presented in the essay.
            + Step 3: Use {{rubric}} below to evaluate the score overall for the student's submission. Rubric has list {{criteria}} is provided by lecturer and you need to use this to evaluate the student's submission if {{studentAnswer}} belong to score range of each criteria.
        
    C. Please use ${language} everywhere to write feedback messages for students.
                """;

        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("studentSubmissions", studentSubmissions);
        valuesMap.put("studentSubmissionsLength", String.valueOf(studentSubmissionsLength));
        valuesMap.put("questionContent", questionContent);
        valuesMap.put("questionMaxScore", String.valueOf(questionMaxScore));
        valuesMap.put("questionRubrics", assignmentRubric);
        valuesMap.put("language", language);

        StrSubstitutor sub = new StrSubstitutor(valuesMap);

        return sub.replace(template);
        }
    public String formatRubric(List<Criteria> criterias) {
        StringBuilder formattedData = new StringBuilder();

        criterias.forEach(criteria -> {
            formattedData.append("- Criteria: ").append(criteria.getCriteriaName()).append("\n");
            if (criteria.getCriteriaGrade() != null)
                formattedData.append(" (Total score: ").append(criteria.getCriteriaGrade()).append("%)\n");

            criteria.getScale().forEach(scale -> {
                formattedData.append("  * Score ").append(scale.getScore()).append("/" + criteria.getScale().size()).append(": ")
                        .append(scale.getDescription()).append("\n");
            });

        });

        return formattedData.toString();
    }

    public RubricUser findRubricUser(UUID rubricId) {
        if(rubricId == null) {
            return null;
        }
        return rubricUserRepository.findRubricUser(rubricId).orElse(null);
    }

    @Transactional(readOnly = true)
    public Assignment queryAssignmentById(UUID assignmentId) {
        Optional<Assignment> assignment = assignmentRepository.
                findById(assignmentId);
        if (assignment.isEmpty()) {
            log.error("Assignment not found with id: {}", assignmentId);
            throw new AssignmentNotFoundException("Assignment not found with id: " + assignmentId);
        }

        log.info("Assignment queried with id: {}", assignmentId);
        return assignment.get();
    }
}

