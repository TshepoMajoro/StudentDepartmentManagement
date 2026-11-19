package org.springtech.springbootactivity19november.Services;

import org.springtech.springbootactivity19november.DTOs.StudentRequest;
import org.springtech.springbootactivity19november.DTOs.StudentResponse;
import org.springtech.springbootactivity19november.Exceptions.ResourceNotFoundException;

import java.util.List;

public interface IStudentService {
    StudentResponse create(StudentRequest request) throws ResourceNotFoundException;

    List<StudentResponse> findAll();

    StudentResponse findById(Long id) throws ResourceNotFoundException;

    List<StudentResponse> findByDepartment(Long departmentId) throws ResourceNotFoundException;
}
