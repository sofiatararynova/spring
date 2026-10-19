package ru.kafpin.prakti1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kafpin.prakti1.CarOwner;

public interface CarOwnerRepository extends CrudRepository<CarOwner, Long> {
}
