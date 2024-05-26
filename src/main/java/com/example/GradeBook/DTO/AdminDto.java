package com.example.GradeBook.DTO;

import com.example.GradeBook.store.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;



    @NonNull
    private UserDto user;
}
