package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Employee;
import com.immenser.interserv.models.Group;
import com.immenser.interserv.models.Job;
import com.immenser.interserv.models.Period;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findJobsByGroup(Group group);
    List<Job> findJobsByPeriod(Period period);
    Job findJobByEmployeeAndPeriod(Employee employee, Period period);
}
