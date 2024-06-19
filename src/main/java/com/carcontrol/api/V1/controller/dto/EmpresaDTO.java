package com.carcontrol.api.V1.controller.dto;

import lombok.Data;

@Data
public class EmpresaDTO {
    private Long id;
    private String nome;
    private String razao;
    private String cnpj;
    private String telefone;
    private String email;
    private String endereco;
    private String site;
}
