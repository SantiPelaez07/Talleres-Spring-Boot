package com.riwi.simulacro.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    @NotBlank(message = "El contenico del mensaje no puede ser nulo")
    private String messageContent;
    @NotBlank(message = "La hora y fecha del mensaje son requeridas")
    private LocalDateTime dateTime;
    @NotBlank(message = "El id del curso del usuario es requerido")
    private Long courseId;
    @NotBlank(message = "El id de los mensajes enviados del usuario es requerido")
    private Long senderMessageId;
    @NotBlank(message = "El id de los mensajes recibidos del usuario es requerido")
    private Long receiverMessageId;
}
