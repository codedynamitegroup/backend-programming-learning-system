package com.backend.programming.learning.system.course.service.domain.dto.responseentity.user_moodle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_moodle
 * Create by Dang Ngoc Tien
 * Date 5/9/2024 - 11:31 PM
 * Description: ...
 */
@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer roleid;
    private String name;
    private String shortname;
    private Integer sortorder;
}
