package com.riwi.simulacro.api.dto.response.secundaryResponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionBasicResponse {
    private Long id;
    private String content;
    private LocalDate date;
    private double grade;
}
