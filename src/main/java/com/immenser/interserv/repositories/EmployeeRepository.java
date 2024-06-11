package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Age;
import com.immenser.interserv.models.Employee;
import com.immenser.interserv.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    List<Employee> findEmployeesByJobsAndPosition(List<Job> job, String position);
    List<Employee> findEmployeesByJobsAndAgesAndPosition(List<Job> jobs, Age age, String position);
}
