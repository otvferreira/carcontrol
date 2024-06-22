package com.carcontrol.api.V1.controller;

import com.carcontrol.api.V1.model.Motorista;
import com.carcontrol.api.V1.service.UsuarioService;
import com.carcontrol.api.V1.model.Usuario;
import com.carcontrol.api.V1.controller.dto.UsuarioDTOComSenha;
import com.carcontrol.api.V1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public Usuario buscar(@PathVariable String usuario){

        return service.buscarUsuario(usuario);
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> adicionar(@RequestBody UsuarioDTOComSenha usuario){

        service.salvarUsuario(usuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso.");
    }

    @PutMapping("/atualizar/{usuario}")
    public ResponseEntity<Usuario> atualizarAtributo(@PathVariable String usuario, @RequestBody Map<String, Object> atributosAtualizados) {
        Usuario usuarioatt = service.buscarUsuario(usuario);
        if (usuarioatt != null) {
            if (atributosAtualizados.containsKey("nome")) {
                usuarioatt.setNome(atributosAtualizados.get("nome").toString());
            }
            if (atributosAtualizados.containsKey("email")) {
                usuarioatt.setEmail(atributosAtualizados.get("email").toString());
            }
            if (atributosAtualizados.containsKey("telefone")) {
                usuarioatt.setTelefone(atributosAtualizados.get("telefone").toString());
            }

            repository.save(usuarioatt);

            return ResponseEntity.ok(usuarioatt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/status/{usuario}")
    public void status(@PathVariable String usuario){
        Usuario usuarioAtualizado = service.buscarUsuario(usuario);
        usuarioAtualizado.ativar();

        repository.save(usuarioAtualizado);
    }

}
