package com.immenser.interserv.services;

import com.immenser.interserv.models.Employee;
import com.immenser.interserv.models.Group;
import com.immenser.interserv.models.Job;
import com.immenser.interserv.models.Period;
import com.immenser.interserv.repositories.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = {@Lazy})
public class JobService {

    private final JobRepository jobRepository;
    private final EmployeeService employeeService;
    private final PeriodService periodService;
    private final GroupService groupService;

    public List<Job> findJobsByGroup(long groupId){
        Group group = groupService.findGroup(groupId);
        return jobRepository.findJobsByGroup(group);
    }

    public void setGroupToEmployeeOnPeriod(long employeeId, long periodId, long groupId) {
        Group group = groupService.findGroup(groupId);
        updateGroupToEmployeeOnPeriod(employeeId, periodId, group);
    }

    public void resetGroupToEmployeeOnPeriod(long employeeId, long periodId) {
        updateGroupToEmployeeOnPeriod(employeeId, periodId, null);
    }

    public void updateGroupToEmployeeOnPeriod(long employeeId, long periodId, Group group){
        Job job = findJobByEmployeeAndPeriod(employeeId, periodId);
        job.setGroup(group);
        jobRepository.save(job);
    }

    public Job findJobByEmployeeAndCurrentPeriod(long employeeId) {
        Employee employee = employeeService.findEmployee(employeeId);
        Period period = periodService.findCurrentPeriod();
        return jobRepository.findJobByEmployeeAndPeriod(employee, period);
    }

    public Job findJobByEmployeeAndPeriod(long employeeId, long periodId){
        Employee employee = employeeService.findEmployee(employeeId);
        Period period = periodService.findPeriod(periodId);
        return jobRepository.findJobByEmployeeAndPeriod(employee, period);
    }

    public List<Job> findJobsByPeriod(long periodId) {
        Period period = periodService.findPeriod(periodId);
        return jobRepository.findJobsByPeriod(period);
    }
}
