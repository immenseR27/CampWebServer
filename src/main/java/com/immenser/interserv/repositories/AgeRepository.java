package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Age;
import com.immenser.interserv.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgeRepository extends JpaRepository<Age, Long> {
    List<Age> findAgesByEmployees(Employee employee);
}
