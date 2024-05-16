package com.immenser.interserv.services;

import com.immenser.interserv.models.Inventory;
import com.immenser.interserv.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public Inventory findInventory(Long id) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);
        return optionalInventory.orElseThrow();
    }
}
