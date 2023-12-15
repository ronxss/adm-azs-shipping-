package net.java.springboot.controller;

import jakarta.persistence.Id;
import net.java.springboot.model.Frete;
import net.java.springboot.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fretes")
public class FreteController {

    @Autowired
    private FreteService freteService;

    @GetMapping
    public List<Frete> FindAll(){
        return freteService.FindAll();
    }
    @GetMapping("/filter")
    public List<Frete> FindByFilter(@RequestParam(value ="filter") String filter){
        return freteService.FindByFilter(filter);
    }
    @PostMapping
    public Frete Save(@RequestBody Frete frete){
        return freteService.Save(frete);
    }

    @PutMapping
    public Frete Update(@RequestBody Frete frete){
        return freteService.Save(frete);
    }
    @DeleteMapping
    public void DeleteById(@RequestParam(name = "id") Long Id){
        freteService.DeleteById(Id);
    }

}
