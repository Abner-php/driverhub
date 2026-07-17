package com.abner.driverhub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "corridas")
public class Corrida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo origem é obrigatório")
    private String origem;

    @NotBlank(message = "O campo destino é obrigatório")
    private String destino;

    @NotNull(message = "O campo valor é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    private Double valor;

    @NotNull(message = "O campo distância é obrigatório")
    @Positive(message = "A distância deve ser maior que zero")
    private Double distancia;

    @NotBlank(message = "O campo plataforma é obrigatório")
    @Pattern(regexp = "Uber|99|inDrive", message = "Plataforma deve ser Uber, 99 ou inDrive")
    private String plataforma;

    public Double getValorPorKm() {
        return valor / distancia;
    }
}