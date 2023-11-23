package com.carcontrol.controller;

import com.carcontrol.controller.dto.UsuarioDTO;
import com.carcontrol.repository.UsuarioRepository;
import com.carcontrol.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioRepository repository;

    private ResponseEntity<Object> salvar(@RequestBody UsuarioDTO usuario){
        service.salvar(usuario);

        return ResponseEntity.ok("Usuário criado com sucesso.");
    }
}
