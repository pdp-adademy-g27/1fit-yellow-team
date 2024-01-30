package com.example.onefit.user.otp;

import com.example.onefit.common.exceptions.OtpException;
import com.example.onefit.common.notification.sms.SmsNotificationService;
import com.example.onefit.common.response.CommonResponse;
import com.example.onefit.user.dto.ValidateEmailDto;
import com.example.onefit.user.dto.ValidatePhoneNumberRequestDto;
import com.example.onefit.user.otp.entity.Otp;
import jakarta.persistence.EntityNotFoundException;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class OtpService {
    private final OtpRepository otpRepository;
    private final Random random = new Random();
    private final String VERIFICATION_MASSAGE = "Your verification code is: %d%n";
    @Value("${one-fit.otp.retry-wait-time}")
    private int retryWaitTime;
    @Value("${one-fit.otp.retry-count}")
    private int retryCount;
    @Value("${one-fit.otp.time-to-live}")
    private int timeToLive;
    private final SmsNotificationService smsNotificationService;

    @Transactional
    public CommonResponse sendSms(ValidatePhoneNumberRequestDto validatePhoneNumberRequestDto) {
        String phoneNumber = validatePhoneNumberRequestDto.getPhoneNumber();
        Optional<Otp> existingOtp = otpRepository.findById(phoneNumber);
        if (validatePhoneNumberRequestDto.getOtp() == null) {
            if (existingOtp.isPresent()) {
                return reTry(existingOtp.get());
            }
            Otp otp = sendSmsInternal(phoneNumber);
            otpRepository.save(otp);
            return new CommonResponse("Sms was sent successfully", LocalDateTime.now(), HttpStatus.OK.value());
        }
        Otp otp = existingOtp.orElseThrow(() -> new EntityNotFoundException("We didn't send you any verification code"));
        if (otp.getCode() == validatePhoneNumberRequestDto.getOtp()) {
            otp.setVerified(true);
            otpRepository.save(otp);
            return new CommonResponse("Otp was successfully verified", LocalDateTime.now(), HttpStatus.OK.value());
        } else {
            return new CommonResponse("Otp was incorrect", LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
        }
    }

    public CommonResponse reTry(Otp otp) {
        if (otp.getLastSentTime().plusSeconds(retryWaitTime).isAfter(LocalDateTime.now())) {
            long resentTime = Duration.between(otp.getLastSentTime(), LocalDateTime.now()).getSeconds();
            throw new OtpException.OtpEarlyResentException(retryWaitTime - resentTime);
        }

        if (otp.getSentCount() >= retryCount) {
            throw new OtpException.OtpLimitExitedException(otp.getSentCount(), otp.getCreated().plusSeconds(timeToLive));
        }

        Otp otp1 = sendSmsInternal(otp);
        otpRepository.save(otp1);
        return new CommonResponse("Sms was re-send successfully", LocalDateTime.now(), HttpStatus.OK.value());
    }

    private Otp sendSmsInternal(String phoneNumber) {
        int code = random.nextInt(100000, 999999);
        smsNotificationService.sendNotification(phoneNumber, VERIFICATION_MASSAGE.formatted(code));
        return new Otp(phoneNumber, code, 1, LocalDateTime.now(), LocalDateTime.now(), false);
    }

    private Otp sendSmsInternal(Otp otp) {
        int code = random.nextInt(100000, 999999);
        smsNotificationService.sendNotification(otp.getPhoneNumber(), VERIFICATION_MASSAGE.formatted(code));
        otp.setCode(code);
        otp.setLastSentTime(LocalDateTime.now());
        otp.setSentCount(otp.getSentCount() + 1);
        return otp;
    }

}
