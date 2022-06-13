package com.example.fotowoltaika.domain;

import com.example.fotowoltaika.domain.Instalation;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="measurements")
public class Measurement {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @ManyToOne(cascade =
            {CascadeType.
                    DETACH,CascadeType.MERGE,CascadeType.
                    REFRESH})
    @JoinColumn(name="instalation_id")
    private Instalation instalation;

    @Column(name="score")
    private Double score;

    public Instalation getInstalation() {
        return instalation;
    }

    public void setInstalation(Instalation instalation) {
        this.instalation = instalation;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name="date")
    private Date date;
}
