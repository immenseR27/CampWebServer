package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Activity;
import com.immenser.interserv.models.Age;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findActivitiesByAges(Age age);
}
