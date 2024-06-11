package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {
    @Query("SELECT c FROM Child c JOIN Ticket t ON c.id = t.child.id WHERE t IN :tickets")
    List<Child> findChildrenByTickets(@Param("tickets") List<Ticket> tickets);
}
