package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PeriodRepository extends JpaRepository<Period, Long> {

    @Query(value = "SELECT * from Period p WHERE CURRENT_DATE BETWEEN p.start_date AND DATE(p.start_date + p.duration)",
            nativeQuery = true)
    Period findPeriodByCurrentDate();
}
