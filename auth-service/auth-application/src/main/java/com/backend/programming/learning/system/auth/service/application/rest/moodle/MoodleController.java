package com.backend.programming.learning.system.auth.service.application.rest.moodle;

import com.backend.programming.learning.system.auth.service.application.rest.moodle.models.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.moodle
 * Create by Dang Ngoc Tien
 * Date 5/2/2024 - 12:27 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth/user/moodle", produces = "application/vnd.api.v1+json")
public class MoodleController {
    String GET_USERS = "core_user_get_users";
    String MOODLE_URL = "http://62.171.185.208/webservice/rest/server.php";
    String MOODLE_URL_TOKEN = "http://62.171.185.208/login/token.php";
    String TOKEN = "cdf90b5bf53bcae577c60419702dbee7";

    @GetMapping
    public ResponseEntity<String> getCourse() {
        String criteria = "criteria[0][key]=auth&criteria[0][value]=manual";
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&%s",
                MOODLE_URL, TOKEN, GET_USERS, criteria);
        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);
//        String jsonResponse = responseEntity.getBody();
//        UserModel userModel = convertJsonToUserModel(jsonResponse);
        return restTemplate.getForEntity(apiURL, String.class);
    }

    @GetMapping("token")
    public ResponseEntity<String> getToken(
//            @RequestParam(value = "username", required = false) String username,
//            @RequestParam(value = "password", required = false) String password
    ) {
//        String apiURL = String.format("%s?username=%s&password=%s&service=wh", MOODLE_URL_TOKEN, username, password);
        String apiURL = String.format("http://62.171.185.208/login/token.php?service=wh&username=admin&password=123456789oO%23");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(apiURL, String.class);
    }

    private UserModel convertJsonToUserModel(String jsonResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserModel userModel = null;
        try {
            userModel = objectMapper.readValue(jsonResponse, UserModel.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return userModel;
    }
}
