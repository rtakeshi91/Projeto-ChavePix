package com.project.ApiPix.Repository;

import com.project.ApiPix.Entities.ChavePixJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChavePixRepository extends JpaRepository<ChavePixJpa, Long> {
    boolean existsByValorChave(String valorChave);
    List<ChavePixJpa> findByNumeroAgenciaAndNumeroConta(int numeroAgencia, int numeroConta);
    List<ChavePixJpa> findByNomeCorrentista(String nomeCorrentista);
}
