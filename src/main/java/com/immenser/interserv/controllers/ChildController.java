package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.services.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/children")
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;

    @GetMapping("/group_list")
    List<Child> findChildrenByGroup(@RequestParam("groupId") long groupId) {
        return childService.findChildrenByGroup(groupId);
    }

    @GetMapping("/period_list")
    List<Child> findChildrenByPeriod(@RequestParam("periodId") long periodId) {
        return childService.findChildrenByPeriod(periodId);
    }

    @GetMapping("/my_group")
    List<Child> findChildrenByEmployee(@RequestParam("employeeId") long employeeId) {
        return childService.findChildrenByEmployee(employeeId);
    }

}
