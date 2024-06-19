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

    public Empresa salvar(EmpresaDTO empresaDTO) {
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

    public Empresa buscar(String cnpjEmp){
        return empresaRepository.findBycnpj(cnpjEmp)
                .orElseThrow();
    }

    public void excluir(String cnpj){
        Empresa empresa = buscar(cnpj);

        empresaRepository.deleteById(empresa.getId());
        empresaRepository.flush();

    }
}
