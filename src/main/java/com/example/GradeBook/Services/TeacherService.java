package com.example.GradeBook.Services;

import com.example.GradeBook.DTO.GradeDto;
import com.example.GradeBook.Exceptions.NotFoundException;
import com.example.GradeBook.Factories.ClassFactory;
import com.example.GradeBook.Factories.GradeFactory;
import com.example.GradeBook.Response.ClassResponse;
import com.example.GradeBook.Response.GradeResponse;
import com.example.GradeBook.Response.JournalResponse;
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
    private final TeacherRepository teacherRepository;
    private final ClassRepository classRepository;
    private final GradeRepository gradeRepository;
    private final SubjectTypeRepository subjectTypeRepository;


    private final ClassFactory classFactory;
    private final GradeFactory gradeFactory;


    public List<ClassResponse> getAllClassesByTeacherId(Long teacherId) {
        return teacherRepository.findById(teacherId)
                // todo: написать exception если не нашелся учитель
                .orElseThrow(() -> new NotFoundException(
                        String.format("Teacher with id %s not found", teacherId)))
                .getClasses().stream()
                .map(classFactory::makeClassResponse).toList();
    }

    public JournalResponse getJournalByClassIdTeacherId(Long classId, Long teacherId) {
        //todo: написать exception если класса не нашлось
        ClassEntity classEntity = classRepository.findById(classId).orElseThrow(() -> new NotFoundException(
                String.format("Class with id %s not found", classId)));
        //todo: написать exception если не нашлось учителя
        TeacherEntity teacherEntity = teacherRepository.findById(teacherId).orElseThrow(() -> new NotFoundException(
                String.format("Teacher with id %s not found", teacherId)));

        return JournalResponse.builder()
                .classId(classId)
                .teacherId(teacherId)
                .classJournal(classEntity.getStudents().stream().collect(Collectors.toMap(
                        StudentEntity::getId,
                        studentEntity -> getAllMarksForStudent(studentEntity, teacherEntity.getSubjectType())
                ))).build();
    }

    public JournalResponse putMarks(List<GradeDto> gradesDto, Long classId, Long teacherId) {
        List<GradeEntity> grades = gradesDto.stream().map(gradeFactory::makeGradeEntity).toList();
        gradeRepository.saveAllAndFlush(grades);

        ClassEntity classEntity = classRepository.findById(classId).orElseThrow(() -> new NotFoundException(
                String.format("Class with id %s not found", classId)));

        TeacherEntity teacherEntity = teacherRepository.findById(teacherId).orElseThrow(() -> new NotFoundException(
                String.format("Teacher with id %s not found", teacherId)));

        return JournalResponse.builder()
                .classId(classId)
                .teacherId(teacherId)
                .classJournal(classEntity.getStudents().stream().collect(Collectors.toMap(
                        StudentEntity::getId,
                        studentEntity -> getAllMarksForStudent(studentEntity, teacherEntity.getSubjectType())
                ))).build();

    }

    private List<GradeResponse> getAllMarksForStudent(StudentEntity student, SubjectTypeEntity subjectType) {
        return gradeRepository.findAllByStudentAndSubjectType(student, subjectType)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Marks for student with id %s  for subject %s were not found",
                                student.getId(), subjectType.getSubjectTypeName())))
                .stream().map(gradeFactory::makeGradeResponse)
                .collect(Collectors.toList());
    }
}
