package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.ClassDto;
import com.example.GradeBook.DTO.StudentDto;
import com.example.GradeBook.DTO.TeacherDto;
import com.example.GradeBook.Factories.ClassFactory;
import com.example.GradeBook.Factories.StudentFactory;
import com.example.GradeBook.Factories.TeacherFactory;
import com.example.GradeBook.store.entities.ClassEntity;
import com.example.GradeBook.store.entities.StudentEntity;
import com.example.GradeBook.store.entities.TeacherEntity;
import com.example.GradeBook.store.repositories.ClassRepository;
import com.example.GradeBook.store.repositories.StudentRepository;
import com.example.GradeBook.store.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final StudentRepository studentRepository;
    private final StudentFactory studentFactory;
    private final TeacherRepository teacherRepository;
    private final TeacherFactory teacherFactory;
    private final ClassRepository classRepository;
    private final ClassFactory classFactory;

    public StudentDto addUpdateStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentRepository
                .save(studentFactory.makeStudentEntity(studentDto));
        return studentFactory.makeStudentDto(studentEntity);
    }

    public StudentDto getStudentById(Long studentId) {
        return studentFactory
                .makeStudentDto(studentRepository.findById(studentId).orElseThrow());
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentFactory::makeStudentDto)
                .collect(Collectors.toList());
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }





    public TeacherDto addUpdateTeacher(TeacherDto teacherDto) {
        TeacherEntity teacherEntity = teacherRepository.saveAndFlush(teacherFactory.makeTeacherEntity(teacherDto));
        return teacherFactory.makeTeacherDto(teacherEntity);
    }

    public TeacherDto getTeacherById(Long teacherId) {
        return teacherFactory
                .makeTeacherDto(teacherRepository.findById(teacherId).orElseThrow());
    }

    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll().stream().map(teacherFactory::makeTeacherDto).collect(Collectors.toList());
    }

    public void deleteByTeacherId(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }



    public ClassDto createUpdateClass(ClassDto classDto) {
        ClassEntity classEntity = classRepository.saveAndFlush(classFactory.makeClassEntity(classDto));
        return classFactory.makeClassDto(classEntity);

    }

    public ClassDto getClass( Long classId) {
        return classFactory.
                makeClassDto(classRepository.findById(classId).orElseThrow());
    }

    public List<ClassDto> getAllClasses() {
        return classRepository.findAll().stream()
                .map(classFactory::makeClassDto)
                .toList();
    }


    public void deleteClass(Long classId) {
        classRepository.deleteById(classId);
    }



}
