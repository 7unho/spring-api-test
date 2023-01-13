package com.april2nd.springsecuritypwencoding.repo;

import com.april2nd.springsecuritypwencoding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findOneById(String id);
}