package com.carcontrol.api.V1.service;

import com.carcontrol.api.V1.controller.dto.UsuarioDTOComSenha;
import com.carcontrol.api.V1.repository.UsuarioRepository;
import com.carcontrol.api.V1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public List<Usuario> listarUsuario(){

        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuario(String usuario){
        return usuarioRepository.findByUsuario(usuario);
    }


    public void salvarUsuario(UsuarioDTOComSenha usuarioDTO){
        Usuario usuario = Usuario.builder()
                                .nome(usuarioDTO.getNome())
                                .usuario(usuarioDTO.getUsuario())
                                .senha(usuarioDTO.getSenha())
                                .email(usuarioDTO.getEmail())
                                .build();

        usuarioRepository.save(usuario);
    }


}
