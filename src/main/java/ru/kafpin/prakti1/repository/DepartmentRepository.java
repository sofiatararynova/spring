package ru.kafpin.prakti1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kafpin.prakti1.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
