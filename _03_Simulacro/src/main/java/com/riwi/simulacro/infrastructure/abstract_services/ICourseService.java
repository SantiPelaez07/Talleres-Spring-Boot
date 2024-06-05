package com.riwi.simulacro.infrastructure.abstract_services;

import com.riwi.simulacro.api.dto.request.CourseRequest;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.CourseResponse;

public interface ICourseService extends CrudService<CourseRequest, CourseResponse, Long>{
    public final String FIELD_SORT = "courseName";
}
