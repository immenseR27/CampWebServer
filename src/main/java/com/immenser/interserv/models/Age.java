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
    String name;

    @OneToMany(mappedBy = "age")
    private List<Group> groups;

    @ManyToMany(mappedBy = "ages")
    private List<Game> games;

    @ManyToMany(mappedBy = "ages")
    private List<Game> activities;

    @ManyToMany(mappedBy = "ages")
    private List<Employee> employees;
}
