package com.example.GradeBook.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectTypeResponse {

    @JsonProperty("subject_type_id")
    private Long subjectTypeId;

    @NonNull
    @JsonProperty("subject_type_name")
    private String subjectTypeName;


}
