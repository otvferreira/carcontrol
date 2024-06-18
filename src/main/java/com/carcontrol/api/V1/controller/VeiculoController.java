package com.carcontrol.api.V1.controller;

import com.carcontrol.api.V1.controller.dto.VeiculoComKmDTO;
import com.carcontrol.api.V1.controller.dto.VeiculoDTO;
import com.carcontrol.api.V1.model.Veiculo;
import com.carcontrol.api.V1.service.VeiculoService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/V1/veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @GetMapping("/buscar")
    public List<Veiculo> listarTodos(){
        return veiculoService.listar();
    }

    @GetMapping("/buscar/{placa}")
    public Optional<Veiculo> buscar(@PathVariable String placa) throws Exception{

        return Optional.ofNullable(veiculoService.buscar(placa)
                .orElseThrow(() -> new Exception("Veiculo não cadastrado")));
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> salvar(@RequestBody VeiculoComKmDTO veiculo) throws Exception {

        if((veiculoService.buscar(veiculo.getPlaca())).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Veículo já cadastrado");
        }

        veiculoService.salvar(veiculo);
        return ResponseEntity.ok("Veículo cadastrado com sucesso");
    }

}
