package com.project.ApiPix.Service;

import com.project.ApiPix.Entities.ChavePixJpa;
import com.project.ApiPix.Repository.ChavePixRepository;
import com.project.ApiPix.Validador.ChavePixValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ChavePixService {

    @Autowired
    private ChavePixRepository repository;
    @Autowired
    private ChavePixValidator validator;

    public ChavePixJpa criarChavePix(ChavePixJpa chavePix) {
        if (repository.existsByValorChave(chavePix.getValorChave())) {
            throw new IllegalArgumentException("Chave Pix já existe");
        }
        chavePix.setDataHoraInclusao(LocalDateTime.now());
        return repository.save(chavePix);
    }

    public ChavePixJpa alterarChavePix(Long id, ChavePixJpa novaChavePix) {
        ChavePixJpa chaveExistente = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Chave Pix não encontrada"));

        chaveExistente.setTipoConta(novaChavePix.getTipoConta());
        chaveExistente.setAgencia(novaChavePix.getAgencia());
        chaveExistente.setConta(novaChavePix.getConta());
        chaveExistente.setNome(novaChavePix.getNome());
        chaveExistente.setSobrenome(novaChavePix.getSobrenome());
        return repository.save(chaveExistente);
    }

    public void inativarChavePix(Long id) {
        ChavePixJpa chaveExistente = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Chave Pix não encontrada"));
        if (chaveExistente.getDataHoraInativacao() != null) {
            throw new IllegalArgumentException("Chave Pix já está inativa");
        }
        chaveExistente.setDataHoraInativacao(LocalDateTime.now());
        repository.save(chaveExistente);
    }

    public ChavePixJpa consultarChavePixPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Chave Pix não encontrada"));
    }

    public List<ChavePixJpa> consultarChavePixPorAgenciaConta(int agencia, int conta) {
        return repository.findByNumeroAgenciaAndNumeroConta(agencia, conta);
    }

    public List<ChavePixJpa> consultarChavePixPorNomeCorrentista(String nome) {
        return repository.findByNomeCorrentista(nome);
    }
}
