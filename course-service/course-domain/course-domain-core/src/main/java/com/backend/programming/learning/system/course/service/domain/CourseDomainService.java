package com.backend.programming.learning.system.course.service.domain;

import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.event.question.event.*;


import java.util.List;

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

    void createStartExamSubmission(ExamSubmission examSubmission);
    void createCalendarEvent(CalendarEvent calendarEvent);
    void createNotification(Notification notification);
}
