package com.carcontrol.api.V1.controller.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class VeiculoDTO {
    private UUID id;
    private String modelo;
    private String marca;
    private String placa;
    private Long km_atual;
}
