package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
//    Inventory findInventoryById(Long id);
}
