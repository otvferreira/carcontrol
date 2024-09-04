package com.carcontrol.api.V1.service;

import com.carcontrol.api.V1.controller.dto.UsuarioDTOComSenha;
import com.carcontrol.api.V1.model.Usuario;
import com.carcontrol.api.V1.repository.UsuarioRepository;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder;

    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario)
                .orElseThrow();
    }

    public void salvarUsuario(UsuarioDTOComSenha usuarioDTO) {
        Usuario usuario = Usuario.builder()
                .nome(usuarioDTO.getNome())
                .usuario(usuarioDTO.getUsuario())
                .senha(passwordEncoder.encode(usuarioDTO.getSenha())) // Criptografa a senha
                .email(usuarioDTO.getEmail())
                .role("USER") // Ajuste conforme necessário
                .build();

        usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        return new org.springframework.security.core.userdetails.User(
                usuario.getUsuario(),
                usuario.getSenha(),
                Collections.singleton(new SimpleGrantedAuthority(usuario.getRole())));
    }
}
