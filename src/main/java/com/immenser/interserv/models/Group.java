package com.immenser.interserv.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;

    @ManyToOne()
    @JoinColumn(name = "age_id")
    private Age age;

    @OneToMany(mappedBy = "group")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "group")
    private List<Job> jobs;

    @OneToMany(mappedBy = "group")
    private List<Event> activities;
}
