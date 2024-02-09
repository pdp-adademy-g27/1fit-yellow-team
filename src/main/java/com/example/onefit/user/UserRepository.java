package com.example.onefit.user;

import com.example.onefit.common.repository.GenericRepository;
import com.example.onefit.user.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository  extends GenericRepository<User, UUID> {
    Optional<User> findByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumberOrEmail(String phoneNumber, String email);

    Optional<User> findUserById(UUID id);


}
