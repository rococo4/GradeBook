package com.example.GradeBook.Controllers;

import com.example.GradeBook.DTO.UserDto;
import com.example.GradeBook.Response.UserResponse;
import com.example.GradeBook.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    public final String CRUD_USER = "api/users/{userId}";
    public final String CHANGE_PASSWORD = "api/users/{userId}/password";
    public final String CHANGE_EMAIL = "api/users/{userId}/email";

    private final UserService userService;


    @GetMapping(CRUD_USER)
    public UserResponse getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping(CRUD_USER)
    public UserResponse addUpdateUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return userService.addUpdateUser(userDto);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    // todo Вернуть типо успешно или нет
    @PostMapping(CHANGE_PASSWORD)
    public UserResponse changePassword(
            @PathVariable Long userId,
            @RequestParam(name = "password", required = true) String password) {
       return userService.changePassword(userId, password);

    }
    @PostMapping(CHANGE_EMAIL)
    public UserResponse changeEmail(
            @PathVariable Long userId,
            @RequestParam(name = "email", required = true) String email) {
       return userService.changeEmail(userId, email);
    }
}
