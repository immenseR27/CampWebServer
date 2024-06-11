package com.immenser.interserv.services;

import com.immenser.interserv.models.Activity;
import com.immenser.interserv.models.Age;
import com.immenser.interserv.repositories.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final AgeService ageService;

    public Activity findActivity(Long id) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        return optionalActivity.orElseThrow();
    }

    public List<Activity> findActivitiesByAge(Long ageId) {
        Age age = ageService.findAge(ageId);
        return activityRepository.findActivitiesByAges(age);
    }
}
