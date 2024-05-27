package com.example.GradeBook.DTO;

import com.example.GradeBook.store.entities.ClassEntity;
import com.example.GradeBook.store.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDTO {
    @NonNull
    private Long id;

    private List<ClassDto> classes;

    @NonNull
    private UserDto user;

    @NonNull
    private SubjectTypeDto subjectType;
}
