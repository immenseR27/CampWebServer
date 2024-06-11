package com.immenser.interserv.controllers;

import com.immenser.interserv.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PatchMapping("/set")
    void setGroupToEmployeeOnPeriod(@RequestParam("employeeId") long employeeId,
                                    @RequestParam("periodId") long periodId,
                                    @RequestParam("groupId") long groupId) {
        jobService.setGroupToEmployeeOnPeriod(employeeId, periodId, groupId);
    }

    @PatchMapping("/reset")
    void resetGroupToEmployeeOnPeriod(@RequestParam("employeeId") long employeeId,
                                    @RequestParam("periodId") long periodId) {
        jobService.resetGroupToEmployeeOnPeriod(employeeId, periodId);
    }
}
