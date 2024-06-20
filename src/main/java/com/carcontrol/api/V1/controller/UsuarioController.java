package com.carcontrol.api.V1.controller;

import com.carcontrol.api.V1.service.UsuarioService;
import com.carcontrol.api.V1.model.Usuario;
import com.carcontrol.api.V1.controller.dto.UsuarioDTOComSenha;
import com.carcontrol.api.V1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/V1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/buscar")
    public List<Usuario> listar() {
        return service.listarUsuario();
    }

    @GetMapping("/buscar/{usuario}")
    public Optional<Usuario> buscar(@PathVariable String usuario){
        return service.buscarUsuario(usuario);
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> adicionar(@RequestBody UsuarioDTOComSenha usuario){
        if (service.buscarUsuario(usuario.getUsuario()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome de usuário já está sendo utilizado.");
        }

        service.salvarUsuario(usuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso.");
    }

}
