package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Child;
import com.immenser.interserv.services.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/children")
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;

    @GetMapping
    public List<Child> findAll() {
        return childService.findAll();
    }

    @GetMapping("/{id}")
    public Child findChild(@PathVariable Long id) {
        return childService.findChild(id);
    }

}
