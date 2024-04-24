package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.*;


import java.util.List;
import com.backend.programming.learning.system.entity.Question;
import com.backend.programming.learning.system.event.question.event.*;

public interface CourseDomainService {
    void createExam(Exam exam);

    void createCourse(Course course);

    void createQuestion(Question question);

    void createAssignment(Assignment assignment);

    void createPost(Post post);

    void createSubmissionAssignment(SubmissionAssignment submissionAssignment);

    void createSubmissionAssignmentOnlineText(SubmissionAssignmentOnlineText submissionAssignmentOnlineText);

    void createSubmissionAssignmentFile(SubmissionAssignmentFile submissionAssignmentFile);
    void createCourseUsers(List<CourseUser> courseUsers);

    void createExamQuestions(List<ExamQuestion> examQuestions);

    void createOrganization(Organization organization);

    void createCallMoodleApiFunction(CallMoodleApiFunction callMoodleApiFunction);

    void createQuestionBankCategory(QuestionBankCategory questionBankCategory);

    void createExamSubmission(ExamSubmission examSubmission);

    void createQuestionSubmission(QuestionSubmission questionSubmission);

    QuestionCreatedEvent createQuestionEvent(Question question);
    QuestionCreateFailedEvent createQuestionFailedEvent(Question question);
    QuestionUpdatedEvent createQuestionUpdatedEvent(Question question);
    QuestionUpdateFailedEvent createQuestionUpdateFailedEvent(Question question);
    QuestionDeletedEvent createQuestionDeletedEvent(Question question);
    QuestionDeleteFailedEvent createQuestionDeleteFailedEvent(Question question);
}
