package com.backend.programming.learning.system.auth.service.domain.implement.service.moodle;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_moodle.Role;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_moodle.UserModel;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.mapper.MoodleDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserRoleApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.RoleRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * com.backend.programming.learning.system.auth.service.domain.implement.service.moodle
 * Create by Dang Ngoc Tien
 * Date 5/2/2024 - 11:50 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MoodleCommandHandler {
    private final MoodleDataMapper moodleDataMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserApplicationService userApplicationService;
    private final UserRoleApplicationService userRoleApplicationService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RestTemplate restTemplate = new RestTemplate();
    String GET_ENROLLED_USERS = "core_enrol_get_enrolled_users";
    String MOODLE_URL = "http://62.171.185.208/webservice/rest/server.php";
    String MOODLE_URL_TOKEN = "http://62.171.185.208/login/token.php";
    String TOKEN = "cdf90b5bf53bcae577c60419702dbee7";

    @Transactional
    public String syncUser() {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&courseid=1",
                MOODLE_URL, TOKEN, GET_ENROLLED_USERS);
        String model = restTemplate.getForObject(apiURL, String.class);
        List<UserModel> listUserModel = null;
        try {
            listUserModel = List.of(objectMapper.readValue(model, UserModel[].class));
            log.info("User model: {}", listUserModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

//        List<com.backend.programming.learning.system.auth.service.domain.entity.Role> roles = roleRepository
//                .findAllRolesByOrganizationId(new OrganizationId(UUID.fromString("3ead3b08-afdd-442f-b544-fdbd86eaa186")), 0, 9999)
//                .getContent();
//
//        Map<String, com.backend.programming.learning.system.auth.service.domain.entity.Role> roleMap = roles.stream()
//                .collect(Collectors.toMap(role -> role.getName().toLowerCase(), role -> role));

        listUserModel.forEach(userModel -> {
            Optional<User> userResult = userRepository.findByEmail(userModel.getEmail());
            if (userResult.isPresent()) {
                UpdateUserCommand userUpdate = moodleDataMapper.updateUser(userModel, userResult.get());
                UpdateUserResponse updateUserResponse = userApplicationService.updateUser(userUpdate, "");
//                List<Role> rolesMoodle = userModel.getRoles();
//                rolesMoodle.forEach(role -> {
//                    CreateUserRoleCommand createRole = moodleDataMapper.createRole(role, roleMap, updateUserResponse.getUserId());
//                    userRoleApplicationService.createUserRole(createRole);
//                });
            } else {
                CreateUserCommand user = moodleDataMapper.createUser(userModel);
                CreateUserResponse createUserResponse = userApplicationService.createUser(user, "");
//                List<Role> rolesMoodle = userModel.getRoles();
//                rolesMoodle.forEach(role -> {
//                    CreateUserRoleCommand createRole = moodleDataMapper.createRole(role, roleMap, createUserResponse.getUserId());
//                    userRoleApplicationService.createUserRole(createRole);
//                });
            }
        });
        log.info("Sync user successfully");
        return "Sync user successfully";
    }

    public String getToken(String username, String password) {
        String apiURL = String.format("%s?username=%s&password=%s&service=wh", MOODLE_URL_TOKEN, username, password);
        return restTemplate.getForObject(apiURL, String.class);
    }
}
