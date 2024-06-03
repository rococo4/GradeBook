package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.ClassDto;
import com.example.GradeBook.Exceptions.NotFoundException;
import com.example.GradeBook.Response.ClassResponse;
import com.example.GradeBook.store.entities.ClassEntity;
import com.example.GradeBook.store.entities.StudentEntity;
import com.example.GradeBook.store.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.file.NotDirectoryException;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ClassFactory {
    private final StudentFactory studentFactory;
    private final StudentRepository studentRepository;
    public ClassResponse makeClassResponse(ClassEntity classEntity) {
        return ClassResponse.builder()
                .classId(classEntity.getClassId())
                .className(classEntity.getClassName())
                .students(
                        classEntity.getStudents().stream()
                                .map(studentFactory::makeStudentResponse).toList())
                .build();
    }

    public ClassEntity makeClassEntity(ClassDto classDto) {
        return ClassEntity.builder()
                .classId(classDto.getClassId())
                .className(classDto.getClassName())
                .students(classDto.getStudentsId().stream()
                        .map((student) -> studentRepository.findById(student)
                                .orElseThrow(() -> new NotFoundException(
                                        String.format("Student with id %s not found",student))))
                        .toList())
                .build();
    }
}
