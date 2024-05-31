package com.riwi.simulacro.infrastructure.abstract_services;

import com.riwi.simulacro.api.dto.request.MessageRequest;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.MessageResponse;

public interface IMessageService extends CrudService<MessageRequest, MessageResponse, Long>{
    public final String FIELD_SORT = "dateTime";
}
