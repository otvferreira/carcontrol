package com.carcontrol.api.V1.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "veiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String modelo;

    private String marca;

    @Column(unique = true)
    private String placa;

    private Long km_inicial;

    private Long km_atual;

    @CreationTimestamp
    @Column(columnDefinition = "datetime")
    private Date data_inc;

    private boolean ativo;

    private boolean ocupado;

    @PrePersist
    public void ativardesativar() {
        if (this.ativo) {
            this.ativo = false;
        } else {
            this.ativo = true;
        }
    }

    @PrePersist
    public void ocupardesocupar() {
        if (this.ocupado) {
            this.ocupado = false;
        } else {
            this.ocupado = true;
        }
    }
}
