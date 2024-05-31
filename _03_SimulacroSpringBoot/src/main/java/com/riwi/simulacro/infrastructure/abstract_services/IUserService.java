package com.riwi.simulacro.infrastructure.abstract_services;

import com.riwi.simulacro.api.dto.request.UserRequest;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserResponse, Long>{
    public final String FIELD_SORT = "userName";
}
