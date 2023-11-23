package com.carcontrol.entity.usuario;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Table(name = "user")
@Getter
@Setter
@Builder
@Entity
@EqualsAndHashCode(of = "id")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String usuario;

    private String senha;

    @Column(unique = true)
    private String email;

}
