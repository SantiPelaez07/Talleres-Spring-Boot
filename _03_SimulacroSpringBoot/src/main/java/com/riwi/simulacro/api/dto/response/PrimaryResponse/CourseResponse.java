package com.riwi.simulacro.api.dto.response.PrimaryResponse;

import java.util.List;

import com.riwi.simulacro.api.dto.response.secundaryResponse.EnrollmentBasicResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.MessageUniqueResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.UserBasicResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    private Long id;
    private String courseName;
    private String description;
    private List<EnrollmentBasicResponse> enrrollments;
    private UserBasicResponse users;
    private List<MessageUniqueResponse> messages;
}
