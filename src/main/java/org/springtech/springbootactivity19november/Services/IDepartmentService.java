package org.springtech.springbootactivity19november.Services;

import org.springtech.springbootactivity19november.DTOs.DepartmentRequest;
import org.springtech.springbootactivity19november.DTOs.DepartmentResponse;
import org.springtech.springbootactivity19november.Exceptions.ResourceNotFoundException;

import java.util.List;

public interface IDepartmentService {
    DepartmentResponse create(DepartmentRequest request);

    List<DepartmentResponse> findAll();

    DepartmentResponse findById(Long id) throws ResourceNotFoundException;
}
