package com.example.GradeBook.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassResponse {

    @JsonProperty("class_id")
    private Long classId;

    @NonNull
    @JsonProperty("class_name")
    private String className;

    @NonNull
    private List<StudentResponse> students;
}
