package com.example.fotowoltaika.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Data
@Entity
@Table(name = "daily_measurements")
public class DailyMeasurements {
    @Id
    private long id;
    private Date date;
    private double measurement;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userId", referencedColumnName="id")
    private User user;

}
