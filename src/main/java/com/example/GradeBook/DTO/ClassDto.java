package com.example.GradeBook.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassDto {
    @NonNull
    @JsonProperty("class_id")
    private Long classId;

    @NonNull
    @JsonProperty("class_name")
    private String className;

    @NonNull
    @JsonProperty("users")
    private List<StudentDto> students;
}
