package com.example.MensajeriaExpress;

import com.example.MensajeriaExpress.Repository.ClientesRepository;
import com.example.MensajeriaExpress.Repository.EnviosRepository;
import com.example.MensajeriaExpress.Repository.PaquetesRepository;
import com.example.MensajeriaExpress.Services.ClientesService;
import org.junit.Before;
import org.junit.Test;


public class ClientesServiceTest {

    ClientesRepository clientesRepository;

    PaquetesRepository paquetesRepository;

    EnviosRepository enviosRepository;

    ClientesService clientesService;

    @Before
    public void setUp(){
        this.clientesService = new ClientesService(clientesRepository, paquetesRepository, enviosRepository);
    }

    @Test
    public void crearUnCliente(){

    }
}
