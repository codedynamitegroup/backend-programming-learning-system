package com.backend.programming.learning.system.core.service.domain.dto.responseentity.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
@NoArgsConstructor(force = true)
public class UserResponseEntity {
    @NotNull
    @JsonProperty("userId")
    private final UUID userId;
    @NotNull
    @JsonProperty("email")
    private final String email;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("dob")
    private ZonedDateTime dob;
    @JsonProperty("avatarUrl")
    private String avatarUrl;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("address")
    private String address;
}
