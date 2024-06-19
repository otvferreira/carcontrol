package com.carcontrol.api.V1.repository;

import com.carcontrol.api.V1.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, UUID> {
    Optional<Empresa> findBycnpj(String cnpj);
}
