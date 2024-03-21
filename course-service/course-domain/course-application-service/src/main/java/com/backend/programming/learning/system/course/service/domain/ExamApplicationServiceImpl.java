package com.backend.programming.learning.system.course.service.domain;

import com.backend.programming.learning.system.course.service.domain.ports.input.service.ExamApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.course.service.domain
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 10:17 PM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class ExamApplicationServiceImpl implements ExamApplicationService {
//    private final ExamCreateCommandHandler examCreateCommandHandler;
    @Override
    public String getExam() {
        log.info("Getting exam");
        return "oke con dê";
    }
}
