package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.ClassDto;
import com.example.GradeBook.DTO.GradeDto;
import com.example.GradeBook.Factories.ClassFactory;
import com.example.GradeBook.Factories.GradeFactory;
import com.example.GradeBook.store.entities.*;
import com.example.GradeBook.store.repositories.ClassRepository;
import com.example.GradeBook.store.repositories.GradeRepository;
import com.example.GradeBook.store.repositories.SubjectTypeRepository;
import com.example.GradeBook.store.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private TeacherRepository teacherRepository;
    private ClassRepository classRepository;
    private GradeRepository gradeRepository;
    private SubjectTypeRepository subjectTypeRepository;


    private ClassFactory classFactory;
    private GradeFactory gradeFactory;


    public List<ClassDto> getAllClassesByTeacherId(Long teacherId) {
        return teacherRepository.findById(teacherId)
                // todo: написать exception если не нашелся учитель
                .orElseThrow()
                .getClasses().stream()
                .map(classFactory::makeClassResponse).toList();
    }

    public List<List<GradeDto>> getAllGradesForClassByClassIdTeacherId(Long classId, Long teacherId) {
        //todo: написать exception если класса не нашлось
        ClassEntity classEntity = classRepository.findById(classId).orElseThrow();
        //todo: написать exception если не нашлось учителя
        TeacherEntity teacherEntity = teacherRepository.findById(teacherId).orElseThrow();

        return classEntity.getStudents().stream().map(student ->
                        getAllMarksForStudent(student, teacherEntity.getSubjectType()))
                .collect(Collectors.toList());
    }

    public List<List<GradeDto>> putMarks(List<GradeDto> gradesDto, Long classId) {
        List<GradeEntity> grades = gradesDto.stream().map(gradeFactory::makeGradeEntity).toList();
        gradeRepository.saveAllAndFlush(grades);

        ClassEntity classEntity = classRepository.findById(classId).orElseThrow();

        return classEntity.getStudents().stream().map(student ->
                        getAllMarksForStudent(student, grades.get(0).getSubjectType()))
                .collect(Collectors.toList());

    }

    private List<GradeDto> getAllMarksForStudent(StudentEntity student, SubjectTypeEntity subjectType) {
        return gradeRepository.findAllByStudentAndSubjectType(student, subjectType)
                .orElseThrow()
                .stream().map(gradeFactory::makeGradeResponse)
                .collect(Collectors.toList());
    }
}
