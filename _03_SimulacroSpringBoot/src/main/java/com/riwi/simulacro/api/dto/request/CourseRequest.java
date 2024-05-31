package com.riwi.simulacro.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    @NotBlank(message = "El nombre del curso es requerido")
    @Size(min = 10, max = 50)
    private String course_name;
    @NotBlank(message = "La descripción del curso es obligatoria")
    @Size(min = 100, max = 500)
    private String description;
    @NotBlank(message = "El id del instructor es requerido")
    private Long idInstructor;
}
