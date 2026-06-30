package com.mahesh.sms.controller;

import com.mahesh.sms.dto.request.RegisterRequest;
import com.mahesh.sms.dto.response.ApiResponse;
import com.mahesh.sms.dto.response.UserResponse;
import com.mahesh.sms.service.AuthService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<UserResponse> register(

            @Valid

            @RequestBody

            RegisterRequest request) {

        UserResponse response =
                authService.register(request);

        return ApiResponse.<UserResponse>builder()

                .success(true)

                .message("User registered successfully")

                .data(response)

                .timestamp(
                        java.time.LocalDateTime.now().toString())

                .build();
    }

}