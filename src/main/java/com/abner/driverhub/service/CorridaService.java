package com.abner.driverhub.service;

import com.abner.driverhub.dto.CorridaDTO;
import com.abner.driverhub.model.Corrida;
import com.abner.driverhub.repository.CorridaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorridaService {

    private final CorridaRepository corridaRepository;

    public CorridaService(CorridaRepository corridaRepository) {
        this.corridaRepository = corridaRepository;

    }
    public List<Corrida> listarTodas(){
        return corridaRepository.findAll();
    }
    public Corrida cadastrar (Corrida corrida) {
        return corridaRepository.save(corrida);
    }

    public Corrida buscarPorId(Long id) {
        return corridaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corrida não encontrada"));
    }
    public Corrida atualizar(Long id, Corrida corridaAtualizada ) {
        Corrida corrida = buscarPorId(id);

        corrida.setOrigem(corridaAtualizada.getOrigem());
        corrida.setDestino(corridaAtualizada.getDestino());
        corrida.setValor (corridaAtualizada.getValor());
        corrida.setDistancia(corridaAtualizada.getDistancia());
        corrida.setPlataforma((corridaAtualizada.getPlataforma()));

        return corridaRepository.save(corrida);
    }
    public void deletar(Long id) {
        Corrida corrida = buscarPorId(id);

        corridaRepository.delete(corrida);

    }
    public String classificarCorrida(Corrida corrida) {
        if (corrida.getValorPorKm() <3) {
            return "RUIM";

        }
        if (corrida.getValorPorKm() < 4) {
            return "BOA";
        }
        return "EXCELENTE";
    }
    public CorridaDTO converterParaDTO(Corrida corrida){
        return new CorridaDTO(
                corrida.getPlataforma(),
                corrida.getValor(),
                corrida.getValorPorKm(),
                classificarCorrida(corrida)
        );
    }
    public List<CorridaDTO> listarMelhores() {

        return corridaRepository.findAll()
                .stream()
                .sorted((c1, c2) -> Double.compare(c2.getValorPorKm(), c1.getValorPorKm()))
                .map(this::converterParaDTO)
                .toList();

    }

}
