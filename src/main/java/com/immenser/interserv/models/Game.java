package com.immenser.interserv.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
//    private boolean young;
//    private boolean middle;
//    private boolean old;
    private int hoursdur;
    private int minsdur;
    private String inventory;
    private String description;
    private String legend;
    private String modification;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "game_age",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "age_id")
    )
    private List<Age> ages;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "games")
    private List<Type> types;





}
