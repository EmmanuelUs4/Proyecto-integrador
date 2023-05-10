package com.example.MensajeriaExpress;

import com.example.MensajeriaExpress.DTO.ClienteDTO.Cliente;
import com.example.MensajeriaExpress.DTO.PaqueteDTO.Paquete;
import com.example.MensajeriaExpress.DTO.PaqueteDTO.TipoDePaquete;
import com.example.MensajeriaExpress.Repository.PaquetesRepository;
import com.example.MensajeriaExpress.Services.PaquetesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaquetesServicesTest {

    PaquetesRepository paquetesRepository;

    PaquetesService paquetesService;

    @BeforeEach
    public void SetUp(){
        this.paquetesRepository=mock(PaquetesRepository.class);
        this.paquetesService= new PaquetesService(paquetesRepository);
    }

    @Test
    public void crearUnClienteTest() {
        Paquete paquete = new Paquete(123, TipoDePaquete.LIVIANO,1.0,123123);

        when(paquetesRepository.save(any(Paquete.class))).thenReturn(paquete);
        paquetesRepository.save(paquete);

        Paquete paquete1 = paquetesService.crearPaquete(paquete);

        Assertions.assertSame(paquete1, paquete);
    }

}
