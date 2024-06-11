package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.models.Group;
import com.immenser.interserv.models.Period;
import com.immenser.interserv.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket findTicketByChildAndPeriod(Child child, Period period);
    List<Ticket> findTicketsByPeriod(Period period);
    List<Ticket> findTicketsByGroup(Group group);
}
