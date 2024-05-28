package com.example.GradeBook.Factories;
import com.example.GradeBook.DTO.UserDto;
import com.example.GradeBook.store.entities.UserEntity;
import org.springframework.stereotype.Component;
@Component
public class UserFactory {
    RoleFactory roleFactory;
    public UserDto makeUserDto(UserEntity user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(roleFactory.makeRoleDto(user.getRole()))
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();
    }
    public UserEntity makeUserEntity(UserDto user) {
        return UserEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(roleFactory.makeRoleEntity(user.getRole()))
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();
    }
}
