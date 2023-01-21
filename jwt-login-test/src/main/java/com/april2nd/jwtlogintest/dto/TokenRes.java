package com.april2nd.jwtlogintest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenRes {
    private String ACCESS_TOKEN;
    private String REFRESH_TOKEN;
}