package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.JwtResponse;
import com.example.GradeBook.DTO.SignInRequest;
import com.example.GradeBook.DTO.UserDto;
import com.example.GradeBook.Exceptions.BadRequestException;
import com.example.GradeBook.Factories.RoleFactory;
import com.example.GradeBook.Factories.UserFactory;
import com.example.GradeBook.Response.UserResponse;
import com.example.GradeBook.store.entities.UserEntity;
import com.example.GradeBook.store.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleFactory roleFactory;
    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public JwtResponse signUp(UserDto userDto) {

        var user = UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(roleFactory.makeRoleEntity(userDto.getRole()))
                .build();


        var jwt = jwtService.generateToken(userRepository.saveAndFlush(user));
        return JwtResponse.builder().token(jwt).build();
    }

    public JwtResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = userService.getUserByUsername(request.getUsername());

        var jwt = jwtService.generateToken(user);
        return JwtResponse.builder().token(jwt).build();
    }
    public UserResponse changePassword(Long userId, String password) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        if (passwordEncoder.matches(password, userEntity.getPassword())) {
            throw new BadRequestException("Passwords must differ");
        }
        userEntity.setPassword(passwordEncoder.encode(password));
        UserEntity user = userRepository.save(userEntity);
        return userFactory.makeUserResponse(user);
    }
}
