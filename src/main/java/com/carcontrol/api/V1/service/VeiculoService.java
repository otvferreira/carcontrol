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

    public Optional<Veiculo> buscarVeiculo(String placa) throws Exception {
        return veiculoRepository.findByPlaca(placa);
    }

    public void salvarVeiculo(VeiculoComKmDTO veiculoDTO){
        Veiculo veiculo = Veiculo.builder()
                .modelo(veiculoDTO.getModelo())
                .marca(veiculoDTO.getMarca())
                .placa(veiculoDTO.getPlaca())
                .km_inicial(veiculoDTO.getKm_inicial())
                .km_atual(veiculoDTO.getKm_atual())
                .build();
        veiculoRepository.save(veiculo);
    }



}
