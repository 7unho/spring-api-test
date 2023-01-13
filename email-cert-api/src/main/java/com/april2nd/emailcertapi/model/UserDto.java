package com.april2nd.emailcertapi.model;

import com.april2nd.emailcertapi.entity.User;
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

    public User toEntity() {
        return User.builder().id(id).password(password).email(email).build();
    }
}