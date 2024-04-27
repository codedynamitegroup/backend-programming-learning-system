package com.backend.programming.learning.system.course.service.domain;

import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.event.question.event.*;
import com.backend.programming.learning.system.course.service.domain.event.user.*;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;
import com.backend.programming.learning.system.domain.valueobject.QuestionResponseStatus;

import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
public class CourseDomainServiceImpl implements CourseDomainService {
    @Override
    public void createExam(Exam exam) {
        exam.initializeExam();
        log.info("Exam with id: {} is initiated", exam.getId().getValue());
    }

    @Override
    public void createCourse(Course course) {
        course.initializeCourse();
        log.info("Course with id: {} is initiated", course.getId().getValue());
    }

    @Override
    public void createQuestion(Question question) {
        question.initializeQuestion();
        log.info("Question with id: {} is initiated", question.getId().getValue());
    }

    @Override
    public void createAssignment(Assignment assignment) {
        assignment.initializeAssignment();
        log.info("Assignment with id: {} is initiated", assignment.getId().getValue());

    }

    @Override
    public void createPost(Post post) {
        post.initializePost();
        log.info("Post with id: {} is initiated", post.getId().getValue());
    }

    @Override
    public void createSubmissionAssignment(SubmissionAssignment submissionAssignment) {
        submissionAssignment.initializeAssignmentSubmission();
        log.info("AssignmentSubmission with id: {} is initiated", submissionAssignment.getId().getValue());
    }

    @Override
    public void createSubmissionAssignmentOnlineText(SubmissionAssignmentOnlineText submissionAssignmentOnlineText) {
        submissionAssignmentOnlineText.initializeSubmissionAssignmentOnlineText();
        log.info("SubmissionAssignmentOnlineText with id: {} is initiated", submissionAssignmentOnlineText.getId().getValue());
    }

    @Override
    public void createSubmissionAssignmentFile(SubmissionAssignmentFile submissionAssignmentFile) {
        submissionAssignmentFile.initializeSubmissionAssignmentFile();
        log.info("SubmissionAssignmentFile with id: {} is initiated", submissionAssignmentFile.getId().getValue());

    }

    @Override
    public void createCourseUsers(List<CourseUser> courseUsers) {
        courseUsers.forEach(CourseUser::initializeCourseUser);
        log.info("CourseUser is initiated");
    }

    @Override
    public void createExamQuestions(List<ExamQuestion> examQuestions) {
        examQuestions.forEach(ExamQuestion::initializeExamQuestion);
        log.info("ExamQuestion is initiated");
    }

    @Override
    public void createOrganization(Organization organization) {
        organization.initializeOrganization();
        log.info("Organization with id: {} is initiated", organization.getId().getValue());
    }

    @Override
    public void createCallMoodleApiFunction(CallMoodleApiFunction callMoodleApiFunction) {
        callMoodleApiFunction.initializeCallMoodleApiFunction();
        log.info("CallMoodleApiFunction with id: {} is initiated", callMoodleApiFunction.getId().getValue());
    }

    @Override
    public void createQuestionBankCategory(QuestionBankCategory questionBankCategory) {
        questionBankCategory.initializeQuestionBankCategory();
        log.info("QuestionBankCategory with id: {} is initiated", questionBankCategory.getId().getValue());
    }

    @Override
    public void createExamSubmission(ExamSubmission examSubmission) {
        examSubmission.initializeExamSubmission();
        log.info("ExamSubmission with id: {} is initiated", examSubmission.getId().getValue());
    }

    @Override
    public void createQuestionSubmission(QuestionSubmission questionSubmission) {
        questionSubmission.initializeQuestionSubmission();
        log.info("QuestionSubmission with id: {} is initiated", questionSubmission.getId().getValue());
    }

    @Override
    public QuestionCreatedEvent createQuestionEvent(Question question) {
        log.info("Question with id: {} is created with event", question.getId().getValue());
        return new QuestionCreatedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                QuestionResponseStatus.CREATED);
    }

    @Override
    public QuestionCreateFailedEvent createQuestionFailedEvent(Question question) {
        log.info("Question with id: {} is failed to create with event", question.getId().getValue());
        return new QuestionCreateFailedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                QuestionResponseStatus.CREATE_FAILED);
    }

    @Override
    public QuestionUpdatedEvent updateQuestionEvent(Question question) {
        log.info("Question with id: {} is updated with event", question.getId().getValue());
        return new QuestionUpdatedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                QuestionResponseStatus.UPDATED);
    }

    @Override
    public QuestionUpdateFailedEvent updateQuestionFailedEvent(Question question) {
        log.info("Question with id: {} is failed to update with event", question.getId().getValue());
        return new QuestionUpdateFailedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                QuestionResponseStatus.UPDATE_FAILED);
    }

    @Override
    public QuestionDeletedEvent deleteQuestionEvent(Question question) {
        log.info("Question with id: {} is deleted with event", question.getId().getValue());
        return new QuestionDeletedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                QuestionResponseStatus.DELETED);
    }

    @Override
    public QuestionDeleteFailedEvent deleteQuestionFailedEvent(Question question) {
        log.info("Question with id: {} is failed to delete with event", question.getId().getValue());
        return new QuestionDeleteFailedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                QuestionResponseStatus.DELETE_FAILED);
    }

    @Override
    public void createStartExamSubmission(ExamSubmission examSubmission) {
        examSubmission.initializeStartExamSubmission();
        log.info("StartExamSubmission with id: {} is initiated", examSubmission.getId().getValue());
    }

    @Override
    public void createCalendarEvent(CalendarEvent calendarEvent) {
        calendarEvent.initializeCalendarEvent();
        log.info("CalendarEvent with id: {} is initiated", calendarEvent.getId().getValue());
    }

    @Override
    public void createNotification(Notification notification) {
        notification.initializeNotification();
        log.info("Notification with id: {} is initiated", notification.getId().getValue());
    }

    @Override
    public UserCreatedSuccessEvent createUserSuccess(User user, DomainEventPublisher<UserCreatedSuccessEvent> userCreatedSuccessEventDomainEventPublisher) {
        return new UserCreatedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of("UTC")),
                userCreatedSuccessEventDomainEventPublisher);
    }

    @Override
    public UserCreatedFailEvent createUserFail(User user,
                                               DomainEventPublisher<UserCreatedFailEvent> userCreatedFailEventDomainEventPublisher,
                                               List<String> failureMessages) {
        return new UserCreatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of("UTC")),
                userCreatedFailEventDomainEventPublisher,
                failureMessages);
    }

    @Override
    public UserUpdatedSuccessEvent updateUserSuccess(User user, DomainEventPublisher<UserUpdatedSuccessEvent> userUpdatedSuccessEventDomainEventPublisher) {
        return new UserUpdatedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of("UTC")),
                userUpdatedSuccessEventDomainEventPublisher);
    }

    @Override
    public UserUpdatedFailEvent updateUserFail(User user, DomainEventPublisher<UserUpdatedFailEvent> userUpdatedFailEventDomainEventPublisher, List<String> failureMessages) {
        return new UserUpdatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of("UTC")),
                userUpdatedFailEventDomainEventPublisher,
                failureMessages);
    }

    @Override
    public UserDeletedSuccessEvent deletedUserSuccess(User user, DomainEventPublisher<UserDeletedSuccessEvent> userDeletedSuccessEventDomainEventPublisher) {
        return new UserDeletedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of("UTC")),
                userDeletedSuccessEventDomainEventPublisher);
    }

    @Override
    public UserDeletedFailEvent deletedUserFail(User user, DomainEventPublisher<UserDeletedFailEvent> userDeletedFailEventDomainEventPublisher, List<String> failureMessages) {
        return new UserDeletedFailEvent(user,
                ZonedDateTime.now(ZoneId.of("UTC")),
                userDeletedFailEventDomainEventPublisher,
                failureMessages);
    }
}
