package com.riwi.simulacro.api.dto.request;

import java.time.LocalDate;
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
public class AssignmentRequest {

    @NotBlank(message = "El título de la asignación es requerido")
    @Size(min = 10, max = 30)
    private String title;
    @NotBlank(message = "La descripción de esta signación es requerida")
    @Size(min = 100, max = 500)
    private String description;
    @NotBlank(message = "La fecha de esta asignación es requerida")
    private LocalDate date;
    @NotBlank(message = "El id de la lección a la cual pertenece esta asignación es requerida")
    private Long idLesson;
}
