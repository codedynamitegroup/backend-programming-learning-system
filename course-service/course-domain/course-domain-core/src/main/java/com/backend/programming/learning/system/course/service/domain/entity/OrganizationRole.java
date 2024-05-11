package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.OrganizationRoleId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

public class OrganizationRole extends AggregateRoot<OrganizationRoleId> {
    private RoleMoodle roleMoodle;
    private Organization organization;

    private OrganizationRole(Builder builder) {
       super.setId(builder.id);
        setRoleMoodle(builder.roleMoodle);
        setOrganization(builder.organization);
    }

    public RoleMoodle getRoleMoodle() {
        return roleMoodle;
    }

    public void setRoleMoodle(RoleMoodle roleMoodle) {
        this.roleMoodle = roleMoodle;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private OrganizationRoleId id;
        private RoleMoodle roleMoodle;
        private Organization organization;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(OrganizationRoleId val) {
            id = val;
            return this;
        }

        public Builder roleMoodle(RoleMoodle val) {
            roleMoodle = val;
            return this;
        }

        public Builder organization(Organization val) {
            organization = val;
            return this;
        }

        public OrganizationRole build() {
            return new OrganizationRole(this);
        }
    }
}
