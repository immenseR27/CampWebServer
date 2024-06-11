package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    List<Parent> findParentsByChildren(Child child);
}
