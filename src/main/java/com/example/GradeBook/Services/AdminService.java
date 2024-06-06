package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.ClassDto;
import com.example.GradeBook.DTO.StudentDto;
import com.example.GradeBook.DTO.TeacherDto;
import com.example.GradeBook.Exceptions.NotFoundException;
import com.example.GradeBook.Factories.ClassFactory;
import com.example.GradeBook.Factories.StudentFactory;
import com.example.GradeBook.Factories.TeacherFactory;
import com.example.GradeBook.Response.ClassResponse;
import com.example.GradeBook.Response.StudentResponse;
import com.example.GradeBook.Response.TeacherResponse;
import com.example.GradeBook.store.entities.*;
import com.example.GradeBook.store.repositories.*;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public StudentResponse addUpdateStudent(StudentDto studentDto) {
        UserEntity user = userRepository
                .findById(studentDto.getUserId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("User with id %s not found", studentDto.getUserId())));
        user.setRole(roleRepository.findById(1L).orElseThrow());;
        userRepository.saveAndFlush(user);

        StudentEntity studentEntity = studentRepository
                .saveAndFlush(studentFactory.makeStudentEntity(studentDto));
        return studentFactory.makeStudentResponse(studentEntity);

    }

    public StudentResponse getStudentById(Long studentId) {
        return studentFactory
                .makeStudentResponse(studentRepository
                        .findById(studentId)
                        .orElseThrow(() -> new NotFoundException(
                                String.format("Student with id %s not found", studentId))));

    }

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentFactory::makeStudentResponse)
                .collect(Collectors.toList());
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.findById(studentId).orElseThrow(() -> new NotFoundException(
                        String.format("Student with id %s not found", studentId)));
        studentRepository.deleteById(studentId);
    }


    public TeacherResponse addUpdateTeacher(TeacherDto teacherDto) {
        UserEntity user = userRepository.findById(teacherDto.getUserId()).orElseThrow(() -> new NotFoundException(
                String.format("User for  with id %s not found", teacherDto.getUserId())));
        user.setRole(roleRepository.findById(3L).orElseThrow());
        userRepository.saveAndFlush(user);

        TeacherEntity teacherEntity = teacherRepository
                .saveAndFlush(teacherFactory.makeTeacherEntity(teacherDto));
        return teacherFactory.makeTeacherResponse(teacherEntity);
    }

    public TeacherResponse getTeacherById(Long teacherId) {
        return teacherFactory
                .makeTeacherResponse(teacherRepository.findById(teacherId).orElseThrow(() -> new NotFoundException(
                        String.format("Teacher with id %s not found", teacherId))));
    }

    public List<TeacherResponse> getAllTeachers() {
        return teacherRepository.findAll().stream().map(teacherFactory::makeTeacherResponse).collect(Collectors.toList());
    }

    public void deleteByTeacherId(Long teacherId) {
        teacherRepository.findById(teacherId).orElseThrow(() -> new NotFoundException(
                        String.format("Teacher with id %s not found", teacherId)));
        teacherRepository.deleteById(teacherId);
    }


    public ClassResponse createUpdateClass(ClassDto classDto) {
        ClassEntity classEntity = classRepository.saveAndFlush(classFactory.makeClassEntity(classDto));
        return classFactory.makeClassResponse(classEntity);

    }

    public ClassResponse getClass(Long classId) {
        return classFactory.
                makeClassResponse(classRepository.findById(classId).orElseThrow(() -> new NotFoundException(
                        String.format("Class  with id %s not found", classId))));
    }

    public List<ClassResponse> getAllClasses() {
        return classRepository.findAll().stream()
                .map(classFactory::makeClassResponse)
                .toList();
    }


    public void deleteClass(Long classId) {
        classRepository.deleteById(classId);
    }


}
