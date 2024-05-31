package com.riwi.simulacro.api.dto.response.secundaryResponse;

import com.riwi.simulacro.util.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicResponse {
    private Long id;
    private String userName;
    private String email;
    private String fullName;
    private Role role;
}
