package com.example.MensajeriaExpress.Repository;

import com.example.MensajeriaExpress.DTO.EnvioDTO.Envio;
import com.example.MensajeriaExpress.DTO.EnvioDTO.EstadoDeEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnviosRepository extends JpaRepository<Envio, Integer> {

        List<Envio> findByEstadoDelEnvio(EstadoDeEnvio estadoDelEnvio);
    }




