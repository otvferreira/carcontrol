package com.carcontrol.api.V1.controller;

import com.carcontrol.api.V1.controller.dto.EmpresaDTO;
import com.carcontrol.api.V1.model.Empresa;
import com.carcontrol.api.V1.model.Usuario;
import com.carcontrol.api.V1.repository.EmpresaRepository;
import com.carcontrol.api.V1.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/V1/empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/listar")
    public List<Empresa> listar(){
        return empresaRepository.findAll();
    }

    @GetMapping("/buscar/{cnpjEmp}")
    public Empresa buscar(@PathVariable String cnpjEmp){
        return empresaService.buscarEmpresa(cnpjEmp);
    }

    @PostMapping("/registrar")
    public Empresa registrar(@RequestBody EmpresaDTO empresa){
        return empresaService.salvarEmpresa(empresa);

    }

    @PutMapping("/status/{cnpj}")
    public void status(@PathVariable String cnpj){
        Empresa empresa = empresaService.buscarEmpresa(cnpj);
        empresa.ativar();

        empresaRepository.save(empresa);
    }

    @PutMapping("/atualizar/{cnpjEmp}")
    public ResponseEntity<Empresa> atualizarAtributo(@PathVariable String cnpjEmp, @RequestBody Map<String, Object> atributosAtualizados) {
        Empresa empresa = empresaService.buscarEmpresa(cnpjEmp);
        if (empresa != null) {
            if (atributosAtualizados.containsKey("nome")) {
                empresa.setNome(atributosAtualizados.get("nome").toString());
            }
            if (atributosAtualizados.containsKey("razao")) {
                empresa.setRazao(atributosAtualizados.get("razao").toString());
            }
            if (atributosAtualizados.containsKey("telefone")) {
                empresa.setTelefone(atributosAtualizados.get("telefone").toString());
            }
            if (atributosAtualizados.containsKey("email")) {
                empresa.setEmail(atributosAtualizados.get("email").toString());
            }
            if (atributosAtualizados.containsKey("endereco")) {
                empresa.setEndereco(atributosAtualizados.get("endereco").toString());
            }
            if (atributosAtualizados.containsKey("site")) {
                empresa.setSite(atributosAtualizados.get("site").toString());
            }

            empresaRepository.save(empresa);

            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/excluir/{cnpjEmp}")
    public void excluir(@PathVariable String cnpjEmp){
        empresaService.excluirEmpresa(cnpjEmp);

    }


}
