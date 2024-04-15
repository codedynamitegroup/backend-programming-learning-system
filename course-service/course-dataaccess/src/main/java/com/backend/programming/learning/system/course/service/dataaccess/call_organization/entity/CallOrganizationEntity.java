package com.backend.programming.learning.system.course.service.dataaccess.call_organization.entity;

import com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.entity.CallMoodleApiFunctionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "call_organzation")
@Entity
public class CallOrganizationEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private OrganizationEntity organization;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "call_moodle_api_function_id", referencedColumnName = "id")
    private CallMoodleApiFunctionEntity callMoodleApiFunction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallOrganizationEntity that = (CallOrganizationEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
