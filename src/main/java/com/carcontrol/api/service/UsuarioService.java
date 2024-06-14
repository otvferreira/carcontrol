package com.carcontrol.api.service;

import com.carcontrol.api.controller.dto.UsuarioDTO;
import com.carcontrol.api.repository.UsuarioRepository;
import com.carcontrol.api.entity.usuario.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void salvar(UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = UsuarioEntity.builder()
                                .nome(usuarioDTO.getNome())
                                .usuario(usuarioDTO.getUsuario())
                                .senha(usuarioDTO.getSenha())
                                .email(usuarioDTO.getEmail())
                                .build();

        usuarioRepository.save(usuarioEntity);
    }

    public List<UsuarioEntity> buscarTodos(){
        return usuarioRepository.findAll();
    }
}
