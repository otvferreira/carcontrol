package com.carcontrol.api.V1.controller;

import com.carcontrol.api.V1.controller.dto.VeiculoComKmDTO;
import com.carcontrol.api.V1.model.Veiculo;
import com.carcontrol.api.V1.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("V1/veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @GetMapping("/buscar")
    public List<Veiculo> listarTodos(){
        return veiculoService.listar();
    }

    @GetMapping("/buscar/{placa}")
    public Veiculo buscar(@PathVariable String placa){

        return veiculoService.buscar(placa);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Object> salvar(@RequestBody VeiculoComKmDTO veiculo){
        veiculoService.salvar(veiculo);
        return ResponseEntity.ok(veiculo);
    }

}
