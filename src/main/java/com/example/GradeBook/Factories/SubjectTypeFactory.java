package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.SubjectTypeDto;
import com.example.GradeBook.store.entities.SubjectTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class SubjectTypeFactory {
    public SubjectTypeDto makeSubjectTypeDto(SubjectTypeEntity subjectTypeEntity) {
       return SubjectTypeDto.builder()
                .subjectTypeId(subjectTypeEntity.getSubjectTypeId())
                .subjectTypeName(subjectTypeEntity.getSubjectTypeName())
                .build();
    }
    public SubjectTypeEntity makeSubjectTypeEntity(SubjectTypeDto subjectTypeDto) {
        return SubjectTypeEntity.builder()
                .subjectTypeId(subjectTypeDto.getSubjectTypeId())
                .subjectTypeName(subjectTypeDto.getSubjectTypeName())
                .build();
    }
}
