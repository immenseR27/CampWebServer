package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Event;
import com.immenser.interserv.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findEventsByGroup(Group group);
}