package com.abner.driverhub.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class CorridaDTO {
    private String plataforma;
    private Double valor;
    private Double valorPorKm;
    private String classificacao;

}
