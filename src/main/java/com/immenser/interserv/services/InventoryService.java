package com.immenser.interserv.services;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.models.Inventory;
import com.immenser.interserv.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ChildService childService;

    public Inventory findInventory(long id) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);
        return optionalInventory.orElseThrow();
    }

    public void setOwner(long id, long childId) {
        Inventory inventory = findInventory(id);
        Child child = childService.findChild(childId);
        inventory.setChild(child);
        inventoryRepository.save(inventory);
    }

    public void resetOwner(long id) {
        Inventory inventory = findInventory(id);
        inventory.setChild(null);
        inventoryRepository.save(inventory);
    }

    public List<Inventory> findInventoryByChild(long childId) {
        Child child = childService.findChild(childId);
        return inventoryRepository.findInventoryByChild(child);
    }
}
