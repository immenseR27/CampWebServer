package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Employee;
import com.immenser.interserv.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
//    Group findByUser(Employee employee);
}
