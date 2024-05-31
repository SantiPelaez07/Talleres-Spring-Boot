package com.riwi.simulacro.api.dto.response.PrimaryResponse;

import java.time.LocalDateTime;

import com.riwi.simulacro.api.dto.response.secundaryResponse.CourseSecundaryResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.UserBasicResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private Long id;
    private String messageContent;
    private LocalDateTime dateTime;
    private UserBasicResponse userSender;
    private UserBasicResponse userReceiver;
    private CourseSecundaryResponse course;
}
