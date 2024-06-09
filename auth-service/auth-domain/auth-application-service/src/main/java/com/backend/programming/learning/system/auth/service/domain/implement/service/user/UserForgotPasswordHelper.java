package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.dto.method.email.MailBody;
import com.backend.programming.learning.system.auth.service.domain.dto.method.forgot_password.*;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.EmailService;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserKeycloakApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Component
public class UserForgotPasswordHelper {
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final UserKeycloakApplicationService userKeycloakApplicationService;

    public UserForgotPasswordHelper(UserRepository userRepository, EmailService emailService, UserKeycloakApplicationService userKeycloakApplicationService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.userKeycloakApplicationService = userKeycloakApplicationService;
    }

    @Transactional
    public ForgotPasswordEmailResponse forgotPasswordUser(ForgotPasswordEmailCommand forgotPasswordEmailCommand) throws MessagingException {
        User user = findUserByEmail(forgotPasswordEmailCommand.getEmail());
        int otp = otpGenerator();
        String emailBody = String.format(
                """
                <p>Chào %s,</p>
                <p>Chúng tôi đã nhận được yêu cầu đặt lại mật khẩu của bạn từ ứng dụng Code Dynamite.
                    Sau đây là mã OTP để cài đặt lại mật khẩu của bạn:</p>
                <h2>%d</h2>
                <p>Vui lòng truy cập đường dẫn sau:</p>
                <p><a href="%s">Đặt lại mật khẩu</a></p>
                <p>Mã này sẽ hết hạn sau %d phút.</p>
                <p>Nếu bạn không yêu cầu đặt lại mật khẩu, vui lòng bỏ qua email này.</p>
                """,
                user.getLastName() + " " + user.getFirstName(), otp,
                forgotPasswordEmailCommand.getRedirectUrl(), 15
                );
        MailBody mailBody = MailBody.builder()
                .to(user.getEmail())
                .body(emailBody)
                .subject("OTP for Forgot Password request")
                .build();

        user.setOtp(otp);
        user.setOtpExpireAt(ZonedDateTime.now().plusMinutes(15));

        emailService.sendHtmlEmail(mailBody);
        saveUser(user);

        return ForgotPasswordEmailResponse.builder()
                .email(user.getEmail())
                .message("Email is sent successfully!")
                .build();
    }

    @Transactional
    public VerifyOTPResponse verifyOTP(VerifyOTPCommand verifyOTPCommand) {
        User user = findUserByEmail(verifyOTPCommand.getEmail());
        if (!user.getOtp().equals(verifyOTPCommand.getOtp())) {
            log.error("OTP is not correct!");
            throw new AuthDomainException("OTP is not correct!");
        }

        if (user.getOtpExpireAt().isBefore(Instant.now().atZone(ZoneId.systemDefault()))) {
            user.setOtp(null);
            user.setOtpExpireAt(null);
            log.error("OTP has expired!");
            saveUser(user);
            throw new AuthDomainException("OTP has expired!");
        }

        return VerifyOTPResponse.builder()
                .message("OTP is verified successfully!")
                .build();
    }

    @Transactional
    public ResetPasswordResponse changedPasswordUser(ResetPasswordCommand resetPasswordCommand) {
        User user = findUserByEmail(resetPasswordCommand.getEmail());

        if (!user.getOtp().equals(resetPasswordCommand.getOtp())) {
            log.error("OTP is not correct!");
            throw new AuthDomainException("OTP is not correct!");
        }

        if (user.getOtpExpireAt().isBefore(Instant.now().atZone(ZoneId.systemDefault()))) {
            user.setOtp(null);
            user.setOtpExpireAt(null);
            log.error("OTP has expired!");
            saveUser(user);
            throw new AuthDomainException("OTP has expired!");
        }

        userKeycloakApplicationService.updatePassword(user.getEmail(), resetPasswordCommand.getNewPassword());

        return ResetPasswordResponse.builder()
                .email(user.getEmail())
                .message("Password is changed successfully!")
                .build();
    }

    private Integer otpGenerator() {
        Random random = new Random();
        return random.nextInt(100_000, 999_999);
    }

    private User findUserByEmail(String email) {
        Optional<User> userResult =
                userRepository.findByEmail(email);
        if (userResult.isEmpty()) {
            log.warn("Could not find user with email: {}", email);
            throw new AuthNotFoundException("Could not find user with email: " +
                    email);
        }
        return userResult.get();
    }

    private void saveUser(User user) {
        User userResult = userRepository.save(user);
        if (userResult == null) {
            log.error("Could not update user!");
            throw new AuthDomainException("Could not update user!");
        }
        log.info("User is updated with id: {}", userResult.getId().getValue());
    }
}
