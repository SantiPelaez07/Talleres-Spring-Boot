package com.riwi.simulacro.api.dto.response.secundaryResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonSecundaryResponse {
    private Long id;
    private String title;
    private String content;
}
