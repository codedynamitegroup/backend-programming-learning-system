package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.Exam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CourseDomainServiceImpl implements CourseDomainService{
    @Override
    public void createExam(Exam exam) {
        exam.initializeExam();
        log.info("Exam with id: {} is initiated", exam.getId().getValue());
    }
}
