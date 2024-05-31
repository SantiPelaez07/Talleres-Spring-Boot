package com.riwi.simulacro.api.dto.response.secundaryResponse;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentSecundaryResponse {
    private Long id;
    private LocalDate date;
    private List<UserBasicResponse> users;
}
