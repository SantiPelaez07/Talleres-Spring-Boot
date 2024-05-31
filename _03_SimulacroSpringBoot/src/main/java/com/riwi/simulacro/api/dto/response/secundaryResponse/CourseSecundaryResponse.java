package com.riwi.simulacro.api.dto.response.secundaryResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseSecundaryResponse {
    private Long id;
    private String course_name;
    private String description;
    private UserBasicResponse user;
}
