package com.example.GradeBook.Controllers;

import com.example.GradeBook.DTO.GradeDto;
import com.example.GradeBook.Services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {
    public static final String GET_GRADES = "api/student/getGrades";

    StudentService studentService;
    @GetMapping(GET_GRADES)
    public final List<GradeDto> getGrades(@RequestParam(value = "student_id") long studentId) {
        return studentService.getGradesForStudent(studentId);
    }
}
