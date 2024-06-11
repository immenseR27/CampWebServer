package com.immenser.interserv.services;

import com.immenser.interserv.models.Age;
import com.immenser.interserv.models.Employee;
import com.immenser.interserv.models.Job;
import com.immenser.interserv.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final JobService jobService;
    private final AgeService ageService;

    public Employee findEmployee(Long id) {
        Optional<Employee> optionalUser = employeeRepository.findById(id);
        return optionalUser.orElseThrow();
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> findEmployeesByGroupAndPosition(long groupId, String position) {
        List<Job> jobs = jobService.findJobsByGroup(groupId);
        return employeeRepository.findEmployeesByJobsAndPosition(jobs, position);
    }

    public List<Employee> findFreeEmployeesByPeriodAndAgeAndPosition(long periodId, long ageId,  String position){
        List<Job> jobs = jobService.findJobsByPeriod(periodId);
        Age age = ageService.findAge(ageId);
        return employeeRepository.findEmployeesByJobsAndAgesAndPosition(jobs, age, position);
    }
}