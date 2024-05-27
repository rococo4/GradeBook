package com.example.GradeBook.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classes")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long classId;

    @Column(unique = true)
    private String className;

    @OneToMany
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private List<StudentEntity> students = new ArrayList<>();

}
