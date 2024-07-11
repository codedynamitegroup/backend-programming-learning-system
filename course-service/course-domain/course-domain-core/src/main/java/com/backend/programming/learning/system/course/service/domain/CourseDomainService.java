package com.backend.programming.learning.system.course.service.domain;

import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.event.organization.*;
import com.backend.programming.learning.system.course.service.domain.event.question.event.*;
import com.backend.programming.learning.system.course.service.domain.event.user.*;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;


import java.util.List;

public interface CourseDomainService {
    void createExam(Exam exam);

    void createCourse(Course course);

    void createQuestion(Question question);

    void createAssignment(Assignment assignment);

    void createPost(Post post);

    void createSubmissionAssignment(SubmissionAssignment submissionAssignment);

    void createSubmissionAssignmentFile(SubmissionAssignmentFile submissionAssignmentFile);
    void createCourseUsers(List<CourseUser> courseUsers);
    void createCourseUser(CourseUser courseUser);

    void createExamQuestions(List<ExamQuestion> examQuestions);

    void createOrganization(Organization organization);

    void createSection(Section section);

    void createModule(Module module);

    void createQuestionBankCategory(QuestionBankCategory questionBankCategory);

    void createExamSubmission(ExamSubmission examSubmission);

    void createQuestionSubmission(QuestionSubmission questionSubmission);

    QuestionCreatedEvent createQuestionEvent(Question question, String sagaId);
    QuestionCreateFailedEvent createQuestionFailedEvent(Question question, String sagaId);
    QuestionUpdatedEvent updateQuestionEvent(Question question, String sagaId);
    QuestionUpdateFailedEvent updateQuestionFailedEvent(Question question, String sagaId);
    QuestionDeletedEvent deleteQuestionEvent(Question question, String sagaId);
    QuestionDeleteFailedEvent deleteQuestionFailedEvent(Question question, String sagaId);

    void createStartExamSubmission(ExamSubmission examSubmission);
    void createCalendarEvent(CalendarEvent calendarEvent);
    void createNotification(Notification notification);

    UserCreatedSuccessEvent createdUserSuccess(User user);
    UserCreatedFailEvent createdUserFail(User user, List<String> failureMessages);
    UserUpdatedSuccessEvent updatedUserSuccess(User user);
    UserUpdatedFailEvent updatedUserFail(User user, List<String> failureMessages);
    UserDeletedSuccessEvent deletedUserSuccess(User user);
    UserDeletedFailEvent deletedUserFail(User user, List<String> failureMessages);

    OrganizationCreatedSuccessEvent createdOrganizationSuccess(Organization organization);
    OrganizationCreatedFailEvent createdOrganizationFail(Organization organization, List<String> failureMessages);
    OrganizationUpdatedSuccessEvent updatedOrganizationSuccess(Organization organization);
    OrganizationUpdatedFailEvent updatedOrganizationFail(Organization organization, List<String> failureMessages);
    OrganizationDeletedSuccessEvent deletedOrganizationSuccess(Organization organization);
    OrganizationDeletedFailEvent deletedOrganizationFail(Organization organization, List<String> failureMessages);

    UserUpdatedEvent updateUser(User user);

    UserCreatedEvent createUser(User user);

    void createIntroAttachment(IntroAttachment introAttachment);

    void createSubmissionGrade(SubmissionGrade submissionGrade);
}
