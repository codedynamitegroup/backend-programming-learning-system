package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle_course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle_course
 * Create by Dang Ngoc Tien
 * Date 5/6/2024 - 11:19 PM
 * Description: ...
 */
@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCourseMoodle {
    List<CourseModel> courses;
}
