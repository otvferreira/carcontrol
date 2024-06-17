package com.carcontrol.api.V1.controller;

import com.carcontrol.api.V1.service.UsuarioService;
import com.carcontrol.api.V1.model.Usuario;
import com.carcontrol.api.V1.controller.dto.UsuarioDTOComSenha;
import com.carcontrol.api.V1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/V1/users")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/search")
    public List<Usuario> listar() {
        return service.listarTodos();
    }

    @GetMapping("/search/{usuario}")
    public Usuario buscar(@PathVariable String usuario){
        return service.buscar(usuario);
    }
    @PostMapping("/register")
    public ResponseEntity<Object> adicionar(@RequestBody UsuarioDTOComSenha usuario){
        service.salvar(usuario);

        return ResponseEntity.ok("Usuário criado com sucesso.");
    }

}
