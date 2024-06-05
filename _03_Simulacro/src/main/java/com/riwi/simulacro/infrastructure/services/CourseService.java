package com.riwi.simulacro.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.simulacro.api.dto.request.CourseRequest;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.CourseResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.MessageUniqueResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.UserBasicResponse;
import com.riwi.simulacro.domain.entities.Course;
import com.riwi.simulacro.domain.entities.Message;
import com.riwi.simulacro.domain.repositories.CourseRepository;
import com.riwi.simulacro.infrastructure.abstract_services.ICourseService;
import com.riwi.simulacro.util.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService{
    @Autowired
    private final CourseRepository courseRepository;

    @Override
    public CourseResponse create(CourseRequest request) {
        Course courseEntity = this.requestToEntity(request);
        return entityToResponse(this.courseRepository.save(courseEntity));
    }

    @Override
    public CourseResponse getId(Long id) {
        return entityToResponse(this.findByIdCourse(id));
    }

    @Override
    public CourseResponse update(CourseRequest request, Long id) {
        Course course = this.findByIdCourse(id);
        Course courseUpdate = this.requestToEntity(request);
        courseUpdate.setId(id);
        courseUpdate.setLessons(course.getLessons());
        courseUpdate.setMessages(course.getMessages());
        courseUpdate.setUser(course.getUser());

        return this.entityToResponse(this.courseRepository.save(courseUpdate));
    }

    @Override
    public void delete(Long id) {
        Course course = this.findByIdCourse(id);
        this.courseRepository.delete(course);
    }

    @Override
    public Page<CourseResponse> getAll(int page, int size, SortType sortType) {
        if (page < 0) page = 0;
        PageRequest pagination = null;
        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_SORT).descending());
        }

        return this.courseRepository.findAll(pagination).map(this::entityToResponse);
    }

    private CourseResponse entityToResponse(Course entity) {
        // EnrollmentBasicResponse enrollment = new EnrollmentBasicResponse();
        // BeanUtils.copyProperties(entity., enrollment);

        List<MessageUniqueResponse> message = new ArrayList<>();
        for (Message msg : entity.getMessages()) {
            MessageUniqueResponse messageResponse = new MessageUniqueResponse();
            BeanUtils.copyProperties(msg, messageResponse);
            message.add(messageResponse);
        }
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

    private Course requestToEntity(CourseRequest request) {
        return Course.builder()
                .courseName(request.getCourse_name())
                .description(request.getDescription())
                .build();
    }

    private Course findByIdCourse(Long id) {
        return this.courseRepository.findById(id).orElseThrow();
    }
}
