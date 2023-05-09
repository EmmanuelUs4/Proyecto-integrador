package com.example.MensajeriaExpress.Repository;

import com.example.MensajeriaExpress.DTO.ClienteDTO.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
}
