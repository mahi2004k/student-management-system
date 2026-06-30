package com.mahesh.sms.service.impl;

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
    public void register(RegisterRequest request){

    }

    @Override
    public LoginResponse login(LoginRequest request){

        return null;

    }

}