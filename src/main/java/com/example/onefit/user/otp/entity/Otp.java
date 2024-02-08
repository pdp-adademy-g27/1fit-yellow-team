package com.example.onefit.user.otp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "otp", timeToLive = 60)
public class Otp {
    @Id
    private String phoneNumber;
    private int code;
    private int sentCount;
    private LocalDateTime created;
    private LocalDateTime lastSentTime;
    private boolean isVerified;

}
