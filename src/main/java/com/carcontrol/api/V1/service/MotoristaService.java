package com.carcontrol.api.V1.service;

import com.carcontrol.api.V1.controller.dto.MotoristaDTO;
import com.carcontrol.api.V1.model.Motorista;
import com.carcontrol.api.V1.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    MotoristaRepository motoristaRepository;

    public Motorista buscarMotorista(String cpfcnpj){
        return motoristaRepository.findBycpfcnpj(cpfcnpj)
                .orElseThrow();
    }
    public Motorista salvar(MotoristaDTO motoristaDTO){
        Motorista motorista = Motorista.builder()
                .nome(motoristaDTO.getNome())
                .setor(motoristaDTO.getSetor())
                .cpfcnpj(motoristaDTO.getCpfcnpj())
                .build();

        motorista.ativarDesativar();
        return motoristaRepository.save(motorista);
    }
}
