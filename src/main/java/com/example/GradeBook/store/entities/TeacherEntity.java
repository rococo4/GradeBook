package com.example.GradeBook.store.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teachers")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    private List<ClassEntity> classes;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private UserEntity userId;
}
