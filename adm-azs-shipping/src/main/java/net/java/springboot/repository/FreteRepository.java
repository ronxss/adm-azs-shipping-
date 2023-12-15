package net.java.springboot.repository;

import net.java.springboot.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreteRepository extends PagingAndSortingRepository<Frete, Long>, JpaRepository<Frete, Long> {
    @Query(value = "select * from fretes f " +
                   "where f.cliente like '%?1%' " +
                   "or f.cubagem like '%?1%' " +
                   "or f.endereco_origem like '?%1'" +
                   "or f.endereco_destino like '?%1'" +
                   "or f.peso like '?%1'", nativeQuery = true)
    public List <Frete> FindByFilter(String filter);
}
