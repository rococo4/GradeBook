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

    private String username;
    private String password;
    private String email;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private RoleEntitiy role;
}
