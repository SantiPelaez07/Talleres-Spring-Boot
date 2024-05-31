package com.riwi.simulacro.infrastructure.abstract_services;

import com.riwi.simulacro.api.dto.request.SubmissionRequest;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.SubmissionResponse;

public interface ISubmissionService extends CrudService<SubmissionRequest, SubmissionResponse, Long> {
    public final String FIELD_SORT = "date";
}
