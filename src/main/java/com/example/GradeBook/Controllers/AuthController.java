package com.example.GradeBook.Controllers;

import com.example.GradeBook.DTO.JwtRequest;
import com.example.GradeBook.Services.UserService;
import com.example.GradeBook.Utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    @PostMapping()
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {

    }

}
