package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Compteur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private long serial;

    @OneToMany(mappedBy="idCompteur")
    private Collection<Releve> releves;

    public Compteur() {}

    public Compteur(long id, long serial, Collection<Releve> releves, long idEtat) {
        this.id = id;
        this.serial = serial;
        this.releves = releves;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSerial() {
        return serial;
    }

    public void setSerial(long serial) {
        this.serial = serial;
    }

    public Collection<Releve> getReleves() {
        return releves;
    }

    public void setReleves(Collection<Releve> releves) {
        this.releves = releves;
    }
}
