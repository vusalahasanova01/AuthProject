package com.example.authproject.controller;

import com.example.authproject.dto.request.LoginRequest;
import com.example.authproject.dto.response.AuthenticationResponse;
import com.example.authproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @GetMapping("test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello from secured endpoint");
    }

}
