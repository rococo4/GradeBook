package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.GradeDto;
import com.example.GradeBook.Factories.GradeFactory;
import com.example.GradeBook.store.entities.StudentEntity;
import com.example.GradeBook.store.repositories.GradeRepository;
import com.example.GradeBook.store.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;

    private GradeFactory gradeFactory;
    public List<GradeDto> getGradesForStudent(Long studentId) {
        StudentEntity student = studentRepository.findById(studentId)
                // todo: написать свое исключение
                .orElseThrow(() -> new ArithmeticException("Student not found with id: " + studentId));

        return gradeRepository.findAllByStudent(student).stream()
                .flatMap(List::stream)
                .map(gradeFactory::makeGradeResponse)
                .toList();
    }
}
