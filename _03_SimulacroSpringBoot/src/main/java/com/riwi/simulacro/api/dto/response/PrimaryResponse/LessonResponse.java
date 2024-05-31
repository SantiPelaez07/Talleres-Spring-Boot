package com.riwi.simulacro.api.dto.response.PrimaryResponse;


import com.riwi.simulacro.api.dto.response.secundaryResponse.CourseUniqueResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse {
    private Long id;
    private String title;
    private String content;
    private CourseUniqueResponse course;  
}
