package com.example.GradeBook.Controllers;

import com.example.GradeBook.DTO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {
    public final String DELETE_STUDENT = "api/admin/students/{studentId}";
    public final String GET_ALL_STUDENTS = "api/admin/students";

    public final String UPDATE_TEACHER = "api/admin/teachers";
    public final String DELETE_TEACHER = "api/admin/teachers/{teacherId}";
    public final String GET_ALL_TEACHERS = "api/admin/teachers";
    public final String ADD_UPDATE_CLASS_FOR_TEACHER = "api/admin/teachers/{teacherId}/class";

    public final String CHANGE_ROLE = "api/admin/users/{userId}/role";


    public final String CREATE_UPDATE_CLASS = "api/admin/classes";
    public final String DELETE_CLASS = "api/admin/classes/{classId}";


    @DeleteMapping(DELETE_STUDENT)
    //todo: сделать возвращение успешно/неуспешно
    public void deleteStudent(@PathVariable Long studentId) {

    }

    @GetMapping(GET_ALL_STUDENTS)
    public List<StudentDto> getAllStudents() {

    }

    @PostMapping(UPDATE_TEACHER)
    //todo: сделать возвращение успешно/неуспешно
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto) {

    }

    @DeleteMapping(DELETE_TEACHER)
    public void deleteTeacher(@PathVariable Long teacherId) {

    }

    @GetMapping(GET_ALL_TEACHERS)
    public List<TeacherDto> getAllTeachers() {

    }

    @PostMapping(ADD_UPDATE_CLASS_FOR_TEACHER)
    public List<ClassDto> addUpdateClassForTeacher(
            @PathVariable Long teacherId, @RequestBody List<ClassDto> classesDto) {

    }

    @PostMapping(CHANGE_ROLE)
    public UserDto changeRole(@PathVariable Long userId, @RequestBody RoleDto roleDto) {

    }

    @PostMapping(CREATE_UPDATE_CLASS)
    public ClassDto createUpdateClass(@RequestBody ClassDto classDto) {

    }

    @DeleteMapping(DELETE_CLASS)
    public void deleteClass(@PathVariable Long classId) {

    }





}
