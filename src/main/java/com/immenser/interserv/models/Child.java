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
//@NoArgsConstructor
@Table(name = "child")
public class Child extends Person {


//    private String name;

}
