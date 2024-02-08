package com.example.onefit.user;

import com.example.onefit.common.exceptions.OtpException;
import com.example.onefit.common.service.GenericService;
import com.example.onefit.user.dto.UserCreateDto;
import com.example.onefit.user.dto.UserResponseDto;
import com.example.onefit.user.dto.UserSignInDto;
import com.example.onefit.user.dto.UserUpdateDto;
import com.example.onefit.user.entity.User;
import com.example.onefit.user.otp.OtpRepository;
import com.example.onefit.user.otp.entity.Otp;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class UserService extends GenericService<User, UUID, UserResponseDto, UserCreateDto, UserUpdateDto> implements UserDetailsService {
    private final UserRepository repository;
    private final Class<User> entityClass = User.class;
    private final UserDtoMapper mapper;
    private final OtpRepository otpRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected UserResponseDto internalCreate(UserCreateDto userCreateDto) {
        User entity = mapper.toEntity(userCreateDto);
        entity.setId(UUID.randomUUID());
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        isPhoneNumberVerified(userCreateDto.getPhoneNumber());
        User saved = repository.save(entity);
        return mapper.toResponseDto(saved);
    }

    private void isPhoneNumberVerified(String phoneNumber) {
        System.out.println("Otp start");
        System.out.println(phoneNumber);

        Otp otp = otpRepository
                .findById(phoneNumber)
                .orElseThrow(() -> new OtpException.PhoneNumberNotVerified(phoneNumber));

        System.out.println("1234312343123");
        if (!otp.isVerified()) {
            throw new OtpException.PhoneNumberNotVerified(phoneNumber);
        }
        System.out.println("Otp end");
    }

    @Transactional
    public UserResponseDto signIn(UserSignInDto userSignInDto) {
        User user = repository
                .findByPhoneNumber(userSignInDto.getPhoneNumber())
                .orElseThrow(() -> new BadCredentialsException("Username or password is not correct"));
        if (!passwordEncoder.matches(userSignInDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Username or password is not correct");
        }

        return mapper.toResponseDto(user);
    }

    @Override
    protected UserResponseDto internalUpdate(UUID uuid, UserUpdateDto userUpdateDto) {
        User user = repository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("User with id: %s not found".formatted(uuid)));
        mapper.toEntity(userUpdateDto, user);

        User savedUser = repository.save(user);
        return mapper.toResponseDto(savedUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
                .findByPhoneNumber(username)
                .orElseThrow(() -> new EntityNotFoundException("User with phone number: %s not found".formatted(username)));
    }

}
