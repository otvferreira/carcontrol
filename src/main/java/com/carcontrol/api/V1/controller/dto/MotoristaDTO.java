package com.carcontrol.api.V1.controller.dto;

import lombok.Data;

@Data
public class MotoristaDTO {
    private Long id;
    private String nome;
    private String cpfcnpj;
    private String setor;
}
