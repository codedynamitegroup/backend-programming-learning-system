package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user;

import lombok.*;

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