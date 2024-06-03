package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.UserDto;
import com.example.GradeBook.Exceptions.NotFoundException;
import com.example.GradeBook.Response.UserResponse;
import com.example.GradeBook.store.entities.UserEntity;
import com.example.GradeBook.store.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFactory {
    private final RoleFactory roleFactory;
    private final RoleRepository roleRepository;

    public UserResponse makeUserResponse(UserEntity user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .userId(user.getId())
                .email(user.getEmail())
                .role(roleFactory.makeRoleResponse(user.getRole()))
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();
    }

    public UserEntity makeUserEntity(UserDto user) {
        return UserEntity.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .id(user.getUserId())
                .email(user.getEmail())
                //todo: эксэпшн если не правильно id передали
                .role(roleRepository
                        .findById(user.getRole()).orElseThrow(() ->
                                new NotFoundException(String.format("Role with such id %s not found", user.getRole()))))
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();
    }
}
