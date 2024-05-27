package com.example.GradeBook.Controllers;

import com.example.GradeBook.DTO.ClassDto;
import com.example.GradeBook.DTO.GradeDto;
import com.example.GradeBook.Services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TeacherController {
    public final String GET_ALL_CLASSES_FOR_TEACHER = "api/teacher/get-classes-for-teacher";
    public final String PUT_MARK = "api/teacher/{class-id}/put-mark";
    public final String GEL_ALL_DATA_FOR_CLASS = "api/teacher/{class-id}";


    private final TeacherService teacherService;

    @GetMapping(GET_ALL_CLASSES_FOR_TEACHER)
    public List<ClassDto> getAllClassesByTeacherId(@RequestParam(value = "teacher_id") Long teacherId) {
        return teacherService.getAllClassesByTeacherId(teacherId);
    }

    //todo: сделать ответ успешно/неуспешно
    @PostMapping(PUT_MARK)
    public List<List<GradeDto>> putMarkToStudent(@PathVariable("class-id") Long class_id, @RequestBody List<GradeDto> gradesDto) {
        return teacherService.putMarkToStudent(gradesDto, class_id);
    }

    @GetMapping(GEL_ALL_DATA_FOR_CLASS)
    public List<List<GradeDto>> getAllGradesForClassByClassIdTeacherId(
            @PathVariable("class-id") Long classId,
            @RequestParam(value = "teacher_id") Long teacherId) {
        return teacherService.getAllGradesForClassByClassIdTeacherId(classId, teacherId);
    }
}
