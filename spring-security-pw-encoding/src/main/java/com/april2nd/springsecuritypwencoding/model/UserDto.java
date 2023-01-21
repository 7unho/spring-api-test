package com.april2nd.springsecuritypwencoding.model;

import com.april2nd.springsecuritypwencoding.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String id;

    private String password;

    private String email;

    private String token;

    public User toEntity() {
        return User.builder().id(id).password(password).email(email).token(token).build();
    }
}