package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Activity;
import com.immenser.interserv.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping("/{id}")
    public Activity findActivity(@PathVariable long id){
        return activityService.findActivity(id);
    }

    @GetMapping()
    public List<Activity> findActivitiesByAge(@RequestParam long ageId){
        return activityService.findActivitiesByAge(ageId);
    }
}
