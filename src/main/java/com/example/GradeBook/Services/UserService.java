package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.UserDto;
import com.example.GradeBook.Factories.UserFactory;
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
    public UserDto getUser(Long userId) {
        return userFactory
                .makeUserDto(userRepository.findById(userId).orElseThrow());
    }


    public UserDto addUpdateUser(UserDto userDto) {
        UserEntity userEntity = userRepository.saveAndFlush(userFactory.makeUserEntity(userDto));
        return userFactory.makeUserDto(userEntity);
    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


    public UserDto changePassword(Long userId, String password) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        if (userEntity.getPassword().equals(password)) {
            // todo: исключение
        }
        userEntity.setPassword(password);
        UserEntity user = userRepository.save(userEntity);
        return userFactory.makeUserDto(user);
    }
    public UserDto changeEmail(Long userId, String email) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        if (userEntity.getEmail().equals(email)) {
            // todo: исключение
        }
        userEntity.setEmail(email);
        UserEntity user = userRepository.save(userEntity);
        return userFactory.makeUserDto(user);
    }
}
