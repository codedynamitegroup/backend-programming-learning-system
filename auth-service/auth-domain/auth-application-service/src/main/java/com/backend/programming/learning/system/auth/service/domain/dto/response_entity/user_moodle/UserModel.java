package com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_moodle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
