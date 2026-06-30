package com.mahesh.sms.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

    private String token;

    private String tokenType;

    private Long expiresIn;

    private UserResponse user;

}