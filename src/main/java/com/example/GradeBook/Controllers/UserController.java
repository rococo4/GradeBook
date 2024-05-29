package com.example.GradeBook.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    public final String CRUD_USER = "api/users/{userId}";
    public final String CHANGE_PASSWORD = "api/users/{userId}/password";
    public final String CHANGE_EMAIL = "api/users/{userId}/email";

    @GetMapping(CRUD_USER)

}
