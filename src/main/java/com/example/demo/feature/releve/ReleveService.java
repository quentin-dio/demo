package com.example.demo.feature.releve;

import com.example.demo.entity.Releve;
import com.example.demo.feature.compteur.DTO.CompteurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component("ReleveService")
public class ReleveService {

    @Autowired
    private ReleveRepository repository;

    public Releve getReleveById(long id) {
        return repository.findById(id);
    }

    public List<Releve> getAllReleves() {
        return repository.findAll();
    }

    public Releve saveReleve(Releve releve) {
        return repository.save(releve);
    }

    public void deleteReleveById(long id) {
        repository.deleteById(id);
    }
}
