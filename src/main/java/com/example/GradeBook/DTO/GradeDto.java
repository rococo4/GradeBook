package com.example.GradeBook.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradeDto {
    @NonNull
    @JsonProperty("grade_id")
    private Long gradeId;

    private String mark;

    @NonNull
    @JsonProperty("created_at")
    private Instant createdAt;

    @NonNull
    @JsonProperty("student")
    private StudentDto student;

    @NonNull
    @JsonProperty("subject_type")
    private SubjectTypeDto subjectType;

}
