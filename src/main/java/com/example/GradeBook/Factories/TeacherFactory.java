package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.TeacherDto;
import com.example.GradeBook.store.entities.TeacherEntity;
import com.example.GradeBook.store.repositories.TeacherRepository;
import com.example.GradeBook.store.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class TeacherFactory {
    private UserFactory userFactory;
    private SubjectTypeFactory subjectTypeFactory;
    private ClassFactory classFactory;
    private TeacherRepository teacherRepository;
    public TeacherDto makeTeacherDto(TeacherEntity teacherEntity) {
        return TeacherDto.builder()
                .id(teacherEntity.getId())
                .user(userFactory.makeUserDto(teacherEntity.getUserId()))
                .subjectType(subjectTypeFactory.makeSubjectTypeDto(teacherEntity.getSubjectType()))
                .classes(teacherEntity.getClasses().stream().map(classFactory::makeClassDto).toList())
                .build();
    }
    public TeacherEntity makeTeacherEntity(TeacherDto teacherDto) {
        return TeacherEntity.builder()
                .id(teacherDto.getId())
                .userId(userFactory.makeUserEntity(teacherDto.getUser()))
                .subjectType(subjectTypeFactory.makeSubjectTypeEntity(teacherDto.getSubjectType()))
                .classes(teacherDto.getClasses().stream().map(classFactory::makeClassEntity).toList())
                .build();
    }
}
