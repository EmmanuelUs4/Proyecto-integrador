package com.example.MensajeriaExpress.Repository;

import com.example.MensajeriaExpress.DTO.PaqueteDTO.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaquetesRepository extends JpaRepository<Paquete, Integer> {
}
