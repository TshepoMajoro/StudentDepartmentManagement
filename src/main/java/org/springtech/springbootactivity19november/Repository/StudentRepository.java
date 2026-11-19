package org.springtech.springbootactivity19november.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springtech.springbootactivity19november.Entities.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByDepartmentId(long departmentId);
}
