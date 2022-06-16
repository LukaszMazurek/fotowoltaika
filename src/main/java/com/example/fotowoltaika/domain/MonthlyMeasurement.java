/*
package com.example.fotowoltaika;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="monthlymeasurement")
public class MonthlyMeasurement {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="month")
    private Integer month;

    @Column(name="year")
    private Integer year;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getMonthlysum() {
        return monthlysum;
    }

    public void setMonthlysum(Long monthlysum) {
        this.monthlysum = monthlysum;
    }

    public Instalation getInstalation() {
        return instalation;
    }

    public void setInstalation(Instalation instalation) {
        this.instalation = instalation;
    }

    @Column(name="monthlysum")
    private Long monthlysum;

    @ManyToOne(cascade = {CascadeType.
            DETACH,CascadeType.MERGE,CascadeType.
            REFRESH})
    @JoinColumn(name="instalation_id")
    private Instalation instalation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
*/
