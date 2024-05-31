package com.example.GradeBook.Controllers;

import com.example.GradeBook.DTO.*;
import com.example.GradeBook.Services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {
    // todo если передается одна из dto без user выкинуть ошибку
    public final String CREATE_UPDATE_STUDENT = "api/admin/students/{studentId}";
    public final String GET_STUDENT= "api/admin/students/{studentId}";
    public final String GET_ALL_STUDENTS = "api/admin/students";
    public final String DELETE_STUDENT = "api/admin/students/{studentId}";


    public final String GET_TEACHER = "api/admin/teachers/{teacherId}";
    public final String CREATE_UPDATE_TEACHER = "api/admin/teachers/{teacherId}";
    public final String GET_ALL_TEACHERS = "api/admin/teachers";
    public final String DELETE_TEACHER = "api/admin/teachers/{teacherId}";


    public final String GET_CLASS = "api/admin/classes/{classId}";
    public final String CREATE_UPDATE_CLASS = "api/admin/classes/{classId}";
    public final String GET_ALL_CLASSES = "api/admin/classes";
    public final String DELETE_CLASS = "api/admin/classes/{classId}";

    private final AdminService adminService;

    @PostMapping(CREATE_UPDATE_STUDENT)
    public StudentDto addUpdateStudent(@RequestBody StudentDto studentDto) {
        return adminService.addUpdateStudent(studentDto);
    }

    @GetMapping(GET_STUDENT)
    public StudentDto getStudent(@PathVariable Long studentId) {
        return adminService.getStudentById(studentId);
    }

    @GetMapping(GET_ALL_STUDENTS)
    public List<StudentDto> getAllStudents() {
        return adminService.getAllStudents();
    }
    @DeleteMapping(DELETE_STUDENT)
    //todo: сделать возвращение успешно/неуспешно
    public void deleteStudent(@PathVariable Long studentId) {
        adminService.deleteStudentById(studentId);
    }



    @PostMapping(CREATE_UPDATE_TEACHER)
    //todo: сделать возвращение успешно/неуспешно
    public TeacherDto addUpdateTeacher(@RequestBody TeacherDto teacherDto) {
        return adminService.addUpdateTeacher(teacherDto);
    }

    @GetMapping(GET_TEACHER)
    public TeacherDto getTeacher(@PathVariable Long teacherId) {
        return adminService.getTeacherById(teacherId);
    }

    @GetMapping(GET_ALL_TEACHERS)
    public List<TeacherDto> getAllTeachers() {
        return adminService.getAllTeachers();
    }

    //todo разобратсья с секьюрити(удаление)
    @DeleteMapping(DELETE_TEACHER)
    public void deleteTeacher(@PathVariable Long teacherId) {
        adminService.deleteByTeacherId(teacherId);
    }



    @PostMapping(CREATE_UPDATE_CLASS)
    public ClassDto createUpdateClass(@RequestBody ClassDto classDto) {
        return adminService.createUpdateClass(classDto);
    }
    @GetMapping(GET_CLASS)
    public ClassDto getClass(@PathVariable Long classId) {
        return adminService.getClass(classId);
    }

    @GetMapping(GET_ALL_CLASSES)
    public List<ClassDto> getAllClasses() {
        return adminService.getAllClasses();
    }

    @DeleteMapping(DELETE_CLASS)
    public void deleteClass(@PathVariable Long classId) {
        adminService.deleteClass(classId);
    }
}
