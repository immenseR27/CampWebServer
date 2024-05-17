package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {
    List<Child> findByGroup(Group group);
}
