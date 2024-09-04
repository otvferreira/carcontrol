package com.carcontrol.core.security;

import com.carcontrol.api.V1.model.Usuario;
import com.carcontrol.api.V1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.repository.findByUsuario(username).orElseThrow(() -> new UsernameNotFoundException("User not Found"));
        return new org.springframework.security.core.userdetails.User(usuario.getUsuario(), usuario.getSenha(), new ArrayList<>());
    }
}
