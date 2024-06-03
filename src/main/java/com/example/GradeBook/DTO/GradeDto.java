package com.example.GradeBook.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradeDto {

    @JsonProperty("grade_id")
    private Long gradeId;

    private String mark;

    @NonNull
    @JsonProperty("created_at")
    private Instant createdAt;

    @NonNull
    @JsonProperty("student_id")
    private Long studentId;

    @NonNull
    @JsonProperty("subject_type")
    private SubjectTypeDto subjectType;

}
