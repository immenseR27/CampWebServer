package com.immenser.interserv.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "group_activity")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private int start_hours;
    private int start_mins;
    private int end_hours;
    private int end_mins;
    private String note;

    @ManyToOne()
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne()
    @JoinColumn(name = "activity_id")
    private Activity activity;
}
