package com.example.demo.feature.compteur.DTO;

import java.util.Date;

public class ReleveDTO {

    private String index;

    private Date date;

    public ReleveDTO() {};

    public ReleveDTO(String index, Date date) {
        this.index = index;
        this.date = date;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
