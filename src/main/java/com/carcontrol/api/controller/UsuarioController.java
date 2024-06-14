package com.carcontrol.api.controller;

import com.carcontrol.api.controller.dto.UsuarioDTO;
import com.carcontrol.api.repository.UsuarioRepository;
import com.carcontrol.api.service.UsuarioService;
import com.carcontrol.api.entity.usuario.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/register")
    public ResponseEntity<Object> salvar(@RequestBody UsuarioDTO usuario){
        service.salvar(usuario);

        return ResponseEntity.ok("Usuário criado com sucesso.");
    }

    @GetMapping("/search-all")
    public List<UsuarioEntity> buscar() {
        return service.buscarTodos();
    }
}
