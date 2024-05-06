package com.backend.programming.learning.system.auth.service.domain.implement.service.moodle;

import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_moodle.ListUserModel;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.mapper.MoodleDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    String GET_USERS = "core_user_get_users";
    String MOODLE_URL = "http://62.171.185.208/webservice/rest/server.php";
    String MOODLE_URL_TOKEN = "http://62.171.185.208/login/token.php";
    String TOKEN = "cdf90b5bf53bcae577c60419702dbee7";

    @Transactional
    public List<UserEntityResponse> syncUser() {
        String criteria = "criteria[0][key]=&criteria[0][value]=";
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&%s",
                MOODLE_URL, TOKEN, GET_USERS, criteria);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ListUserModel listUserModel = null;
        try {
            listUserModel = objectMapper.readValue(model, ListUserModel.class);
            log.info("User model: {}", listUserModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        List<User> result = new ArrayList<>();

        listUserModel.getUsers().forEach(userModel -> {
            Optional<User> userResult = userRepository.findByEmail(userModel.getEmail());
            if (userResult.isPresent()) {
                User userUpdate = moodleDataMapper.updateUser(userModel, userResult.get());
                User res = userRepository.save(userUpdate);
                result.add(res);
            } else {
                User user = moodleDataMapper.createUser(userModel);
                User res = userRepository.save(user);
                result.add(res);
            }
        });

        return moodleDataMapper.userEntityResponseList(result);
    }

    public String getToken(String username, String password) {
        String apiURL = String.format("%s?username=%s&password=%s&service=wh", MOODLE_URL_TOKEN, username, password);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiURL, String.class);
    }
}
