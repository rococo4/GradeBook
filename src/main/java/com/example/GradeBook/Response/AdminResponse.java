package com.example.GradeBook.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminResponse {
    @JsonProperty("admin_id")
    private Long adminId;

    @NonNull
    private UserResponse userId;
}
