package com.riwi.simulacro.infrastructure.services;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.simulacro.api.dto.request.AssignmentRequest;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.AssignmentResponse;
import com.riwi.simulacro.api.dto.response.secundaryResponse.LessonSecundaryResponse;
import com.riwi.simulacro.domain.entities.Assignment;
import com.riwi.simulacro.domain.repositories.AssignmentRepository;
import com.riwi.simulacro.infrastructure.abstract_services.IAssignmentService;
import com.riwi.simulacro.util.enums.SortType;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AssignmentService implements IAssignmentService{

    @Autowired
    private final AssignmentRepository assignmentRepository;

    @Override
    public AssignmentResponse create(AssignmentRequest request) {
        Assignment assignmentEntity = this.requestToEntity(request);
        return this.entityToResponse(this.assignmentRepository.save(assignmentEntity));
    }

    @Override
    public AssignmentResponse getId(Long id) {
        return this.entityToResponse(this.findByIdAssignment(id));
    }

    @Override
    public AssignmentResponse update(AssignmentRequest request, Long id) {
        Assignment assignment = this.findByIdAssignment(id);
        Assignment assignmentUpdate = this.requestToEntity(request);
        assignmentUpdate.setId(id);
        assignmentUpdate.setLesson(assignment.getLesson());

        return this.entityToResponse(this.assignmentRepository.save(assignmentUpdate));
    }

    @Override
    public void delete(Long id) {
        Assignment assignment = this.findByIdAssignment(id);
        this.assignmentRepository.delete(assignment);
    }

    @Override
    public Page<AssignmentResponse> getAll(int page, int size, SortType sortType) {
        if (page < 0) page = 0;
        PageRequest pagination = null;
        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_SORT).descending());
        }

        return this.assignmentRepository.findAll(pagination).map(this::entityToResponse);
    }

    private AssignmentResponse entityToResponse(Assignment entity){

        LessonSecundaryResponse lessonRes = new LessonSecundaryResponse();
        BeanUtils.copyProperties(entity.getLesson(), lessonRes);

        return AssignmentResponse.builder()
            .id(entity.getId())
            .title(entity.getTitle())
            .description(entity.getDescription())
            .date(entity.getDate())
            .lesson(lessonRes)
            .build();
    }

    private Assignment requestToEntity(AssignmentRequest request){
        return Assignment.builder()
            .title(request.getTitle())
            .description(request.getDescription())
            .date(request.getDate())
            .build();
    }   

    private Assignment findByIdAssignment(Long id){
        return this.assignmentRepository.findById(id).orElseThrow();
    }
}
