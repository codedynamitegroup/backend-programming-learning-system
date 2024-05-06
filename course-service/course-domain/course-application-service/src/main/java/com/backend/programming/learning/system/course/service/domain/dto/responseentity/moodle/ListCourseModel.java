package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCourseModel {
    List<CourseModel> courses;}
