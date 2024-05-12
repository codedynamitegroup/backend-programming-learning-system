package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.quiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle_course.quiz
 * Create by Dang Ngoc Tien
 * Date 5/7/2024 - 12:41 AM
 * Description: ...
 */
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListQuizModel {
    List<QuizModel> quizzes;
    Object warnings;
}
