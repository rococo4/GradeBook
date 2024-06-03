package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.StudentDto;
import com.example.GradeBook.Exceptions.NotFoundException;
import com.example.GradeBook.Response.StudentResponse;
import com.example.GradeBook.store.entities.StudentEntity;
import com.example.GradeBook.store.repositories.StudentRepository;
import com.example.GradeBook.store.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StudentFactory {
    private final UserFactory userFactory;
    private final UserRepository userRepository;

    public StudentResponse makeStudentResponse(StudentEntity student) {
        return StudentResponse.builder()
                .studentId(student.getId())
                .userId(userFactory.makeUserResponse(student.getUser()))
                .build();
    }
    public StudentEntity makeStudentEntity(StudentDto studentDto) {
        return StudentEntity.builder()
                // todo: проверить если не будет id
                .id(studentDto.getStudentId())
                // todo: бросить исключение если не правильный UserId
                .user(userRepository.
                        findById(studentDto.getUserId()).orElseThrow(() ->
                                new NotFoundException(
                                        String.format("User with id %s not found", studentDto.getUserId()))))
                .build();
    }
}
