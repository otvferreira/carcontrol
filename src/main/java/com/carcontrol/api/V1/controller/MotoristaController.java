package com.carcontrol.api.V1.controller;

import com.carcontrol.api.V1.controller.dto.MotoristaDTO;
import com.carcontrol.api.V1.model.Motorista;
import com.carcontrol.api.V1.repository.MotoristaRepository;
import com.carcontrol.api.V1.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/V1/motorista")
public class MotoristaController {

    @Autowired
    MotoristaService motoristaService;

    @Autowired
    MotoristaRepository motoristaRepository;

    @GetMapping("/listar")
    public List<Motorista> listar(){
        return motoristaRepository.findAll();
    }

    @GetMapping("/buscar/{motoristacpfcnpj}")
    public Motorista buscar(@PathVariable String motoristacpfcnpj){
        return motoristaService.buscarMotorista(motoristacpfcnpj);

    }

    @PostMapping("/registrar")
    public Motorista salvar(@RequestBody MotoristaDTO motoristaDTO) {
        return motoristaService.salvar(motoristaDTO);

    }

    @PutMapping("/status/{cpfcnpj}")
    public ResponseEntity<Motorista> status(@PathVariable String cpfcnpj){
        Motorista motorista = motoristaService.buscarMotorista(cpfcnpj);
        motorista.ativarDesativar();

        motoristaRepository.save(motorista);
        return ResponseEntity.ok(motorista);
    }

    @PutMapping("/atualizar/{cpfcnpj}")
    public ResponseEntity<Motorista> atualizarAtributoMotorista(@PathVariable String cpfcnpj, @RequestBody Map<String, Object> atributosAtualizados) {
        Motorista motorista = motoristaService.buscarMotorista(cpfcnpj);
        if (motorista != null) {
            if (atributosAtualizados.containsKey("setor")) {
                motorista.setSetor(atributosAtualizados.get("setor").toString());
            }
            if (atributosAtualizados.containsKey("nome")) {
                motorista.setNome(atributosAtualizados.get("nome").toString());
            }

            motoristaRepository.save(motorista);

            return ResponseEntity.ok(motorista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
