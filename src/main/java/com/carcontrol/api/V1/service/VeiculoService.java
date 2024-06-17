package com.carcontrol.api.V1.service;

import com.carcontrol.api.V1.controller.dto.UsuarioDTOComSenha;
import com.carcontrol.api.V1.controller.dto.VeiculoComKmDTO;
import com.carcontrol.api.V1.model.Usuario;
import com.carcontrol.api.V1.model.Veiculo;
import com.carcontrol.api.V1.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    public List<Veiculo> listar(){
        return veiculoRepository.findAll();
    }

    public Veiculo buscar(String placa){
        return veiculoRepository.findByPlaca(placa)
                .orElseThrow();
    }

    public void salvar(VeiculoComKmDTO veiculoDTO){
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
