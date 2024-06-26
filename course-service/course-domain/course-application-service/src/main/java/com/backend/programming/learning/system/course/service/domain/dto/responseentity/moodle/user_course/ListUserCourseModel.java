package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user_course;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListUserCourseModel {
    List<UserCourseModel> courses;
}
