package com.riwi.simulacro.api.dto.response.PrimaryResponse;

import java.time.LocalDate;

import com.riwi.simulacro.api.dto.response.secundaryResponse.AssignmentSecundaryResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.UserBasicResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionResponse {
    private Long id;
    private String content;
    private LocalDate date;
    private double grade;
    private UserBasicResponse user;
    private AssignmentSecundaryResponse assignment;
}
