package com.example.GradeBook.store.repositories;

import com.example.GradeBook.store.entities.GradeEntity;
import com.example.GradeBook.store.entities.StudentEntity;
import com.example.GradeBook.store.entities.SubjectTypeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
    Optional<List<GradeEntity>> findAllByStudent(StudentEntity student);
    Optional<List<GradeEntity>> findAllByStudentAndSubjectType(
            StudentEntity student, SubjectTypeEntity subjectType);
}
