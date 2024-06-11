package com.immenser.interserv.services;

import com.immenser.interserv.models.Period;
import com.immenser.interserv.repositories.PeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeriodService {
    private final PeriodRepository periodRepository;

    public Period findPeriod(long id){
        Optional<Period> optionalPeriod = periodRepository.findById(id);
        return optionalPeriod.orElseThrow();
    }

    public List<Period> findAllPeriods(){
        return periodRepository.findAll(Sort.by(Sort.Order.asc("start_date")));
    }

    public void addPeriod(Period period){
        periodRepository.save(period);
    }

    public void deletePeriod(long id) {
        periodRepository.deleteById(id);
    }

    public Period findCurrentPeriod() {
        return periodRepository.findPeriodByCurrentDate();
    }
}
