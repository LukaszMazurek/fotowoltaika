package com.example.fotowoltaika;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "secondname")
    private String secondname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    @OneToOne(cascade = CascadeType.
            ALL)
    @JoinColumn(name="user_settings_id")
    @RestResource(path = "settings", rel="settings")
    private Settings settings;

    public List<Instalation> getInstalationList() {
        return instalationList;
    }

    public void setInstalationList(List<Instalation> instalationList) {
        this.instalationList = instalationList;
    }

    @OneToMany(mappedBy = "user",cascade =
            {CascadeType.
                    DETACH,CascadeType.MERGE,CascadeType.
                    PERSIST,CascadeType.
                    REFRESH},fetch = FetchType.EAGER)
    private List<Instalation> instalationList;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
