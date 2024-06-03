package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.UserDto;
import com.example.GradeBook.Exceptions.BadRequestException;
import com.example.GradeBook.Exceptions.NotFoundException;
import com.example.GradeBook.Factories.UserFactory;
import com.example.GradeBook.Response.UserResponse;
import com.example.GradeBook.store.entities.UserEntity;
import com.example.GradeBook.store.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
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


    public UserResponse addUpdateUser(UserDto userDto) {
        UserEntity userEntity = userRepository.saveAndFlush(userFactory.makeUserEntity(userDto));
        return userFactory.makeUserResponse(userEntity);
    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


    public UserResponse changePassword(Long userId, String password) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        if (userEntity.getPassword().equals(password)) {
            throw new BadRequestException("Passwords must differ");
        }
        userEntity.setPassword(password);
        UserEntity user = userRepository.save(userEntity);
        return userFactory.makeUserResponse(user);
    }
    public UserResponse changeEmail(Long userId, String email) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        if (userEntity.getEmail().equals(email)) {
            throw new BadRequestException("Email must differ");
        }
        userEntity.setEmail(email);
        UserEntity user = userRepository.save(userEntity);
        return userFactory.makeUserResponse(user);
    }
}
