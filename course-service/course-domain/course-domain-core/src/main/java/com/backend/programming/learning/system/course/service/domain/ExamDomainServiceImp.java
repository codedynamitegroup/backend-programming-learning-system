package com.backend.programming.learning.system.course.service.domain;

import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.event.ExamCreateEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain
 * Create by Dang Ngoc Tien
 * Date 3/20/2024 - 12:02 AM
 * Description: ...
 */
@Slf4j
public class ExamDomainServiceImp implements ExamDomainService {
    @Override
    public ExamCreateEvent validateAndInitiateExam(Exam exam) {
        log.info("validateAndInitiateExam");
        return new ExamCreateEvent(exam, LocalDateTime.now());
    }

    @Override
    public ExamCreateEvent validateAndUpdateExam(Long examId, Exam exam) {
        log.info("validateAndUpdateExam");
        return new ExamCreateEvent(exam, LocalDateTime.now());
    }
}
