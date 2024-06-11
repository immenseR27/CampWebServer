package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Age;
import com.immenser.interserv.models.Group;
import com.immenser.interserv.models.Job;
import com.immenser.interserv.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findGroupByTickets(Ticket ticket);
    List<Group> findGroupsByTicketsAndAge(List<Ticket> tickets, Age age);
    List<Group> findGroupsByTickets(List<Ticket> tickets);
    Group findGroupByJobs(Job job);
}
