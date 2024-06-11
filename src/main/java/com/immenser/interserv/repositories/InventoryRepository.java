package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findInventoryByChild(Child child);
}
