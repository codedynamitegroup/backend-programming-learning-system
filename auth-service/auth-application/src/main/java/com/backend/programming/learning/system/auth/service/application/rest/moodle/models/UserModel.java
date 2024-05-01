package com.backend.programming.learning.system.auth.service.application.rest.moodle.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.moodle
 * Create by Dang Ngoc Tien
 * Date 5/2/2024 - 12:28 AM
 * Description: ...
 */
@Setter
@Getter
@Builder
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
    String profileimageurlsmall;
    String profileimageurl;
    Object preferences;
}
