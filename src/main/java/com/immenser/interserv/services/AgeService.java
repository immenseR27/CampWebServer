package com.immenser.interserv.services;

import com.immenser.interserv.models.Age;
import com.immenser.interserv.models.Employee;
import com.immenser.interserv.repositories.AgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AgeService {

    private final AgeRepository ageRepository;
    private final EmployeeService employeeService;

    public Age findAge(long id) {
        Optional<Age> optionalAge = ageRepository.findById(id);
        return optionalAge.orElseThrow();
    }

    public List<Age> findAgesByEmployee(long employeeId) {
        Employee employee = employeeService.findEmployee(employeeId);
        return ageRepository.findAgesByEmployees(employee);
    }
}
