package com.example.GradeBook.store.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String firstName;
    private String lastName;

    //todo уникальный
    private String username;
    private String password;
    //todo уникальный
    private String email;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private RoleEntitiy role;
}
