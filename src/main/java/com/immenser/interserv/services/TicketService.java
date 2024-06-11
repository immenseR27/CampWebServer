package com.immenser.interserv.services;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.models.Group;
import com.immenser.interserv.models.Period;
import com.immenser.interserv.models.Ticket;
import com.immenser.interserv.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class TicketService {

    private final TicketRepository ticketRepository;
    private final ChildService childService;
    private final PeriodService periodService;
    private final GroupService groupService;

    public void setGroupToChildOnPeriod(long childId, long periodId, long groupId) {
        Ticket ticket = findTicketByChildAndPeriod(childId, periodId);
        Group group = groupService.findGroup(groupId);
        ticket.setGroup(group);
        ticketRepository.save(ticket);
    }

    public void resetGroupsInPeriod(long periodId) {
        Period period = periodService.findPeriod(periodId);
        List<Ticket> tickets = ticketRepository.findTicketsByPeriod(period);
        for (Ticket ticket : tickets) {
            ticket.setGroup(null);
        }
        ticketRepository.saveAll(tickets);
    }

    public List<Ticket> findTicketsByGroup(long groupId){
        Group group = groupService.findGroup(groupId);
        return ticketRepository.findTicketsByGroup(group);
    }

    public List<Ticket> findTicketsByPeriod(long periodId) {
        Period period = periodService.findPeriod(periodId);
        return ticketRepository.findTicketsByPeriod(period);
    }

    public Ticket findTicketByChildAndPeriod(long childId, long periodId) {
        Child child = childService.findChild(childId);
        Period period = periodService.findPeriod(periodId);
        return ticketRepository.findTicketByChildAndPeriod(child, period);
    }
}
