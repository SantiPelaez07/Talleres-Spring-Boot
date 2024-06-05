package com.riwi.simulacro.infrastructure.abstract_services;

import com.riwi.simulacro.api.dto.request.AssignmentRequest;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.AssignmentResponse;

public interface IAssignmentService extends CrudService<AssignmentRequest, AssignmentResponse, Long> {
    public final String FIELD_SORT = "title";
}
