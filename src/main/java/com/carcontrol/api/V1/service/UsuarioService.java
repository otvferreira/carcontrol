package com.carcontrol.api.V1.service;

import com.carcontrol.api.V1.controller.dto.UsuarioDTO;
import com.carcontrol.api.V1.controller.dto.UsuarioDTOComSenha;
import com.carcontrol.api.V1.repository.UsuarioRepository;
import com.carcontrol.api.V1.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public List<UsuarioEntity> listarTodos(){

        return usuarioRepository.findAll();
    }

    public UsuarioEntity buscar(String usuario){
        return usuarioRepository.findByUsuario(usuario)
                .orElseThrow();

    }


    public void salvar(UsuarioDTOComSenha usuarioDTO){
        UsuarioEntity usuarioEntity = UsuarioEntity.builder()
                                .nome(usuarioDTO.getNome())
                                .usuario(usuarioDTO.getUsuario())
                                .senha(usuarioDTO.getSenha())
                                .email(usuarioDTO.getEmail())
                                .build();

        usuarioRepository.save(usuarioEntity);
    }

}
