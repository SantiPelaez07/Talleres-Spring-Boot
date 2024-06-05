package com.riwi.simulacro.api.dto.response.PrimaryResponse;

import java.time.LocalDate;
import java.util.List;

import com.riwi.simulacro.api.dto.response.secundaryResponse.CourseUniqueResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.UserBasicResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponse {
    private Long id;
    private LocalDate date;
    private List<UserBasicResponse> users;
    private List<CourseUniqueResponse> courses;
}
