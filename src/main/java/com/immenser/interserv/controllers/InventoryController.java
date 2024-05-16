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

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> findInventory(@PathVariable("id") Long id) {
        Inventory inventory = inventoryService.findInventory(id);
        return ResponseEntity.ok(inventory);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Inventory> findInventory(@PathVariable("id") Long id, Model model) {
//        return null;
//    }

//    @GetMapping("/new")
//    public String newInventory(Model model) {
//        return null;
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("inventory") @Valid Inventory inventory, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return null;
//        }
//        return null;
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        return null;
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("inventory") @Valid Inventory inventory, BindingResult bindingResult,
//                         @PathVariable("id") Long id) {
//        if (bindingResult.hasErrors()){
//            return null;
//        }
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        return null;
//    }
}
