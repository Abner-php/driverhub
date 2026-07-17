package com.abner.driverhub.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.abner.driverhub.dto.CorridaDTO;
import com.abner.driverhub.model.Corrida;
import com.abner.driverhub.service.CorridaService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/corridas")
public class CorridaController {

    private final CorridaService corridaService;

    public CorridaController(CorridaService corridaService) {
        this.corridaService = corridaService;
    }

    @GetMapping
    public List<Corrida> listarCorridas() {
        return corridaService.listarTodas();
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody Corrida corrida) {
        return ResponseEntity.status(HttpStatus.CREATED).body(corridaService.cadastrar(corrida));
    }

    @GetMapping("/melhores")
    public List<CorridaDTO> listarMelhores() {
        return corridaService.listarMelhores();
    }
    @GetMapping("/{id}")
    public Corrida buscarPorId(@PathVariable Long id) {
        return corridaService.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public Corrida atualizarCorrida(@PathVariable Long id, @RequestBody Corrida corrida) {
        return corridaService.atualizar(id,corrida);
    }
    @DeleteMapping("/{id}")
    public void deletarCorrida(@PathVariable Long id) {
        corridaService.deletar(id);
    }
}