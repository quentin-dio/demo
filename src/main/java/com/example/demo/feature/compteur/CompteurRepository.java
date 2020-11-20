package com.example.demo.feature.compteur;

import com.example.demo.entity.Compteur;
import com.example.demo.feature.compteur.DTO.CompteurDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CompteurRepository extends CrudRepository<Compteur, Long> {

    Compteur findById(long id);

    List<Compteur> findAll();

    Compteur save(Compteur compteur);

    void deleteById(long id);

    @Query(value = "SELECT cpt.serial, rlv.index, rlv.date FROM compteur cpt INNER JOIN releve rlv ON rlv.id_compteur = cpt.id INNER JOIN etat e ON rlv.id_etat = e.id WHERE e.id = :idEtat", nativeQuery = true)
    public List<Object> findCompteursByEtatReleve(@Param("idEtat") long idEtat);
}
