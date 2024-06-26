package com.example.GradeBook.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDto {

    @JsonProperty("teacher_id")
    private Long teacherId;

    @JsonProperty("classes_id")
    private List<Long> classesId;

    @NonNull
    @JsonProperty("user_id")
    private Long userId;

    @NonNull
    @JsonProperty("subject_type")
    private SubjectTypeDto subjectType;

}
