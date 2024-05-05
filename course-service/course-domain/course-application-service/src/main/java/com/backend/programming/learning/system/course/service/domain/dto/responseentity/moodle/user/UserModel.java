package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user;

import lombok.*;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.moodle
 * Create by Dang Ngoc Tien
 * Date 5/2/2024 - 12:28 AM
 * Description: ...
 */
@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    String id;
    String username;
    String firstname;
    String lastname;
    String fullname;
    String email;
    String department;
    Integer firstaccess;
    Integer lastaccess;
    String auth;
    Boolean suspended;
    Boolean confirmed;
    String lang;
    String theme;
    String timezone;
    Integer mailformat;
    String description;
    Integer descriptionformat;
    String country;
    String profileimageurlsmall;
    String profileimageurl;
    Object preferences;
}
