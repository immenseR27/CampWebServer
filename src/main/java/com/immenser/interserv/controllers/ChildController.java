package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.services.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/children")
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;

    @GetMapping
    public List<Child> findAll() {
        return childService.findAll();
    }

//    @GetMapping("/{id}")
//    public List<Child> findByUser(@PathVariable Long id) {
//        return childService.findByUser(id);
//    }

//    @GetMapping("/{id}")
//    public Child findChild(@PathVariable Long id) {
//        return childService.findChild(id);
//    }

}
