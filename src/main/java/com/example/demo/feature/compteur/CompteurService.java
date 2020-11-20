package com.example.demo.feature.compteur;

import com.example.demo.entity.Compteur;
import com.example.demo.feature.compteur.DTO.CompteurDTO;
import com.example.demo.feature.compteur.DTO.ReleveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.*;

@Component("CompteurService")
public class CompteurService {

    @Autowired
    private CompteurRepository repository;

    public Compteur getCompteurById(long id) {
        return repository.findById(id);
    }

    public List<Compteur> getAllCompteurs() {
        return repository.findAll();
    }

    public Compteur saveCompteur(Compteur compteur) {
        return repository.save(compteur);
    }

    public void deleteCompteurById(long id) {
        repository.deleteById(id);
    }

    public Set<CompteurDTO> getCompteursByEtatReleve(long idEtat) {

        List<Object> compteursByEtatReleve = repository.findCompteursByEtatReleve(idEtat);

        Set<CompteurDTO> formatedCompteurs = new HashSet<CompteurDTO>();
        Iterator<CompteurDTO> itr = formatedCompteurs.iterator();
        // parcours de la liste d'objets (un objet = 1 ligne de la native query)
        for(Object cpt: compteursByEtatReleve) {
            // cast d'un objet en tableau d'objets
            Object[] cptArray = (Object[]) cpt;
            long serial = ((BigInteger) cptArray[0]).intValue();
            String index = (String) cptArray[1];
            Date date = (Date) cptArray[2];

            // vérification compteurDTO dans le set de compteurDTO
            Boolean cptAlreadyInSet = false;
            CompteurDTO cptToAddReleveDTO = null;
            while(itr.hasNext()) {
                if(itr.next().getSerial() == serial) {
                    cptAlreadyInSet = true;
                    cptToAddReleveDTO = itr.next();
                }
            }

            if (cptAlreadyInSet) {
                // ajout de releveDTO dans le set releveDTO du compteurDTO
                Set<ReleveDTO> releves = cptToAddReleveDTO.getReleves();
            } else {
                // création compteurDTO avec son set releveDTO
                CompteurDTO compteurDTO = new CompteurDTO(serial);
                Set<ReleveDTO> releves = new HashSet<ReleveDTO>();
                releves.add(new ReleveDTO(index, date));
                compteurDTO.setReleves(releves);

                formatedCompteurs.add(compteurDTO);
            }
        }
        return formatedCompteurs;
    }
}
