package com.backend.programming.learning.system.course.service.domain;

import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.event.organization.*;
import com.backend.programming.learning.system.course.service.domain.event.question.event.*;
import com.backend.programming.learning.system.course.service.domain.event.user.*;
import com.backend.programming.learning.system.domain.DomainConstants;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
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
    public void createCourseUser(CourseUser courseUser) {
        courseUser.initializeCourseUser();
        log.info("CourseUser with id: {} is initiated", courseUser.getId().getValue());
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
    public void createSection(Section section) {
        section.initializeSection();
        log.info("Section with id: {} is initiated", section.getId().getValue());
    }

    @Override
    public void createModule(Module module) {
        module.initializeModule();
        log.info("Module with id: {} is initiated", module.getId().getValue());

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
    public QuestionCreatedEvent createQuestionEvent(Question question, String sagaId) {
        log.info("Question with id: {} is created with event", question.getId().getValue());
        return new QuestionCreatedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                CopyState.CREATED, sagaId);
    }

    @Override
    public QuestionCreateFailedEvent createQuestionFailedEvent(Question question, String sagaId) {
        log.info("Question with id: {} is failed to create with event", question.getId().getValue());
        return new QuestionCreateFailedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                CopyState.CREATE_FAILED, sagaId);
    }

    @Override
    public QuestionUpdatedEvent updateQuestionEvent(Question question, String sagaId) {
        log.info("Question with id: {} is updated with event", question.getId().getValue());
        return new QuestionUpdatedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                CopyState.UPDATED, sagaId);
    }

    @Override
    public QuestionUpdateFailedEvent updateQuestionFailedEvent(Question question, String sagaId) {
        log.info("Question with id: {} is failed to update with event", question.getId().getValue());
        return new QuestionUpdateFailedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                CopyState.UPDATE_FAILED, sagaId);
    }

    @Override
    public QuestionDeletedEvent deleteQuestionEvent(Question question, String sagaId) {
        log.info("Question with id: {} is deleted with event", question.getId().getValue());
        return new QuestionDeletedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                CopyState.DELETED, sagaId);
    }

    @Override
    public QuestionDeleteFailedEvent deleteQuestionFailedEvent(Question question, String sagaId) {
        log.info("Question with id: {} is failed to delete with event", question.getId().getValue());
        return new QuestionDeleteFailedEvent(question,
                ZonedDateTime.now(ZoneId.of("UTC")),
                CopyState.DELETE_FAILED, sagaId);
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
    public UserCreatedSuccessEvent createdUserSuccess(User user) {
        return new UserCreatedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public UserCreatedFailEvent createdUserFail(User user, List<String> failureMessages) {
        return new UserCreatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)), failureMessages);
    }

    @Override
    public UserUpdatedSuccessEvent updatedUserSuccess(User user) {
        return new UserUpdatedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public UserUpdatedFailEvent updatedUserFail(User user, List<String> failureMessages) {
        return new UserUpdatedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)),
                failureMessages);
    }

    @Override
    public UserDeletedSuccessEvent deletedUserSuccess(User user) {
        return new UserDeletedSuccessEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public UserDeletedFailEvent deletedUserFail(User user, List<String> failureMessages) {
        return new UserDeletedFailEvent(user,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)),
                failureMessages);
    }


    @Override
    public OrganizationCreatedSuccessEvent createdOrganizationSuccess(Organization organization) {
        return new OrganizationCreatedSuccessEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public OrganizationCreatedFailEvent createdOrganizationFail(Organization organization, List<String> failureMessages) {
        return new OrganizationCreatedFailEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)), failureMessages);
    }

    @Override
    public OrganizationUpdatedSuccessEvent updatedOrganizationSuccess(Organization organization) {
        return new OrganizationUpdatedSuccessEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public OrganizationUpdatedFailEvent updatedOrganizationFail(Organization organization, List<String> failureMessages) {
        return new OrganizationUpdatedFailEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)), failureMessages);
    }

    @Override
    public OrganizationDeletedSuccessEvent deletedOrganizationSuccess(Organization organization) {
        return new OrganizationDeletedSuccessEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
    }

    @Override
    public OrganizationDeletedFailEvent deletedOrganizationFail(Organization organization, List<String> failureMessages) {
        return new OrganizationDeletedFailEvent(organization,
                ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)), failureMessages);
    }

    @Override
    public UserUpdatedEvent updateUser(User user) {
        return new UserUpdatedEvent(user, ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)), List.of());
    }

    @Override
    public UserCreatedEvent createUser(User user) {
        user.initializeUser();
        log.info("User with id: {} is initiated", user.getId().getValue());
        return new UserCreatedEvent(user, ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)), List.of());
    }

    @Override
    public void createIntroAttachment(IntroAttachment introAttachment) {
        introAttachment.initializeIntroAttachment();
        log.info("IntroAttachment with id: {} is initiated", introAttachment.getId().getValue());
    }

    @Override
    public void createSubmissionGrade(SubmissionGrade submissionGrade) {
        submissionGrade.initializeSubmissionGrade();
        log.info("SubmissionGrade with id: {} is initiated", submissionGrade.getId().getValue());
    }
}
