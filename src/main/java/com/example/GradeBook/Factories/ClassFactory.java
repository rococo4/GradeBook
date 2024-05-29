package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.ClassDto;
import com.example.GradeBook.store.entities.ClassEntity;
import org.springframework.stereotype.Component;

@Component
public class ClassFactory {
    public ClassDto makeClassDto(ClassEntity classEntity) {
       return ClassDto.builder().classId(classEntity.getClassId()).className(classEntity.getClassName()).build();
    }
    public ClassEntity makeClassEntity(ClassDto classDto) {
        return ClassEntity.builder().classId(classDto.getClassId()).className(classDto.getClassName()).build();
    }
}
