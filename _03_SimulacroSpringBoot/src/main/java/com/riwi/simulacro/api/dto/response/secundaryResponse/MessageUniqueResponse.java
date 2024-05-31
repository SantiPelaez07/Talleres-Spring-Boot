package com.riwi.simulacro.api.dto.response.secundaryResponse;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageUniqueResponse {
    private Long id;
    private String messageContent;
    private LocalDateTime dateTime;
}
