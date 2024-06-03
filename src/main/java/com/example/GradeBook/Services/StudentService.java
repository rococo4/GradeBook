package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.GradeDto;
import com.example.GradeBook.Exceptions.NotFoundException;
import com.example.GradeBook.Factories.GradeFactory;
import com.example.GradeBook.Response.GradeResponse;
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

    private  final GradeFactory gradeFactory;
    public List<GradeResponse> getGradesForStudent(Long studentId) {
        StudentEntity student = studentRepository.findById(studentId)
                // todo: написать свое исключение
                .orElseThrow(() -> new NotFoundException("Student not found with id: " + studentId));

        return gradeRepository.findAllByStudent(student).stream()
                .flatMap(List::stream)
                .map(gradeFactory::makeGradeResponse)
                .toList();
    }
}
