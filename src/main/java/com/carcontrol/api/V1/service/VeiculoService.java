package com.carcontrol.api.V1.service;

import com.carcontrol.api.V1.controller.dto.VeiculoComKmDTO;
import com.carcontrol.api.V1.model.Veiculo;
import com.carcontrol.api.V1.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    public List<Veiculo> listarVeiculo(){
        return veiculoRepository.findAll();
    }

    public Veiculo buscarVeiculo(String placa) {
        return veiculoRepository.findByPlaca(placa)
                .orElseThrow();
    }

    public void salvarVeiculo(VeiculoComKmDTO veiculoDTO){
        Veiculo veiculo = Veiculo.builder()
                .modelo(veiculoDTO.getModelo())
                .marca(veiculoDTO.getMarca())
                .placa(veiculoDTO.getPlaca())
                .km_inicial(String.valueOf(veiculoDTO.getKm_inicial()))
                .km_atual(String.valueOf(veiculoDTO.getKm_atual()))
                .build();
        veiculoRepository.save(veiculo);
    }

}
