package com.mahesh.sms.service.impl;

import com.mahesh.sms.dto.request.LoginRequest;
import com.mahesh.sms.dto.request.RegisterRequest;
import com.mahesh.sms.dto.response.LoginResponse;
import com.mahesh.sms.dto.response.UserResponse;
import com.mahesh.sms.entity.Role;
import com.mahesh.sms.entity.User;
import com.mahesh.sms.exception.DuplicateResourceException;
import com.mahesh.sms.exception.ResourceNotFoundException;
import com.mahesh.sms.repository.RoleRepository;
import com.mahesh.sms.repository.UserRepository;
import com.mahesh.sms.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceImpl
        implements AuthService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(

            UserRepository userRepository,

            RoleRepository roleRepository,

            PasswordEncoder passwordEncoder){

        this.userRepository=userRepository;

        this.roleRepository=roleRepository;

        this.passwordEncoder=passwordEncoder;

    }

    @Override
    @Transactional
    public UserResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {

            throw new DuplicateResourceException(
                    "Email already exists");
        }

        Role studentRole = roleRepository.findByName("ROLE_STUDENT")
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Default role not found"));

        User user = User.builder()

                .firstName(request.getFirstName())

                .lastName(request.getLastName())

                .email(request.getEmail())

                .phone(request.getPhone())

                .password(
                        passwordEncoder.encode(
                                request.getPassword()))

                .build();

        user.getRoles().add(studentRole);

        User savedUser = userRepository.save(user);

        return UserResponse.builder()

                .id(savedUser.getId())

                .firstName(savedUser.getFirstName())

                .lastName(savedUser.getLastName())

                .email(savedUser.getEmail())

                .phone(savedUser.getPhone())

                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request){

        return null;

    }

}