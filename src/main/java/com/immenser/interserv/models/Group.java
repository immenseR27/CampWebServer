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
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Child> children;

    public Group(User user, List<Child> children) {
        this.user = user;
        this.children = children;
    }
}
