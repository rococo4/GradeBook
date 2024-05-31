package com.example.GradeBook.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.catalina.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {

    @JsonProperty("student_id")
    private Long studentId;

    @NonNull
    private UserResponse userId;
}
