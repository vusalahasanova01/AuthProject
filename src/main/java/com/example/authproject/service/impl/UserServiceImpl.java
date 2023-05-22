package com.example.authproject.service.impl;

import com.example.authproject.dto.request.LoginRequest;
import com.example.authproject.dto.response.AuthenticationResponse;
import com.example.authproject.entity.User;
import com.example.authproject.repository.UserRepository;
import com.example.authproject.security.JwtProvider;
import com.example.authproject.service.UserService;
import com.example.demo._2a.tables.records.UsersRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = buildUser(userRepository.findByEmail(request.getEmail()));
        String jwtToken = jwtProvider.generateToken(user);
        return AuthenticationResponse.of(jwtToken);
    }

    private User buildUser(UsersRecord usersRecord){
        return User.builder()
                .email(usersRecord.getEmail())
                .password(usersRecord.getPassword())
                .build();
    }
}
