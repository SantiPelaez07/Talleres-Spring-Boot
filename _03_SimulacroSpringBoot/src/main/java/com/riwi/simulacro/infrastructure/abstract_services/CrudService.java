package com.riwi.simulacro.infrastructure.abstract_services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.simulacro.util.enums.SortType;

@Service
public interface CrudService<Request, Response, ID> {
    public Response create(Request request);
    public Response getId(Long id);
    public Response update(Request request, ID id);
    public void delete(ID id);
    public Page<Response> getAll(int page, int size, SortType sortType);
}
