package com.example.demo.feature.compteur;

import com.example.demo.entity.Compteur;

import com.example.demo.feature.compteur.DTO.CompteurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CompteurController {

    @Autowired
    private CompteurService cptService;

    @GetMapping("/compteurs/{id}")
    public Compteur getCompteur(@PathVariable long id) {
        return cptService.getCompteurById(id);
    }

    @GetMapping("/compteurs")
    public List<Compteur> getCompteurs() {
        return cptService.getAllCompteurs();
    }

    @PostMapping("/compteurs")
    @ResponseBody
    public Compteur saveCompteur(@RequestBody Compteur compteur) {
        return cptService.saveCompteur(compteur);
    }

    @DeleteMapping("/compteurs/{id}")
    public void deleteCompteurById(@PathVariable long id) {
        cptService.deleteCompteurById(id);
    }

    @GetMapping("/compteurs/releves/{id}")
    public Set<CompteurDTO> getCompteurWithRelevesById(@PathVariable long id) {
        return cptService.getCompteursByEtatReleve(id);
    }
}
