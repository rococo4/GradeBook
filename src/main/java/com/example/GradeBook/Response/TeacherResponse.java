package com.example.GradeBook.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherResponse {

    @JsonProperty("teacher_id")
    private Long teacherId;

    private List<ClassResponse> classes;

    @NonNull
    private UserResponse user;

    @NonNull
    @JsonProperty("subject_type")
    private SubjectTypeResponse subjectType;

}
