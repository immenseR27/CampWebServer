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
@Table(name = "employee")
public class Employee extends Person{

    private String email;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private List<EmployeePeriod> appointments;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_age",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "age_id")
    )
    private List<Age> ages;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "group_id", nullable = false)
//    @JsonBackReference
//    private Group group;
////    private String firstName;
////    private String lastName;
////    private String middleName;
}