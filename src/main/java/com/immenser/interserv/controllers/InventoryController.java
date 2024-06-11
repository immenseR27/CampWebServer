package com.immenser.interserv.controllers;

import ch.qos.logback.core.model.Model;
import com.immenser.interserv.models.Inventory;
import com.immenser.interserv.services.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{id}")
    public Inventory findInventory(@PathVariable("id") long id){
        return inventoryService.findInventory(id);
    }

    @PatchMapping("/{id}/set")
    public void setOwner(@PathVariable("id") long id, @RequestBody long childId){
        inventoryService.setOwner(id, childId);
    }

    @PatchMapping("/{id}/reset")
    public void resetOwner(@PathVariable("id") long id){
        inventoryService.resetOwner(id);
    }

    @GetMapping
    public List<Inventory> findInventoryByChild(@RequestParam("childId") long childId){
        return inventoryService.findInventoryByChild(childId);
    }
}
