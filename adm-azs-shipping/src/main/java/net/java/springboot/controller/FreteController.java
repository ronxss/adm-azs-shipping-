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

    //Rota:
    // /find/{filter}?page=0&size=10
    @GetMapping("/find/{filter}")
    @ResponseBody
    public ResponseEntity <List<Frete>> findByFilter(
            @PathVariable String filter,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        List<Frete> resultPage = freteService.findByFilter(filter, page, size);
        return ResponseEntity.ok(resultPage);
    }
    @PostMapping
    public Frete Save(@RequestBody Frete frete){
        return freteService.Save(frete);
    }

    @PutMapping("/{id}")
    public Frete updateFrete(@PathVariable Long id, @RequestBody Frete updatedFrete){
        return freteService.updateFrete(id, updatedFrete);
    }
    @DeleteMapping
    public void DeleteById(@RequestParam(name = "id") Long Id){
        freteService.DeleteById(Id);
    }

}
