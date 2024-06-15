package com.carcontrol.api.V1.controller.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String usuario;
    private String email;

}
