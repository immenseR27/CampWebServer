package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Event;
import com.immenser.interserv.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public List<Event> findEventsByGroup(@RequestParam("groupId") long groupId){
        return eventService.findEventsByGroup(groupId);
    }

    @PostMapping
    public void addEvents(@RequestBody List<Event> events){
        eventService.addEvents(events);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") long id) {
        eventService.deleteEvent(id);
    }
}
