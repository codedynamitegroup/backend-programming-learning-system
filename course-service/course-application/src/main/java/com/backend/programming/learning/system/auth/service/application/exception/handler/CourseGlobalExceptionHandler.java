package com.backend.programming.learning.system.auth.service.application.exception.handler;

import com.backend.programming.learning.system.application.handler.ErrorDTO;
import com.backend.programming.learning.system.application.handler.GlobalExceptionHandler;
import com.backend.programming.learning.system.course.service.domain.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CourseGlobalExceptionHandler extends GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = {CalendarEventNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(CalendarEventNotFoundException calendarEventNotFoundException) {
        log.error(calendarEventNotFoundException.getMessage(), calendarEventNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(calendarEventNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {ExamSubmissionConflictException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorDTO handleException(ExamSubmissionConflictException examSubmissionConflictException) {
        log.error(examSubmissionConflictException.getMessage(), examSubmissionConflictException);
        return ErrorDTO.builder()
                .code(HttpStatus.CONFLICT.value())
                .status(HttpStatus.CONFLICT.getReasonPhrase())
                .message(examSubmissionConflictException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {AssignmentNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(AssignmentNotFoundException assignmentNotFoundException) {
        log.error(assignmentNotFoundException.getMessage(), assignmentNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(assignmentNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {CourseDomainException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(CourseDomainException courseDomainException) {
        log.error(courseDomainException.getMessage(), courseDomainException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(courseDomainException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {CourseNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(CourseNotFoundException courseNotFoundException) {
        log.error(courseNotFoundException.getMessage(), courseNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(courseNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {ExamNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(ExamNotFoundException examNotFoundException) {
        log.error(examNotFoundException.getMessage(), examNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(examNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {NotificationNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(NotificationNotFoundException notificationNotFoundException) {
        log.error(notificationNotFoundException.getMessage(), notificationNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(notificationNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {OrganizationNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(OrganizationNotFoundException organizationNotFoundException) {
        log.error(organizationNotFoundException.getMessage(), organizationNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(organizationNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {PostNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(PostNotFoundException postNotFoundException) {
        log.error(postNotFoundException.getMessage(), postNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(postNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {SubmissionAssignmentNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(SubmissionAssignmentNotFoundException submissionAssignmentNotFoundException) {
        log.error(submissionAssignmentNotFoundException.getMessage(), submissionAssignmentNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(submissionAssignmentNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {SubmissionAssignmentOnlineTextNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(SubmissionAssignmentOnlineTextNotFoundException submissionAssignmentOnlineTextNotFoundException) {
        log.error(submissionAssignmentOnlineTextNotFoundException.getMessage(), submissionAssignmentOnlineTextNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(submissionAssignmentOnlineTextNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(UserNotFoundException userNotFoundException) {
        log.error(userNotFoundException.getMessage(), userNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(userNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {ExamClosedException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(ExamClosedException examClosedException) {
        log.error(examClosedException.getMessage(), examClosedException);
        return ErrorDTO.builder()
                .code(HttpStatus.FORBIDDEN.value())
                .status(HttpStatus.FORBIDDEN.getReasonPhrase())
                .message(examClosedException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {QuestionSubmissionNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(QuestionSubmissionNotFoundException questionSubmissionNotFoundException) {
        log.error(questionSubmissionNotFoundException.getMessage(), questionSubmissionNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(questionSubmissionNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {ExamSubmissionNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(ExamSubmissionNotFoundException examSubmissionNotFoundException) {
        log.error(examSubmissionNotFoundException.getMessage(), examSubmissionNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(examSubmissionNotFoundException.getMessage())
                .build();
    }
}

