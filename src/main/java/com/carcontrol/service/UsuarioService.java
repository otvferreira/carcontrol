package com.carcontrol.service;

import com.carcontrol.controller.dto.UsuarioDTO;
import com.carcontrol.entity.usuario.UsuarioEntity;
import com.carcontrol.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
