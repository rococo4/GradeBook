package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.ClassDto;
import com.example.GradeBook.DTO.GradeDto;
import com.example.GradeBook.DTO.StudentDto;
import com.example.GradeBook.store.entities.GradeEntity;
import com.example.GradeBook.store.entities.StudentEntity;
import com.example.GradeBook.store.repositories.GradeRepository;
import com.example.GradeBook.store.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;

    public List<GradeDto> getGradesForStudent(Long studentId) {
        StudentEntity student = studentRepository.findById(studentId)
                // todo: написать свое исключение
                .orElseThrow(() -> new ArithmeticException("Student not found with id: " + studentId));

        return gradeRepository.findAllByStudent(student).stream()
                .flatMap(List::stream)
                .map(grade -> GradeDto.builder()
                        .gradeId(grade.getGradeId())
                        .mark(grade.getMark())
                        .createdAt(grade.getCreatedAt())
                        .student(StudentDto.builder()
                                .id(grade.getStudent().getId())
                                .build())
                        .build())
                .collect(Collectors.toList());
    }
}