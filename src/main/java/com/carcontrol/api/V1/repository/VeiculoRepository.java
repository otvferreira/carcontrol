package com.carcontrol.api.V1.repository;

import com.carcontrol.api.V1.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {
    Optional<Veiculo> findByPlaca(String placa);
}
