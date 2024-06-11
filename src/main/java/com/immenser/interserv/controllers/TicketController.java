package com.immenser.interserv.controllers;

import com.immenser.interserv.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PatchMapping("/set")
    void setGroupToChildOnPeriod(@RequestParam("childId") long childId, @RequestParam("periodId") long periodId, @RequestBody long groupId) {
        ticketService.setGroupToChildOnPeriod(childId, periodId, groupId);
    }

    @PatchMapping("/reset")
    void resetGroupsInPeriod(@RequestParam("periodId") long periodId){
        ticketService.resetGroupsInPeriod(periodId);
    }
}
