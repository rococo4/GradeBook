package com.example.GradeBook.Factories;


import com.example.GradeBook.DTO.GradeDto;
import com.example.GradeBook.Services.StudentService;
import com.example.GradeBook.store.entities.GradeEntity;

public class GradeFactory {
    private StudentFactory studentFactory;
    private SubjectTypeFactory subjectTypeFactory;

    public GradeDto makeGradeDto(GradeEntity gradeEntity) {
       return GradeDto.builder()
                .gradeId(gradeEntity.getGradeId())
                .mark(gradeEntity.getMark())
                .student(studentFactory.makeStudentDto(gradeEntity.getStudent()))
                .subjectType(subjectTypeFactory.makeSubjectTypeDto(gradeEntity.getSubjectType()))
                .createdAt(gradeEntity.getCreatedAt())
                .build();
    }

    public GradeEntity makeGradeEntity(GradeDto gradeDto) {
        return GradeEntity.builder()
                .gradeId(gradeDto.getGradeId())
                .mark(gradeDto.getMark())
                .student(studentFactory.makeStudentEntity(gradeDto.getStudent()))
                .subjectType(subjectTypeFactory.makeSubjectTypeEntity(gradeDto.getSubjectType()))
                .createdAt(gradeDto.getCreatedAt())
                .build();
    }

}
