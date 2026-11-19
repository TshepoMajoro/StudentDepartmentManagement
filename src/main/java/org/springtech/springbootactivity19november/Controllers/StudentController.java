package org.springtech.springbootactivity19november.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springtech.springbootactivity19november.DTOs.StudentRequest;
import org.springtech.springbootactivity19november.DTOs.StudentResponse;
import org.springtech.springbootactivity19november.Exceptions.ResourceNotFoundException;
import org.springtech.springbootactivity19november.Services.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final IStudentService service;

    public StudentController(IStudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentResponse> create(
            @RequestBody StudentRequest request) throws ResourceNotFoundException {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> findById(
            @PathVariable Long id) throws ResourceNotFoundException {

        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<StudentResponse>>
    findByDepartment(@PathVariable Long departmentId) throws ResourceNotFoundException {

        return ResponseEntity.ok(
                service.findByDepartment(departmentId)
        );
    }
}
