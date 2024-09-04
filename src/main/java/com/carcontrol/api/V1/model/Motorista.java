package com.carcontrol.api.V1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "motoristas")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    private String nome;

    @Column(unique = true)
    private String cpfcnpj;

    private String setor;

    private boolean ativo;

    public void ativarDesativar(){
        if (this.ativo) {
            this.ativo = false;
        } else {
            this.ativo = true;
        }
    }
}
