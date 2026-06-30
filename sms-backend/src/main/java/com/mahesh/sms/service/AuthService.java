package com.mahesh.sms.service;

import com.mahesh.sms.dto.request.LoginRequest;
import com.mahesh.sms.dto.request.RegisterRequest;
import com.mahesh.sms.dto.response.LoginResponse;

public interface AuthService {

    void register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}