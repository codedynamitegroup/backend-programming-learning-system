package com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_moodle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    String address;
    String phone1;
    String department;
    Long firstaccess;
    Long lastaccess;
    Long lastcourseaccess;
    String description;
    Integer descriptionformat;
    String city;
    String country;
    String profileimageurlsmall;
    String profileimageurl;
    List<Role> roles;
    Object preferences;
    Object enrolledcourses;
}

