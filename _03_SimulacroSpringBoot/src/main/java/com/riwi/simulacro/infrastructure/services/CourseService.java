package com.riwi.simulacro.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.simulacro.api.dto.request.CourseRequest;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.CourseResponse;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.MessageResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.MessageUniqueResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.UserBasicResponse;
import com.riwi.simulacro.domain.entities.Course;
import com.riwi.simulacro.domain.entities.Message;
import com.riwi.simulacro.domain.repositories.CourseRepository;
import com.riwi.simulacro.infrastructure.abstract_services.CrudService;
import com.riwi.simulacro.util.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService implements CrudService<CourseRequest, CourseResponse, Long>{
    @Autowired
    private final CourseRepository courseRepository;

    @Override
    public CourseResponse create(CourseRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CourseResponse getId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public CourseResponse update(CourseRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<CourseResponse> getAll(int page, int size, SortType sortType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }


    private CourseResponse entityToResponse(Course entity){
        // EnrollmentBasicResponse enrollment = new EnrollmentBasicResponse();
        // BeanUtils.copyProperties(entity., enrollment);

        List<MessageUniqueResponse> message =  entity.getMessages()
        .stream().map(Message -> {
            MessageUniqueResponse messageResponse = new MessageUniqueResponse();
            BeanUtils.copyProperties(Message, MessageResponse);
            return messageResponse;
        });
        BeanUtils.copyProperties(entity.getMessages(), message);

        UserBasicResponse user = new UserBasicResponse();
        BeanUtils.copyProperties(entity.getUser(), user);

        return CourseResponse.builder()
            .id(entity.getId())
            .courseName(entity.getCourseName())
            .description(entity.getDescription())
            .messages(message)
            .users(user).build();

    }
}
