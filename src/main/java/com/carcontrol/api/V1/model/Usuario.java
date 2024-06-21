package com.carcontrol.api.V1.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@Getter
@Setter
@Builder
@Entity
@EqualsAndHashCode
public class Usuario {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String usuario;

    private String senha;

    @Column(unique = true)
    private String email;

    @CreationTimestamp
    @Column(columnDefinition = "datetime")
    private Date datainc;

    private boolean ativo;

    @PrePersist
    public void ativar() {
        if (this.ativo) {
            this.ativo = false;
        } else {
            this.ativo = true;
        }
    }

}
