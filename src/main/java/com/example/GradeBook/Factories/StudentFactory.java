package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.StudentDto;
import com.example.GradeBook.store.entities.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentFactory {
    private UserFactory userFactory;

    public StudentDto makeStudentDto(StudentEntity student) {
        return StudentDto.builder()
                .id(student.getId())
                .userId(userFactory.makeUserDto(student.getUser()))
                .build();
    }
    public StudentEntity makeStudentEntity(StudentDto studentDto) {
        return StudentEntity.builder()
                .id(studentDto.getId())
                .user(userFactory.makeUserEntity(studentDto.getUserId()))
                .build();
    }
}
