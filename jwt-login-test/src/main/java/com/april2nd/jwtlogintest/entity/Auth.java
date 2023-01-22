package com.april2nd.jwtlogintest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "AUTH")
public class Auth {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String email;
    private String accessToken;
    private String refreshToken;

    public void accessUpdate(String accessToken) {
        this.accessToken = accessToken;
    }

    public void refreshUpdate(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}