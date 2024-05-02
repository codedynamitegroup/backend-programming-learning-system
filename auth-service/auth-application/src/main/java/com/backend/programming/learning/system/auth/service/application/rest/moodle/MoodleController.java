package com.backend.programming.learning.system.auth.service.application.rest.moodle;

import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.MoodleApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.moodle
 * Create by Dang Ngoc Tien
 * Date 5/2/2024 - 12:27 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth/moodle/user", produces = "application/vnd.api.v1+json")
public class MoodleController {
    private final MoodleApplicationService moodleApplicationService;

    @PostMapping
    public ResponseEntity< List<UserEntityResponse>> syncUser() {
        List<UserEntityResponse> user = moodleApplicationService.syncUser();
        return ResponseEntity.ok(user);
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

}
