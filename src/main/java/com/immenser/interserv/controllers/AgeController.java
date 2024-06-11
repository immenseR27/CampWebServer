package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Age;
import com.immenser.interserv.services.AgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ages")
@RequiredArgsConstructor
public class AgeController {

    private final AgeService ageService;

    @GetMapping
    List<Age> findAgesByEmployee(@RequestParam("employeeId") long employeeId){
        return ageService.findAgesByEmployee(employeeId);
    }
}
