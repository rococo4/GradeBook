package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.StudentDto;
import com.example.GradeBook.DTO.TeacherDto;
import com.example.GradeBook.Factories.StudentFactory;
import com.example.GradeBook.store.repositories.StudentRepository;
import com.example.GradeBook.store.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final StudentRepository studentRepository;
    private final StudentFactory studentDtoFactory;
    private final TeacherRepository teacherRepository;

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentDtoFactory::makeStudentDto)
                .collect(Collectors.toList());
    }

    public TeacherDto AddUpdateTeacher(TeacherDto teacherDto) {
        teacherRepository.findById(teacherDto.getId())
                .ifPresent(teacher -> {teacherRepository.deleteById(teacherDto.getId());});

    }




}
