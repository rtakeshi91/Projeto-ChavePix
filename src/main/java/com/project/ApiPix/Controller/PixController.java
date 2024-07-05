package com.project.ApiPix.Controller;

import com.project.ApiPix.Entities.ChavePixJpa;
import com.project.ApiPix.Record.ChavePixDto;
import com.project.ApiPix.Service.ChavePixService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pixController")
public class PixController {
    @Autowired
    private ChavePixService service;

    @PostMapping
    public ResponseEntity<ChavePixJpa> criarChavePix(@Valid @RequestBody ChavePixJpa chavePix) {
        ChavePixJpa novaChavePix = service.criarChavePix(chavePix);
        return ResponseEntity.ok(novaChavePix);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChavePixJpa> alterarChavePix(@PathVariable Long id, @Valid @RequestBody ChavePixJpa novaChavePix) {
        ChavePixJpa chavePixAtualizada = service.alterarChavePix(id, novaChavePix);
        return ResponseEntity.ok(chavePixAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> inativarChavePix(@PathVariable Long id) {
        service.inativarChavePix(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChavePixJpa> consultarChavePixPorId(@PathVariable Long id) {
        ChavePixJpa chavePix = service.consultarChavePixPorId(id);
        return ResponseEntity.ok(chavePix);
    }

    @GetMapping("/por-agencia-conta")
    public ResponseEntity<List<ChavePixJpa>> consultarChavePixPorAgenciaConta(@RequestParam int agencia, @RequestParam int conta) {
        List<ChavePixJpa> chavesPix = service.consultarChavePixPorAgenciaConta(agencia, conta);
        return ResponseEntity.ok(chavesPix);
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<ChavePixJpa>> consultarChavePixPorNomeCorrentista(@RequestParam String nome) {
        List<ChavePixJpa> chavesPix = service.consultarChavePixPorNomeCorrentista(nome);
        return ResponseEntity.ok(chavesPix);
    }

}
