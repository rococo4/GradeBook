package com.example.GradeBook.Factories;


import com.example.GradeBook.DTO.GradeDto;
import com.example.GradeBook.Exceptions.NotFoundException;
import com.example.GradeBook.Response.GradeResponse;
import com.example.GradeBook.store.entities.GradeEntity;
import com.example.GradeBook.store.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GradeFactory {
    private final StudentFactory studentFactory;
    private final SubjectTypeFactory subjectTypeFactory;

    private final StudentRepository studentRepository;

    public GradeResponse makeGradeResponse(GradeEntity gradeEntity) {
       return GradeResponse.builder()
                .gradeId(gradeEntity.getGradeId())
                .mark(gradeEntity.getMark())
                .student(studentFactory.makeStudentResponse(gradeEntity.getStudent()))
                .subjectType(subjectTypeFactory.makeSubjectTypeResponse(gradeEntity.getSubjectType()))
                .createdAt(gradeEntity.getCreatedAt())
                .build();
    }

    public GradeEntity makeGradeEntity(GradeDto gradeDto) {
        return GradeEntity.builder()
                .gradeId(gradeDto.getGradeId())
                .mark(gradeDto.getMark())
                .student(studentRepository.
                        findById(gradeDto.getStudentId())
                        .orElseThrow(() -> new NotFoundException(
                                String.format("Student with id %s not found", gradeDto.getStudentId()))))
                .subjectType(subjectTypeFactory.makeSubjectTypeEntity(gradeDto.getSubjectType()))
                .createdAt(gradeDto.getCreatedAt())
                .build();
    }

}
