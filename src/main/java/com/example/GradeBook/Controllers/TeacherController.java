package com.example.GradeBook.Controllers;

import com.example.GradeBook.DTO.ClassDto;
import com.example.GradeBook.DTO.GradeDto;
import com.example.GradeBook.Response.ClassResponse;
import com.example.GradeBook.Response.JournalResponse;
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
    public List<ClassResponse> getAllClassesByTeacherId(@RequestParam(value = "teacher_id") Long teacherId) {
        return teacherService.getAllClassesByTeacherId(teacherId);
    }

    //todo: сделать ответ успешно/неуспешно
    @PostMapping(PUT_MARK)
    public JournalResponse putMarks(
            @PathVariable("class-id") Long classId,
            @RequestBody List<GradeDto> gradesDto,
            @RequestParam(name = "teacher_id") Long teacherId) {
        return teacherService.putMarks(gradesDto, classId, teacherId);
    }

    @GetMapping(GEL_ALL_DATA_FOR_CLASS)
    public JournalResponse getAllGradesForClassByClassIdTeacherId(
            @PathVariable("class-id") Long classId,
            @RequestParam(value = "teacher_id") Long teacherId) {
        return teacherService.getJournalByClassIdTeacherId(classId, teacherId);
    }

}
