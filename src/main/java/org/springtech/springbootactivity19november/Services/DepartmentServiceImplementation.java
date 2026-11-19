package org.springtech.springbootactivity19november.Services;

import org.springtech.springbootactivity19november.DTOs.DepartmentRequest;
import org.springtech.springbootactivity19november.DTOs.DepartmentResponse;
import org.springtech.springbootactivity19november.Entities.Department;
import org.springtech.springbootactivity19november.Exceptions.ResourceNotFoundException;
import org.springtech.springbootactivity19november.Repository.DepartmentRepository;

import java.util.List;

public class DepartmentServiceImplementation implements IDepartmentService{
    private final DepartmentRepository repository;

    public DepartmentServiceImplementation(
            DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public DepartmentResponse create(
            DepartmentRequest request) {

        Department department = new Department(
                request.name(),
                request.description()
        );

        Department saved = repository.save(department);

        return mapToResponse(saved);
    }

    @Override
    public List<DepartmentResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public DepartmentResponse findById(Long id) throws ResourceNotFoundException {

        Department department = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found: " + id
                        ));

        return mapToResponse(department);
    }

    private DepartmentResponse mapToResponse(
            Department department) {

        return new DepartmentResponse(
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }
}
