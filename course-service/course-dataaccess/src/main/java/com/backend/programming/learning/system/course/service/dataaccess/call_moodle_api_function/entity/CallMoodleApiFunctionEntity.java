package com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.entity;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.call_organization.entity.CallOrganizationEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "call_moodle_api_function")
@Entity
public class CallMoodleApiFunctionEntity {

    @Id
    @Column(name = "id")
    private UUID id;


    @OneToMany(mappedBy = "callMoodleApiFunction")
    List<CallOrganizationEntity> callOrganizations;

    private String area;
    private String name;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallMoodleApiFunctionEntity that = (CallMoodleApiFunctionEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
