package net.java.springboot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.java.springboot.model.Frete;
import net.java.springboot.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
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
    public List<Frete> FindByFilter(String filter){
        return freteRepository.FindByFilter(filter);
    }
    public void DeleteById(Long Id){
        freteRepository.deleteById(Id);
    }

//    public Frete Update(FreteDTO freteDTO){
//        if (freteDTO.getId() != null) {
//            freteDTO = freteRepository.save(freteDTO);
//        }
//        return frete;
// }
}
