package com.immenser.interserv.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "child_period")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "child_id")
    private Child child;

    @ManyToOne()
    @JoinColumn(name = "period_id")
    private Period period;

    @ManyToOne()
    @JoinColumn(name = "group_id")
    private Group group;
}
