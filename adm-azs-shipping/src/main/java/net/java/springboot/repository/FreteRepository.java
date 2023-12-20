package net.java.springboot.repository;

import net.java.springboot.model.Frete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreteRepository extends PagingAndSortingRepository<Frete, Long>, JpaRepository<Frete, Long> {
    @Query(value = "select * from fretes f " +
                   "where f.cliente like %:filter% " +
                   "or f.cubagem like  %:filter% " +
                   "or f.endereco_origem like  %:filter% " +
                   "or f.endereco_destino like  %:filter% " +
                   "or f.peso like  %:filter%", nativeQuery = true)
    Page<Frete> findByFilter(@Param("filter") String filter, Pageable pageable);
}
