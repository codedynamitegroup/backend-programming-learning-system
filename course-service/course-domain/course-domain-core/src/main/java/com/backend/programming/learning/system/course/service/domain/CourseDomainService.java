package com.backend.programming.learning.system.course.service.domain;

import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.event.calendarevent.CalendarEventEvent;
import com.backend.programming.learning.system.course.service.domain.event.calendarevent.CalendarEventUpdatedEvent;
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
    QuestionUpdatedEvent updateQuestionEvent(Question question);
    QuestionUpdateFailedEvent updateQuestionFailedEvent(Question question);
    QuestionDeletedEvent deleteQuestionEvent(Question question);
    QuestionDeleteFailedEvent deleteQuestionFailedEvent(Question question);

    void createStartExamSubmission(ExamSubmission examSubmission);
    void createCalendarEvent(CalendarEvent calendarEvent);
    void createNotification(Notification notification);

    UserCreatedSuccessEvent createUserSuccess(User user,
                                              DomainEventPublisher<UserCreatedSuccessEvent> userCreatedSuccessEventDomainEventPublisher);

    UserCreatedFailEvent createUserFail(User user,
                                        DomainEventPublisher<UserCreatedFailEvent> userCreatedFailEventDomainEventPublisher,
                                        List<String> failureMessages);
    UserUpdatedSuccessEvent updateUserSuccess(User user,
                                              DomainEventPublisher<UserUpdatedSuccessEvent> userUpdatedSuccessEventDomainEventPublisher);
    UserUpdatedFailEvent updateUserFail(User user,
                                        DomainEventPublisher<UserUpdatedFailEvent> userUpdatedFailEventDomainEventPublisher,
                                        List<String> failureMessages);
    UserDeletedSuccessEvent deletedUserSuccess(User user,
                                               DomainEventPublisher<UserDeletedSuccessEvent> userDeletedSuccessEventDomainEventPublisher);
    UserDeletedFailEvent deletedUserFail(User user,
                                         DomainEventPublisher<UserDeletedFailEvent> userDeletedFailEventDomainEventPublisher,
                                         List<String> failureMessages);




}
