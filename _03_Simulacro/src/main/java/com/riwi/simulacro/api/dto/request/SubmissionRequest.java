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
public class SubmissionRequest {

    @NotBlank(message = "El contenido para realizar la entrega es requerido")
    @Size(max = 500)
    private String content;
    @NotBlank(message = "La fecha en la que se realizará el envío es requerida")
    private LocalDate date;
    @NotBlank(message = "La nota del usuario es requerida")
    private double grade;
    @NotBlank(message = "El id del estudiante es requerido")
    private Long idUser;
    @NotBlank(message = "El id de la asignación es requerida")
    private Long idAssignment;
}
