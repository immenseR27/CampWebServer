package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Parent;
import com.immenser.interserv.services.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;

    @GetMapping
    public List<Parent> findParentsByChild(@RequestParam("childId") long childId) {
        return parentService.findParentsByChild(childId);
    }
}
