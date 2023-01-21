package com.april2nd.jwtlogintest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenIndexRes {
    private String ACCESS_TOKEN;
    private Long REFRESH_TOKEN_INDEX;
}