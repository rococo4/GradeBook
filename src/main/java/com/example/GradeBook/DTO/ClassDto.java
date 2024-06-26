package com.example.GradeBook.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassDto {

    @JsonProperty("class_id")
    private Long classId;

    @NonNull
    @JsonProperty("class_name")
    private String className;

    @NonNull
    @JsonProperty("students_id")
    private List<Long> studentsId;
}
