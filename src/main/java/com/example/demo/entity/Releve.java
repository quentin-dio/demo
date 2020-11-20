package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Releve {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @Column(name="`index`")
    private String index;

    private long idCompteur;

    //@Column(name="idEtat")
    private long idEtat;

    public Releve() {}

    public Releve(long id, Date date, String index, long idCompteur, long idEtat) {
        this.id = id;
        this.date = date;
        this.index = index;
        this.idCompteur = idCompteur;
        this.idEtat = idEtat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public long getIdCompteur() {
        return idCompteur;
    }

    public void setIdCompteur(long idCompteur) {
        this.idCompteur = idCompteur;
    }

    public long getIdEtat() {
        return idEtat;
    }

    public void setIdEtat(long idEtat) {
        this.idEtat = idEtat;
    }
}
