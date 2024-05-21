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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "age_id")
    private Age age;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "group")
    private ChildPeriod childPeriod;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "group")
    private EmployeePeriod employeePeriod;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private List<GroupActivity> activities;


}
