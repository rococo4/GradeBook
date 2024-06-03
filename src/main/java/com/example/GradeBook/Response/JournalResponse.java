package com.example.GradeBook.Response;

import com.example.GradeBook.DTO.GradeDto;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalResponse {

    @NonNull
    private Long teacherId;

    @NonNull
    private Long classId;

    @NonNull
    private Map<Long, List<GradeResponse>> classJournal;
}
