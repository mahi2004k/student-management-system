package com.mahesh.sms.service;

import com.mahesh.sms.dto.request.LoginRequest;
import com.mahesh.sms.dto.request.RegisterRequest;
import com.mahesh.sms.dto.response.LoginResponse;
import com.mahesh.sms.dto.response.UserResponse;

public interface AuthService {

    UserResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}