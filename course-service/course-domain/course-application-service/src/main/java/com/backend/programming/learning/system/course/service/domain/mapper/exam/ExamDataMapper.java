package com.backend.programming.learning.system.course.service.domain.mapper.exam;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryAllExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.exam.UpdateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam.ExamResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
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

    public Exam createExamCommandToExam(Course course, CreateExamCommand createExamCommand) {
        return Exam.builder()
                .course(course)
                .name(createExamCommand.name())
                .score(createExamCommand.score())
                .maxScore(createExamCommand.maxScore())
                .timeOpen(createExamCommand.timeOpen())
                .timeClose(createExamCommand.timeClose())
                .timeLimit(createExamCommand.timeLimit())
                .intro(createExamCommand.intro())
                .overdueHandling(createExamCommand.overdueHandling())
                .overdueHanding(createExamCommand.overdueHandling())
                .canRedoQuestions(createExamCommand.canRedoQuestions())
                .maxAttempts(createExamCommand.maxAttempts())
                .shuffleAnswers(createExamCommand.shuffleQuestions())
                .gradeMethod(createExamCommand.gradeMethod())
                .build();
    }

    public CreateExamResponse examToCreateExamResponse(Exam examCreated, String message) {
        return CreateExamResponse.builder()
                .id(examCreated.getId().getValue())
                .courseId(examCreated.getCourse().getId())
                .name(examCreated.getName())
                .scores(examCreated.getScore())
                .maxScores(examCreated.getMaxScore())
                .timeOpen(examCreated.getTimeOpen())
                .timeClose(examCreated.getTimeClose())
                .timeLimit(examCreated.getTimeLimit())
                .intro(examCreated.getIntro())
                .overdueHanding(examCreated.getOverdueHanding())
                .canRedoQuestions(examCreated.getCanRedoQuestions())
                .maxAttempts(examCreated.getMaxAttempts())
                .shuffleAnswers(examCreated.getShuffleAnswers())
                .gradeMethod(examCreated.getGradeMethod())
                .createdAt(examCreated.getCreatedAt())
                .updatedAt(examCreated.getUpdatedAt())
                .message(message)
                .build();
    }

    public ExamResponseEntity examToQueryExamResponse(Exam exam) {
        return ExamResponseEntity.builder()
                .id(exam.getId().getValue())
                .courseId(exam.getCourse().getId())
                .name(exam.getName())
                .scores(exam.getScore())
                .maxScores(exam.getMaxScore())
                .timeOpen(exam.getTimeOpen())
                .timeClose(exam.getTimeClose())
                .timeLimit(exam.getTimeLimit())
                .intro(exam.getIntro())
                .overdueHanding(exam.getOverdueHanding())
                .canRedoQuestions(exam.getCanRedoQuestions())
                .maxAttempts(exam.getMaxAttempts())
                .shuffleAnswers(exam.getShuffleAnswers())
                .gradeMethod(exam.getGradeMethod())
                .createdAt(exam.getCreatedAt())
                .updatedAt(exam.getUpdatedAt())
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

    public UpdateExamResponse examToUpdateExamResponse(Exam exam, String message) {
        return UpdateExamResponse.builder()
                .examId((exam.getId().getValue()))
                .courseId(exam.getCourse().getId().getValue())
                .name(exam.getName())
                .score(exam.getScore())
                .maxScore(exam.getMaxScore())
                .timeOpen(exam.getTimeOpen())
                .timeClose(exam.getTimeClose())
                .timeLimit(exam.getTimeLimit())
                .intro(exam.getIntro())
                .overdueHandling(exam.getOverdueHanding())
                .canRedoQuestions(exam.getCanRedoQuestions())
                .maxAttempts(exam.getMaxAttempts())
//                .shuffleAnswers(exam.getShuffleAnswers())
                .gradeMethod(exam.getGradeMethod())
                .message(message)
                .build();
    }
}