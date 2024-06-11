package com.immenser.interserv.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "period")
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date start_date;
    private int duration;
    private int young;
    private int middle;
    private int old;
    private int price;

    @OneToMany(mappedBy = "period")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "period")
    private List<Job> jobs;
}
