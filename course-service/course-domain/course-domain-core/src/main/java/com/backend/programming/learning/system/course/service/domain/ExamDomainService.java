package com.backend.programming.learning.system.course.service.domain;

import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.event.ExamCreateEvent;


/**
 * com.backend.programming.learning.system
 * Create by Dang Ngoc Tien
 * Date 3/20/2024 - 12:00 AM
 * Description: ...
 */
public interface ExamDomainService {
    ExamCreateEvent validateAndInitiateExam(Exam exam);

    ExamCreateEvent validateAndUpdateExam(Long examId, Exam exam);
}
