package com.carcontrol.service;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    private String email;

    public UsuarioService(Long id, String nome, String usuario, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
    }
}
