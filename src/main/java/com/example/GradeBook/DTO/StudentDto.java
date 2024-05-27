package com.example.GradeBook.DTO;

import com.example.GradeBook.store.entities.ClassEntity;
import com.example.GradeBook.store.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    @NonNull
    private Long id;
}
