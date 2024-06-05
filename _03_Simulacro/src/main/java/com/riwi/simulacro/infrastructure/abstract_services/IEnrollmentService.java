package com.riwi.simulacro.infrastructure.abstract_services;

import com.riwi.simulacro.api.dto.request.EnrollmentRequest;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.EnrollmentResponse;

public interface IEnrollmentService extends CrudService<EnrollmentRequest, EnrollmentResponse, Long>{
    public final String FIELD_SORT = "date";
}
