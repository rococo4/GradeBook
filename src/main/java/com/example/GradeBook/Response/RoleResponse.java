package com.example.GradeBook.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleResponse {
    @JsonProperty("role_id")
    private Long roleId;

    @NonNull
    @JsonProperty("role_name")
    private String roleName;
}
