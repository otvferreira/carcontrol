package com.carcontrol.api.V1.repository;

import com.carcontrol.api.V1.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, UUID> {
    Optional<Motorista> findBycpfcnpj(String cpfcnpj);
}
