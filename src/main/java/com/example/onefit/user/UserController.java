package com.example.onefit.user;

import com.example.onefit.common.response.CommonResponse;
import com.example.onefit.security.JwtService;
import com.example.onefit.user.dto.*;
import com.example.onefit.user.otp.OtpService;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final OtpService otpService;
    private final JwtService jwtService;

    @PostMapping("/auth/validate")
    public ResponseEntity<CommonResponse> validatePhoneNumber(
            @RequestBody @Valid ValidatePhoneNumberRequestDto validatePhoneNumberRequestDto) {
        CommonResponse commonResponse = otpService.sendSms(validatePhoneNumberRequestDto);
        return ResponseEntity.ok(commonResponse);
    }

    @PostMapping("/auth/sign-up")
    public ResponseEntity<UserResponseDto> signUp(
            @RequestBody @Valid UserCreateDto userCreateDto) {
        UserResponseDto userResponseDto = userService.create(userCreateDto);
        String token = jwtService.generateToken(userResponseDto.getPhoneNumber());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .body(userResponseDto);
    }

    @PostMapping("/auth/sign-in")
    public ResponseEntity<UserResponseDto> signIn(
            @RequestBody @Valid UserSignInDto userSignInDto) {
        UserResponseDto userResponseDto = userService.signIn(userSignInDto);
        String token = jwtService.generateToken(userResponseDto.getPhoneNumber());
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .body(userResponseDto);
    }


}
