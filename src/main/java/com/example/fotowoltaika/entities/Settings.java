package com.example.fotowoltaika.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "settings")
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean isCalculated;
    private String location;

    @OneToOne(mappedBy = "address")
    private User user;

}
