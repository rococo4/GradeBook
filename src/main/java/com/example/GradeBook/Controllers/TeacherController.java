package com.example.GradeBook.Controllers;

import com.example.GradeBook.DTO.ClassDto;
import com.example.GradeBook.DTO.GradeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TeacherController {
    public final String GET_ALL_CLASSES_FOR_TEACHER = "api/teacher/get-classes-for-teacher";
    public final String PUT_MARK = "api/teacher/{class-id}/put-mark";
    public final String GEL_ALL_DATA_FOR_CLASS = "api/teacher/{class-id}";



    @GetMapping(GET_ALL_CLASSES_FOR_TEACHER)
    public List<ClassDto> getAllClassesByIdTeacher(@RequestParam(value = "teacher_id") Long teacherId) {

    }

    //todo: сделать ответ успешно/неуспешно
    @PostMapping(PUT_MARK)
    public void putMarkToStudent(@PathVariable("class-id") Long class_id, @RequestBody GradeDto gradeDto) {

    }

    @GetMapping(GEL_ALL_DATA_FOR_CLASS)
    public ClassDto getAllDataForClassById(@PathVariable("class-id") Long class_id) {
        
    }
}
