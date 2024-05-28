package com.example.GradeBook.DTO;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDto {
    @NonNull
    private Long id;

    private List<ClassDto> classes;

    @NonNull
    private UserDto user;

    @NonNull
    private SubjectTypeDto subjectType;

}
