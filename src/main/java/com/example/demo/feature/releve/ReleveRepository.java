package com.example.demo.feature.releve;

import com.example.demo.entity.Releve;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReleveRepository extends CrudRepository<Releve, Long> {

    Releve findById(long id);

    List<Releve> findAll();

    Releve save(Releve releve);

    void deleteById(long id);
}
