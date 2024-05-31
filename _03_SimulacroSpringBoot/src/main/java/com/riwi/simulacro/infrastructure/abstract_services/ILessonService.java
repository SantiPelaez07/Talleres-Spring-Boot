package com.riwi.simulacro.infrastructure.abstract_services;

import com.riwi.simulacro.api.dto.request.LessonRequest;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.LessonResponse;

public interface ILessonService extends CrudService <LessonRequest, LessonResponse, Long> {
    public final String FIELD_SORT = "title";
}
