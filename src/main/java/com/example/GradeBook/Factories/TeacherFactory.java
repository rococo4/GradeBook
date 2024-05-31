package com.example.GradeBook.Factories;

import com.example.GradeBook.DTO.TeacherDto;
import com.example.GradeBook.Response.TeacherResponse;
import com.example.GradeBook.store.entities.TeacherEntity;
import com.example.GradeBook.store.repositories.ClassRepository;
import com.example.GradeBook.store.repositories.TeacherRepository;
import com.example.GradeBook.store.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TeacherFactory {
    private final UserFactory userFactory;
    private final SubjectTypeFactory subjectTypeFactory;
    private final ClassFactory classFactory;
    private final TeacherRepository teacherRepository;

    private final UserRepository userRepository;
    private final ClassRepository classRepository;

    public TeacherResponse makeTeacherResponse(TeacherEntity teacherEntity) {
        return TeacherResponse.builder()
                .teacherId(teacherEntity.getId())
                .user(userFactory.makeUserResponse(teacherEntity.getUserId()))
                .subjectType(subjectTypeFactory.makeSubjectTypeResponse(teacherEntity.getSubjectType()))
                .classes(teacherEntity.getClasses().stream().map(classFactory::makeClassResponse).toList())
                .build();
    }
    public TeacherEntity makeTeacherEntity(TeacherDto teacherDto) {
        return TeacherEntity.builder()
                .id(teacherDto.getTeacherId())
                .userId(userRepository.findById(teacherDto.getUserId()).orElseThrow())
                .subjectType(subjectTypeFactory.makeSubjectTypeEntity(teacherDto.getSubjectType()))
                //todo: исключение если неправильный id класса
                .classes(teacherDto.getClassesId().stream().map(classRepository::findById).map(Optional::orElseThrow).toList())
                .build();
    }
}
