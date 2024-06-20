package com.carcontrol.api.V1.service;

import com.carcontrol.api.V1.controller.dto.EmpresaDTO;
import com.carcontrol.api.V1.model.Empresa;
import com.carcontrol.api.V1.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa salvarEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = Empresa.builder()
                .nome(empresaDTO.getNome())
                .razao(empresaDTO.getRazao())
                .cnpj(empresaDTO.getCnpj())
                .telefone(empresaDTO.getTelefone())
                .email(empresaDTO.getEmail())
                .endereco(empresaDTO.getEndereco())
                .site(empresaDTO.getSite())
                .build();

        return empresaRepository.save(empresa);
    }

    public Empresa buscarEmpresa(String cnpjEmp){
        return empresaRepository.findBycnpj(cnpjEmp)
                .orElseThrow();
    }

    public void excluirEmpresa(String cnpj){
        Empresa empresa = buscarEmpresa(cnpj);

        empresaRepository.deleteById(empresa.getId());
        empresaRepository.flush();

    }
}
