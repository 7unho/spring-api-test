package com.april2nd.emailcertapi.repo;

import com.april2nd.emailcertapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findOneById(String id);
}