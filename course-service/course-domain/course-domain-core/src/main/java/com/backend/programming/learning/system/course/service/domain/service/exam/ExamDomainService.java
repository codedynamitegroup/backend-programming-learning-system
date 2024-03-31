package com.backend.programming.learning.system.course.service.domain.service.exam;

import com.backend.programming.learning.system.course.service.domain.entity.exam.Exam;
import com.backend.programming.learning.system.course.service.domain.event.exam.ExamCreateEvent;


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
