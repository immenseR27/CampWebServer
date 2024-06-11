package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Group;
import com.immenser.interserv.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public  void addGroup(@RequestBody Group group){
        groupService.addGroup(group);
    }

    @GetMapping
    public List<Group> getGroupsByPeriod(@RequestParam("periodId") long periodId){
        return groupService.findGroupsByPeriod(periodId);
    }

    @GetMapping("/child_group")
    public Group getGroupByChildAndPeriod(@RequestParam("childId") long childId, @RequestParam("periodId") long periodId){
        return groupService.findGroupByChildAndPeriod(childId, periodId);
    }

    @GetMapping("/age_groups")
    public List<Group> getGroupsByPeriodAndAge(@RequestParam("periodId") long periodId, @RequestParam("ageId") long ageId){
        return groupService.findGroupsByPeriodAndAge(periodId, ageId);
    }
}
