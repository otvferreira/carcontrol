package com.carcontrol.api.entity.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Getter
@Setter
@Builder
@Entity
@EqualsAndHashCode
public class UsuarioEntity {

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
    @Column(nullable = false, columnDefinition = "datetime")
    private Date datainc;

    private boolean ativo;

    private Character delet;

    @PrePersist
    public void prePersist() {
        this.ativo = true;
    }

}
