package com.immenser.interserv.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private List<User> user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    @JsonManagedReference
    private List<Child> children;

//    public Group(User user, List<Child> children) {
//        this.user = user;
//        this.children = children;
//    }
}
