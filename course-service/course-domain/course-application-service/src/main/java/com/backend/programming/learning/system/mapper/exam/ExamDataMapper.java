package com.backend.programming.learning.system.mapper.exam;

import com.backend.programming.learning.system.dto.method.create.exam.CreateExamCommand;
import com.backend.programming.learning.system.dto.method.create.exam.CreateExamResponse;
import com.backend.programming.learning.system.dto.method.query.exam.QueryAllExamResponse;
import com.backend.programming.learning.system.dto.method.query.exam.QueryExamResponse;
import com.backend.programming.learning.system.dto.responseentity.exam.ExamResponseEntity;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.valueobject.CourseId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;


/**
 * com.backend.programming.learning.system.mapper
 * Create by Dang Ngoc Tien
 * Date 4/16/2024 - 8:59 PM
 * Description: ...
 */
@Component
public class ExamDataMapper {

    public Exam createExamCommandToExam(CreateExamCommand createExamCommand) {
        return Exam.builder()
                .courseId(new CourseId(createExamCommand.getCourseId()))
                .name(createExamCommand.getName())
                .scores(createExamCommand.getScore())
                .maxScores(createExamCommand.getMaxScore())
                .time_open(createExamCommand.getTimeOpen())
                .time_close(createExamCommand.getTimeClose())
                .time_limit(createExamCommand.getTimeLimit())
                .intro(createExamCommand.getIntro())
                .overdue_handing(createExamCommand.getOverdueHandling())
                .can_redo_questions(createExamCommand.getCanRedoQuestions())
                .max_attempts(createExamCommand.getMaxAttempts())
                .shuffle_answers(createExamCommand.getShuffleQuestions())
                .grade_method(createExamCommand.getGradeMethod())
                .build();
    }

    public CreateExamResponse examToCreateExamResponse(Exam examCreated, String message) {
        return CreateExamResponse.builder()
                .id(examCreated.getId().getValue())
                .courseId(examCreated.getCourseId())
                .name(examCreated.getName())
                .scores(examCreated.getScores())
                .maxScores(examCreated.getMaxScores())
                .timeOpen(examCreated.getTime_open())
                .timeClose(examCreated.getTime_close())
                .timeLimit(examCreated.getTime_limit())
                .intro(examCreated.getIntro())
                .overdueHanding(examCreated.getOverdue_handing())
                .canRedoQuestions(examCreated.getCan_redo_questions())
                .maxAttempts(examCreated.getMax_attempts())
                .shuffleAnswers(examCreated.getShuffle_answers())
                .gradeMethod(examCreated.getGrade_method())
                .createdAt(examCreated.getCreated_at())
                .updatedAt(examCreated.getUpdated_at())
                .message(message)
                .build();
    }

    public QueryExamResponse examToQueryExamResponse(Exam exam, String message) {
        return QueryExamResponse.builder()
                .id(exam.getId().getValue())
                .courseId(exam.getCourseId())
                .name(exam.getName())
                .scores(exam.getScores())
                .maxScores(exam.getMaxScores())
                .timeOpen(exam.getTime_open())
                .timeClose(exam.getTime_close())
                .timeLimit(exam.getTime_limit())
                .intro(exam.getIntro())
                .overdueHanding(exam.getOverdue_handing())
                .canRedoQuestions(exam.getCan_redo_questions())
                .maxAttempts(exam.getMax_attempts())
                .shuffleAnswers(exam.getShuffle_answers())
                .gradeMethod(exam.getGrade_method())
                .createdAt(exam.getCreated_at())
                .updatedAt(exam.getUpdated_at())
                .message(message)
                .build();
    }

    public ExamResponseEntity examToQueryExamResponse(Exam exam) {
        return ExamResponseEntity.builder()
                .id(exam.getId().getValue())
                .courseId(exam.getCourseId())
                .name(exam.getName())
                .scores(exam.getScores())
                .maxScores(exam.getMaxScores())
                .timeOpen(exam.getTime_open())
                .timeClose(exam.getTime_close())
                .timeLimit(exam.getTime_limit())
                .intro(exam.getIntro())
                .overdueHanding(exam.getOverdue_handing())
                .canRedoQuestions(exam.getCan_redo_questions())
                .maxAttempts(exam.getMax_attempts())
                .shuffleAnswers(exam.getShuffle_answers())
                .gradeMethod(exam.getGrade_method())
                .createdAt(exam.getCreated_at())
                .updatedAt(exam.getUpdated_at())
                .build();
    }

    public QueryAllExamResponse examsToQueryAllExamResponse(Page<Exam> exams) {
        return QueryAllExamResponse.builder()
                .exams(exams.stream()
                        .map(this::examToQueryExamResponse)
                        .toList())
                .currentPage(exams.getNumber())
                .totalPages(exams.getTotalPages())
                .totalItems(exams.getTotalElements())
                .build();
    }
}
