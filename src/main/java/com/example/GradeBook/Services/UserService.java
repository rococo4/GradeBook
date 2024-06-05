package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.UserDto;
import com.example.GradeBook.Exceptions.BadRequestException;
import com.example.GradeBook.Exceptions.NotFoundException;
import com.example.GradeBook.Factories.UserFactory;
import com.example.GradeBook.Response.UserResponse;
import com.example.GradeBook.store.entities.RoleEntitiy;
import com.example.GradeBook.store.entities.UserEntity;
import com.example.GradeBook.store.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserFactory userFactory;


    //todo: исключение
    public UserResponse getUser(Long userId) {
        return userFactory
                .makeUserResponse(userRepository.findById(userId).orElseThrow(() -> new NotFoundException(
                        String.format("User with id %s not found", userId))));
    }


    public UserResponse addUser(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new BadRequestException("Username already exists");
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        UserEntity userEntity = userRepository.saveAndFlush(userFactory.makeUserEntity(userDto));
        return userFactory.makeUserResponse(userEntity);
    }
    public UserResponse updateUser(UserDto userDto) {
        if (!userRepository.existsById(userDto.getUserId())) {
            throw new NotFoundException(String.format("User with id %s not found", userDto.getUserId()));
        }
        UserEntity userEntity = userRepository.saveAndFlush(userFactory.makeUserEntity(userDto));
        return userFactory.makeUserResponse(userEntity);
    }



    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public UserResponse changeEmail(Long userId, String email) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        if (userEntity.getEmail().equals(email)) {
            throw new BadRequestException("Email must differ");
        }
        if (userRepository.existsByEmail(email)) {
            throw new BadRequestException("Email already exists");
        }
        userEntity.setEmail(email);
        UserEntity user = userRepository.save(userEntity);
        return userFactory.makeUserResponse(user);
    }


    public UserEntity getUserByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new NotFoundException(String.format("User with name %s not found", username)));
    }

    public UserDetailsService userDetailsService() {
        return this::getUserByUsername;
    }

    @Deprecated
    public void getAdmin() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = getUserByUsername(username);
        user.setRole(
                RoleEntitiy.builder()
                .roleId(2L)
                .roleName("ADMIN").build());

    }


}
