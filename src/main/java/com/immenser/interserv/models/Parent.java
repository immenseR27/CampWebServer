package com.immenser.interserv.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "parent")
public class Parent extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "child_parent",
            joinColumns = @JoinColumn(name = "parent_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Child> children;

}
