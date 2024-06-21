package com.carcontrol.api.V1.controller;

import com.carcontrol.api.V1.controller.dto.EmpresaDTO;
import com.carcontrol.api.V1.model.Empresa;
import com.carcontrol.api.V1.repository.EmpresaRepository;
import com.carcontrol.api.V1.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public void status(String cnpj){
        Empresa empresa = empresaService.buscarEmpresa(cnpj);
        empresa.ativar();

        empresaRepository.save(empresa);
    }
    /*/
    @PutMapping("/atualizar/{cnpj}")
    public Empresa atualizar(@PathVariable String cnpj, @RequestBody EmpresaDTO empresaDTO){
        return
    }
    /*/


    @DeleteMapping("/excluir/{cnpjEmp}")
    public void excluir(@PathVariable String cnpjEmp){
        empresaService.excluirEmpresa(cnpjEmp);

    }


}
