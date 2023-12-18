package net.java.springboot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.java.springboot.model.Frete;
import net.java.springboot.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FreteService {

    @Autowired
    private FreteRepository freteRepository;
    public Frete Save(Frete frete){
        return freteRepository.save(frete);
    }
    public List<Frete> FindAll(){
        return freteRepository.findAll();
    }
    public Page<Frete> FindByFilter(String filter, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return freteRepository.FindByFilter("%" + filter + "%", pageable);
    }
    public void DeleteById(Long Id){
        freteRepository.deleteById(Id);

    }
    public Frete Update(Long id, Frete frete)  {
        if (frete.getId() != null && frete.getId().equals(id)) {
            frete = freteRepository.save(frete);
        }
        return frete;
    }
}
