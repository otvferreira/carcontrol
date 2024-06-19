package com.carcontrol.api.V1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private String razao;

    @Column(unique = true)
    private String cnpj;

    private String telefone;

    @Email
    private String email;

    private String endereco;

    private String site;

    private boolean ativo;

    private String delet;

    @PrePersist
    public void ativar(){
        this.ativo = true;
    }

}