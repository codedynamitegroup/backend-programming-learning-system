package com.backend.programming.learning.system.course.service.domain.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.create.CreateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.create.CreateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.get.ExamsResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.event.ExamCreateEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.mapper
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 12:27 AM
 * Description: ...
 */
@Component
public class ExamDataMapper {
    public Exam createExamCommandToExam(CreateExamCommand createExamCommand) {
        return new Exam(
//                new com.backend.programming.learning.system.valueobject.ExamId(createExamCommand.getExamId()),
                createExamCommand.getCourseId(),
                createExamCommand.getName(),
                createExamCommand.getIntro(),
                createExamCommand.getScore(),
                createExamCommand.getMaxScore(),
                createExamCommand.getTimeOpen(),
                createExamCommand.getTimeClose(),
                createExamCommand.getTimeLimit(),
                createExamCommand.getOverdueHandling(),
                createExamCommand.getCanRedoQuestion(),
                createExamCommand.getMaxAttempts(),
                createExamCommand.getShuffleAnswer(),
                createExamCommand.getGradeMethod()
        );
    }

    public CreateExamResponse examCreateEventToCreateExamResponse(ExamCreateEvent examCreateEvent, String message) {
        return new CreateExamResponse(examCreateEvent.getExam(), message);
    }

    public ExamsResponse examsToCreateExamResponses(List<Exam> exams,String message) {
        return ExamsResponse.builder()
                .exams(exams)
                .message(message)
                .build();
    }
}
