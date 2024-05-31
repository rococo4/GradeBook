package com.example.GradeBook.store.repositories;

import com.example.GradeBook.store.entities.RoleEntitiy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntitiy, Long> {
}
