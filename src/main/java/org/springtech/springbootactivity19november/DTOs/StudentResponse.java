package org.springtech.springbootactivity19november.DTOs;

public record StudentResponse(
        long id,
        String firstName,
        String lastName,
        String email,
        Long departmentId
) {
}
