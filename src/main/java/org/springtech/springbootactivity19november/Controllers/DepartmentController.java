package org.springtech.springbootactivity19november.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springtech.springbootactivity19november.DTOs.DepartmentRequest;
import org.springtech.springbootactivity19november.DTOs.DepartmentResponse;
import org.springtech.springbootactivity19november.Exceptions.ResourceNotFoundException;
import org.springtech.springbootactivity19november.Services.IDepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private final IDepartmentService service;

    public DepartmentController(IDepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponse> create(
            @RequestBody DepartmentRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> findById(
            @PathVariable Long id) throws ResourceNotFoundException {

        return ResponseEntity.ok(service.findById(id));
    }
}
