package com.example.GradeBook.Controllers;

import com.example.GradeBook.DTO.JwtResponse;
import com.example.GradeBook.DTO.SignInRequest;
import com.example.GradeBook.DTO.UserDto;
import com.example.GradeBook.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SignInUpController {
    public static final String SIGN_UP_IN = "/api/auth";

    private final AuthService authService;
    @PutMapping(SIGN_UP_IN)
    public JwtResponse signUp(@RequestBody UserDto userRequest) {
        return authService.signUp(userRequest);
    }

    @PostMapping(SIGN_UP_IN)
    public JwtResponse signIn(@RequestBody SignInRequest signInRequest) {
        return authService.signIn(signInRequest);
    }
}
