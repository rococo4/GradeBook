package com.example.GradeBook.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradeResponse {

    @JsonProperty("grade_id")
    private Long gradeId;

    private String mark;

    @NonNull
    @JsonProperty("created_at")
    private Instant createdAt;

    @NonNull
    private StudentResponse student;

    @NonNull
    @JsonProperty("subject_type")
    private SubjectTypeResponse subjectType;

}
