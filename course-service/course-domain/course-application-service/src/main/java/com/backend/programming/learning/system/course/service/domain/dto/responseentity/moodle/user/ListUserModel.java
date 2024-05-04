package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user;

import lombok.*;

import java.util.List;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.moodle.models
 * Create by Dang Ngoc Tien
 * Date 5/2/2024 - 11:05 PM
 * Description: ...
 */
@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListUserModel {
    List<UserModel> users;
    Object warnings;
}
