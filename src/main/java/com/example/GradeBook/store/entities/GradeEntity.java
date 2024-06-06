package com.example.GradeBook.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "grades")
public class GradeEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long gradeId;

    private String mark;

    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "student", referencedColumnName = "id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "subject_type", referencedColumnName = "id")
    private SubjectTypeEntity subjectType;
}
