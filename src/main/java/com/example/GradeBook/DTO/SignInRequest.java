package com.example.GradeBook.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInRequest {
    private String username;
    private String password;
}