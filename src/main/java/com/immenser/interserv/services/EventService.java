package com.immenser.interserv.services;

import com.immenser.interserv.models.Event;
import com.immenser.interserv.models.Group;
import com.immenser.interserv.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final GroupService groupService;

    public List<Event> findEventsByGroup(long groupId){
        Group group = groupService.findGroup(groupId);
        return eventRepository.findEventsByGroup(group);
    }

    public void addEvents(List<Event> events){
        eventRepository.saveAll(events);
    }

    public void deleteEvent(long id){
        eventRepository.deleteById(id);
    }
}
