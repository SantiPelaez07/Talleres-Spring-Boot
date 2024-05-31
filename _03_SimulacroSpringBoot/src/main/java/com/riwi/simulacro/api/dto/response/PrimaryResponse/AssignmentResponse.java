package com.riwi.simulacro.api.dto.response.PrimaryResponse;

import java.time.LocalDate;

import com.riwi.simulacro.api.dto.response.secundaryResponse.LessonSecundaryResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDate date;
    private LessonSecundaryResponse lesson;
}
