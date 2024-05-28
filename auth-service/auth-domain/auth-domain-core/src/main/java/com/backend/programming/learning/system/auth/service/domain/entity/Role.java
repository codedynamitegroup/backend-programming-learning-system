package com.backend.programming.learning.system.auth.service.domain.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Role extends AggregateRoot<RoleId> {
    private String description;
    private String name;

    public void initializeRole() {
        setId(new RoleId(UUID.randomUUID()));
    }

    private Role(Builder builder) {
        super.setId(builder.roleId);
        description = builder.description;
        name = builder.name;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String description;
        private String name;
        private RoleId roleId;

        private Builder() {
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder id(RoleId val) {
            roleId = val;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }
}
