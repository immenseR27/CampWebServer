package com.immenser.interserv.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotEmpty(message = "Введите название!")
//    @Size(min = 3, max = 30, message = "В названии должно быть не менее 3 и не более 30 символов")
    private String name;

    @ManyToOne
    private Child owner;


    // @Min
    // @Email

}
