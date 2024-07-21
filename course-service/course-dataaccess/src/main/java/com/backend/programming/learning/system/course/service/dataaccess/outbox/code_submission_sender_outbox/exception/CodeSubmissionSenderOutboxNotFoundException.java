package com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_sender_outbox.exception;

public class CodeSubmissionSenderOutboxNotFoundException extends RuntimeException{
    public CodeSubmissionSenderOutboxNotFoundException(String msg){
        super(msg);
    }
}
