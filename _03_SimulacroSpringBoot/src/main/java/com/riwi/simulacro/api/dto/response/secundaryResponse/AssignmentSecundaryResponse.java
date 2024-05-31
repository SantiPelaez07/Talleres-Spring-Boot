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
public class AssignmentSecundaryResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDate date;
}
