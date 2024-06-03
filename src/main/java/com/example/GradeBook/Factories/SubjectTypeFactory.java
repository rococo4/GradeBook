package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.SubjectTypeDto;
import com.example.GradeBook.Response.SubjectTypeResponse;
import com.example.GradeBook.store.entities.SubjectTypeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectTypeFactory {
    public SubjectTypeResponse makeSubjectTypeResponse(SubjectTypeEntity subjectTypeEntity) {
       return SubjectTypeResponse.builder()
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
