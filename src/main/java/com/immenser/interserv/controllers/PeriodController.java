package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Period;
import com.immenser.interserv.services.PeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periods")
@RequiredArgsConstructor
public class PeriodController {

    private final PeriodService periodService;

    @GetMapping
    public List<Period> findAllPeriods(){
        return periodService.findAllPeriods();
    }

    @PostMapping
    public void addPeriod(@RequestBody Period period){
        periodService.addPeriod(period);
    }

    @DeleteMapping
    public void deletePeriod(@PathVariable long id){
        periodService.deletePeriod(id);
    }
}
