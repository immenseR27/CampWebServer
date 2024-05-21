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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "age")
public class Age {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "age")
    private List<Group> groups;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "ages")
    private List<Game> games;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "ages")
    private List<Game> activities;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "ages")
    private List<Employee> employees;
}
