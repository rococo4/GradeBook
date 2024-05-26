package com.example.GradeBook.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {
    @NonNull
    @JsonProperty("role_id")
    private Long roleId;

    @NonNull
    @JsonProperty("role_name")
    private String roleName;
}
