package com.riwi.simulacro.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {
    @NotBlank(message = "El titulo de la lección es requerido")
    private String title;
    @NotBlank(message = "El contendo del curso es requerido")
    private String content;
    @NotBlank(message = "El id del curso al que pertenece cada lección es requerido")
    private Long idCourse;
}
