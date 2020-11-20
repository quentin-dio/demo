package com.example.demo.feature.compteur.DTO;

import java.util.Set;

public class CompteurDTO {

    private long serial;

    private Set<ReleveDTO> releves;

    public CompteurDTO() {};

    public CompteurDTO(long serial) {
        this.serial = serial;
        this.releves = releves;
    }

    public long getSerial() {
        return serial;
    }

    public void setSerial(long serial) {
        this.serial = serial;
    }

    public Set<ReleveDTO> getReleves() {
        return releves;
    }

    public void setReleves(Set<ReleveDTO> releves) {
        this.releves = releves;
    }
}
