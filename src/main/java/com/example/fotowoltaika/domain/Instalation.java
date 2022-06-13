package com.example.fotowoltaika.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="instalation")
public class Instalation {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade =
            {CascadeType.
                    DETACH,CascadeType.MERGE,CascadeType.
                    REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="powerofpanel")
    private Double powerOfPanel;

    @Column(name="amountofpanels")
    private Integer amountOfPanels;

    @Column(name="longtitude")
    private Integer longtitude;//długość geograficzna

    @Column(name = "latitude")
    private Integer latitude;//szerokość geograficzna

    @OneToMany(mappedBy = "instalation",cascade =
            {CascadeType.
                    DETACH,CascadeType.MERGE,CascadeType.
                    PERSIST,CascadeType.
                    REFRESH})
    private List<Measurement> measurement;

    public List<Measurement> getMeasurement() {
        return measurement;
    }

    public void setMeasurement(List<Measurement> measurement) {
        this.measurement = measurement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getPowerOfPanel() {
        return powerOfPanel;
    }

    public void setPowerOfPanel(Double powerOfPanel) {
        this.powerOfPanel = powerOfPanel;
    }

    public Integer getAmountOfPanels() {
        return amountOfPanels;
    }

    public void setAmountOfPanels(Integer amountOfPanels) {
        this.amountOfPanels = amountOfPanels;
    }

    public Integer getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Integer longtitude) {
        this.longtitude = longtitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }


}
