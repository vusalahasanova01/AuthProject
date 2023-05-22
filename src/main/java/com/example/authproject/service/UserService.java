package com.example.authproject.service;


import com.example.authproject.dto.request.LoginRequest;
import com.example.authproject.dto.response.AuthenticationResponse;

public interface UserService {

    AuthenticationResponse login(LoginRequest request);

}
