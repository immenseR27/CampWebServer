package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Group;
import com.immenser.interserv.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByUser(User user);
}
