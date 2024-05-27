package com.example.GradeBook.store.repositories;

import com.example.GradeBook.store.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
