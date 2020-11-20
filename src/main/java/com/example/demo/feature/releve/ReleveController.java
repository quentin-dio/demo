package com.example.demo.feature.releve;

import com.example.demo.entity.Releve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReleveController {

    @Autowired
    private ReleveService rlvService;

    @GetMapping("/releves/{id}")
    public Releve getReleve(@PathVariable long id) {
        return rlvService.getReleveById(id);
    }

    @GetMapping("/releves")
    public List<Releve> getReleves() { return rlvService.getAllReleves(); }

    @PostMapping("/releves")
    @ResponseBody
    public Releve saveReleve(@RequestBody Releve releve) { return rlvService.saveReleve(releve); }

    @DeleteMapping("/releves/{id}")
    public void deleteReleveById(@PathVariable long id) { rlvService.deleteReleveById(id); }
}
