package ru.kafpin.prakti1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kafpin.prakti1.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}