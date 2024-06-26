package com.example.GradeBook.DTO;

import com.example.GradeBook.store.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDto {
    @JsonProperty("admin_id")
    private Long adminId;

    @NonNull
    private Long userId;
}
