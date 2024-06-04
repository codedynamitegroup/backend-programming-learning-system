package com.backend.programming.learning.system.auth.service.domain.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Set;
import java.util.UUID;

public class User extends AggregateRoot<UserId> {
    private final String email;
    private String username;
    private ZonedDateTime dob;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String avatarUrl;
    private String refreshToken;
    private ZonedDateTime lastLogin;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Boolean isLinkedWithGoogle;
    private Boolean isLinkedWithMicrosoft;
    private Organization organization;
    private Boolean isDeleted;
    private Integer otp;
    private ZonedDateTime otpExpireAt;
    Set<Role> roles;

    private User(Builder builder) {
        super.setId(builder.userId);
        email = builder.email;
        setUsername(builder.username);
        setDob(builder.dob);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setPhone(builder.phone);
        setAddress(builder.address);
        setAvatarUrl(builder.avatarUrl);
        setRefreshToken(builder.refreshToken);
        setLastLogin(builder.lastLogin);
        createdAt = builder.createdAt;
        setUpdatedAt(builder.updatedAt);
        isLinkedWithGoogle = builder.isLinkedWithGoogle;
        isLinkedWithMicrosoft = builder.isLinkedWithMicrosoft;
        setOrganization(builder.organization);
        isDeleted = builder.isDeleted;
        setOtp(builder.otp);
        setOtpExpireAt(builder.otpExpireAt);
        setRoles(builder.roles);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void initializeUser() {
        setId(new UserId(UUID.randomUUID()));
        lastLogin = ZonedDateTime.now(ZoneId.of(DomainConstants.UTC));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.UTC));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.UTC));
        isDeleted = false;
    }

    public void deleteUser() {
        isDeleted = true;
    }

    public String getEmail() {
        return email;
    }

    public ZonedDateTime getDob() {
        return dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDob(ZonedDateTime dob) {
        this.dob = dob;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getLinkedWithGoogle() {
        return isLinkedWithGoogle;
    }

    public void setLinkedWithGoogle(Boolean linkedWithGoogle) {
        isLinkedWithGoogle = linkedWithGoogle;
    }

    public Boolean getLinkedWithMicrosoft() {
        return isLinkedWithMicrosoft;
    }

    public void setLinkedWithMicrosoft(Boolean linkedWithMicrosoft) {
        isLinkedWithMicrosoft = linkedWithMicrosoft;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public ZonedDateTime getOtpExpireAt() {
        return otpExpireAt;
    }

    public void setOtpExpireAt(ZonedDateTime otpExpireAt) {
        this.otpExpireAt = otpExpireAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String email;
        private String username;
        private ZonedDateTime dob;
        private String firstName;
        private String lastName;
        private String phone;
        private String address;
        private String avatarUrl;
        private String refreshToken;
        private ZonedDateTime lastLogin;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private Boolean isLinkedWithGoogle;
        private Boolean isLinkedWithMicrosoft;
        private Organization organization;
        private Boolean isDeleted;
        private Integer otp;
        private ZonedDateTime otpExpireAt;
        private Set<Role> roles;
        private UserId userId;

        private Builder() {
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder dob(ZonedDateTime val) {
            dob = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder avatarUrl(String val) {
            avatarUrl = val;
            return this;
        }

        public Builder refreshToken(String val) {
            refreshToken = val;
            return this;
        }

        public Builder lastLogin(ZonedDateTime val) {
            lastLogin = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(ZonedDateTime val) {
            updatedAt = val;
            return this;
        }

        public Builder isLinkedWithGoogle(Boolean val) {
            isLinkedWithGoogle = val;
            return this;
        }

        public Builder isLinkedWithMicrosoft(Boolean val) {
            isLinkedWithMicrosoft = val;
            return this;
        }

        public Builder organization(Organization val) {
            organization = val;
            return this;
        }

        public Builder isDeleted(Boolean val) {
            isDeleted = val;
            return this;
        }

        public Builder otp(Integer val) {
            otp = val;
            return this;
        }

        public Builder otpExpireAt(ZonedDateTime val) {
            otpExpireAt = val;
            return this;
        }

        public Builder roles(Set<Role> val) {
            roles = val;
            return this;
        }

        public Builder id(UserId val) {
            userId = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
