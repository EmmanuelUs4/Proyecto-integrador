package com.example.MensajeriaExpress.envios;

import com.example.MensajeriaExpress.DTO.ClienteDTO.Cliente;
import com.example.MensajeriaExpress.DTO.EmpleadoDTO.TipoDeEmpleado;
import com.example.MensajeriaExpress.DTO.EnvioDTO.*;
import com.example.MensajeriaExpress.DTO.PaqueteDTO.Paquete;
import com.example.MensajeriaExpress.DTO.PaqueteDTO.TipoDePaquete;
import com.example.MensajeriaExpress.Repository.ClientesRepository;
import com.example.MensajeriaExpress.Repository.EmpleadosRepository;
import com.example.MensajeriaExpress.Repository.EnviosRepository;
import com.example.MensajeriaExpress.Repository.PaquetesRepository;
import com.example.MensajeriaExpress.Services.EnviosService;
import com.example.MensajeriaExpress.Services.PaquetesService;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnviosServiceTest {

    EnviosRepository enviosRepository;
    ClientesRepository clientesRepository;
    PaquetesRepository paquetesRepository;
    EmpleadosRepository empleadosRepository;
    PaquetesService paquetesService;

    EnviosService enviosService;

    @Before
    public void setUp(){
        this.enviosRepository=mock(EnviosRepository.class);
        this.enviosService=mock(EnviosService.class);
        this.clientesRepository= mock(ClientesRepository.class);
        this.paquetesRepository=mock(PaquetesRepository.class);
        this.empleadosRepository=mock(EmpleadosRepository.class);
        this.paquetesService=mock(PaquetesService.class);
        this.enviosService = new EnviosService(enviosRepository, clientesRepository,  paquetesRepository, empleadosRepository, paquetesService);
    }

    @Test
    public void actualizarUnEnvioTest(){
        ActualizarInformacionEnvio actualizarInformacionEnvio= new ActualizarInformacionEnvio(123, EstadoDeEnvio.RECIBIDO);
        DatosEmpleado datosEmpleado= new DatosEmpleado(1, TipoDeEmpleado.REPARTIDOR);

        EdicionEstadoEnvioDTO actualizarInformacionEnvio1= this.enviosService.actualizarEstadoEnvio(actualizarInformacionEnvio, datosEmpleado);

        assertTrue(true);
    }

    @Test
    public void testCrearEnvioConClienteInexistente() {

        Paquete  paquete  = new Paquete(123123, TipoDePaquete.GRANDE, 12.23,123123);

        when(clientesRepository.findById(any())).thenReturn(Optional.empty());

        Envio envio = new Envio(123456, null,"origen", "ciudad","ciudaddestino","receptor",1234,"si",EstadoDeEnvio.RECIBIDO,  1234, paquete );

        assertTrue(envio.getCliente()!=null);
    }


    @Test
    public void testConsultarEnvioConPaqueteInexistente() {
        int numeroDeGuia = 123456;
        when(enviosRepository.findById(numeroDeGuia)).thenReturn(Optional.empty());

        Cliente cliente = new Cliente("12345678", "Juan Perez");
        Envio envio = new Envio();
        envio.setNumeroDeGuia(numeroDeGuia);

        assertTrue(enviosService.consultarUnEnvio(numeroDeGuia, envio)!=null);


    }

}
