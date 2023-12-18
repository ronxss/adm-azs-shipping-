package net.java.springboot.controller;

import jakarta.persistence.Id;
import net.java.springboot.model.Frete;
import net.java.springboot.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
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
    @GetMapping({"filter"})
    public ResponseEntity <Page<Frete>> FindByFilter(
        @RequestParam(value = "filter", required = false, defaultValue = "") String filter,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size) {

        Page<Frete> resultPage = freteService.FindByFilter(filter, page, size);
        return ResponseEntity.ok(resultPage);
    }
    @PostMapping
    public Frete Save(@RequestBody Frete frete){
        return freteService.Save(frete);
    }

    @PutMapping("/id")
    public Frete Update(@RequestParam(value = "id") Long id, @RequestBody Frete frete){
        return freteService.Update(id, frete);
    }
    @DeleteMapping
    public void DeleteById(@RequestParam(name = "id") Long Id){
        freteService.DeleteById(Id);
    }

}
