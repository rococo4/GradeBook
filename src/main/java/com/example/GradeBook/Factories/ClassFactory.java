package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.ClassDto;
import com.example.GradeBook.Response.ClassResponse;
import com.example.GradeBook.store.entities.ClassEntity;
import com.example.GradeBook.store.entities.StudentEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClassFactory {
    private final StudentFactory studentFactory;

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
        return ClassEntity.builder().classId(classDto.getClassId()).className(classDto.getClassName()).build();
    }
}
