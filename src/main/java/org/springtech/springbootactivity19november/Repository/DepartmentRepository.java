package org.springtech.springbootactivity19november.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springtech.springbootactivity19november.Entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
