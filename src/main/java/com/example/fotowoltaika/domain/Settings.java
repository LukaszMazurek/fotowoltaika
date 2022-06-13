package com.example.fotowoltaika.domain;

import javax.persistence.*;

@Entity
@Table(name="settings")
public class Settings {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name="isautocalculated")
    private Boolean isAutoCalculated;

    @OneToOne(mappedBy ="settings",cascade = CascadeType.ALL)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAutoCalculated() {
        return isAutoCalculated;
    }

    public void setAutoCalculated(Boolean isautoCalculated) {
        this.isAutoCalculated = isautoCalculated;
    }


}
