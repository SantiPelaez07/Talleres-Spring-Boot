package com.riwi.simulacro.api.dto.response.PrimaryResponse;

import java.util.List;

import com.riwi.simulacro.api.dto.response.secundaryResponse.CourseUniqueResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.EnrollmentBasicResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.MessageUniqueResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.SubmissionBasicResponse;
import com.riwi.simulacro.util.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String userName;
    private String email;
    private String fullName;
    private Role role;  
    private List<EnrollmentBasicResponse> enrollments;
    private List<SubmissionBasicResponse> submissions;
    private List<CourseUniqueResponse> courses;
    private List<MessageUniqueResponse> messageReceiver;
    private List<MessageUniqueResponse> messageSender;
}
