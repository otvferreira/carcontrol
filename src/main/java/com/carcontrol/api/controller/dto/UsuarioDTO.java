package com.carcontrol.api.controller.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    private String email;

    public UsuarioDTO(Long id, String nome, String usuario, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
    }
}
