package com.april2nd.jwtlogintest.repo;

import com.april2nd.jwtlogintest.entity.Auth;
import com.april2nd.jwtlogintest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findByUserId(Long userId);
    Optional<Auth> findById(Long authId);

}