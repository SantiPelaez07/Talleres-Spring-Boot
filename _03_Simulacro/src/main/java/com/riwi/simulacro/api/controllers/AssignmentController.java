package com.riwi.simulacro.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.simulacro.api.dto.request.AssignmentRequest;
import com.riwi.simulacro.api.dto.response.PrimaryResponse.AssignmentResponse;
import com.riwi.simulacro.infrastructure.abstract_services.IAssignmentService;
import com.riwi.simulacro.util.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Controller
@RestController
@Tag(name = "Assignment")
@RequestMapping(path = "assignment")
@AllArgsConstructor
public class AssignmentController {

    @Autowired
    private final IAssignmentService assignmentService; 


    @PostMapping
    @Operation(
        summary = "Create a new Assignment",
        tags = "Assignment creation"
    )
    public ResponseEntity<AssignmentResponse> create(@RequestBody AssignmentRequest assignmentRequest){
        return ResponseEntity.ok(this.assignmentService.create(assignmentRequest));
    } 

    @Operation(
        summary = "Get by id Assignment",
        tags = "Assignment get by id"
    )
    @GetMapping(path = "/{id}")
    public ResponseEntity<AssignmentResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.assignmentService.getId(id));
    }

    @Operation(
        summary = "Get all Assignment",
        tags = "Assignment get"
    )
    @GetMapping
    public ResponseEntity<Page<AssignmentResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestHeader(required = false) SortType sortType
    ){
        if(Objects.isNull(sortType)) sortType = SortType.NONE;

        return ResponseEntity.ok(this.assignmentService.getAll(page - 1, size, sortType));
    }

    @Operation(
        summary = "Update Assignment",
        tags = "Assignment update"
    )
    @PutMapping(path = "/{id}")
    public ResponseEntity<AssignmentResponse> update(@Validated @RequestBody AssignmentRequest assignmentRequest, @PathVariable Long id){
        return ResponseEntity.ok(this.assignmentService.update(assignmentRequest, id));
    }

    @Operation(
        summary = "Delete Assignment",
        tags = "Assignment delete"
    )
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.assignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
