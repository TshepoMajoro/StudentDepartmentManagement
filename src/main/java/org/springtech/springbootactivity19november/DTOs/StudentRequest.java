package org.springtech.springbootactivity19november.DTOs;

public record StudentRequest (
        String firstName,
        String lastName,
        String email,
        Long departmentId
) {
}
