package com.example.GradeBook.store.repositories;

import com.example.GradeBook.store.entities.GradeEntity;
import com.example.GradeBook.store.entities.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends CrudRepository<GradeEntity, Long> {
    Optional<List<GradeEntity>> findAllByStudent(StudentEntity student);
}
