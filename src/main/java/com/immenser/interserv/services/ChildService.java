package com.immenser.interserv.services;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.models.Group;
import com.immenser.interserv.models.Ticket;
import com.immenser.interserv.repositories.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChildService {
    private final ChildRepository childRepository;
    private final TicketService ticketService;
    private final GroupService groupService;


    public Child findChild(long id){
        Optional<Child> optionalChild = childRepository.findById(id);
        return optionalChild.orElseThrow();
    }

    public List<Child> findChildrenByGroup(long groupId){
        List<Ticket> tickets = ticketService.findTicketsByGroup(groupId);
        return childRepository.findChildrenByTickets(tickets);
    }

    public List<Child> findChildrenByPeriod(long periodId){
        List<Ticket> tickets = ticketService.findTicketsByPeriod(periodId);
        return childRepository.findChildrenByTickets(tickets);
    }

    public List<Child> findChildrenByEmployee(long employeeId) {
        Group group = groupService.findGroupByEmployee(employeeId);
        return findChildrenByGroup(group.getId());
    }
}
