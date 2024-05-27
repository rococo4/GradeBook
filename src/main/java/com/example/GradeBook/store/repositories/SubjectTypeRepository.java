package com.example.GradeBook.store.repositories;

import com.example.GradeBook.store.entities.SubjectTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SubjectTypeRepository  extends JpaRepository<SubjectTypeEntity, Long> {
}
