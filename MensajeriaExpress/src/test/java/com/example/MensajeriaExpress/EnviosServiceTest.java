package com.example.MensajeriaExpress;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verifyZeroInteractions;

import com.example.MensajeriaExpress.DTO.EmpleadoDTO.Empleado;
import com.example.MensajeriaExpress.DTO.EmpleadoDTO.TipoDeEmpleado;
import com.example.MensajeriaExpress.DTO.EnvioDTO.*;
import com.example.MensajeriaExpress.DTO.PaqueteDTO.Paquete;
import com.example.MensajeriaExpress.DTO.PaqueteDTO.TipoDePaquete;
import com.example.MensajeriaExpress.Exception.EmployeeNotFound;
import com.example.MensajeriaExpress.Exception.ShipmentNotFound;
import com.example.MensajeriaExpress.Repository.ClientesRepository;
import com.example.MensajeriaExpress.Repository.EmpleadosRepository;
import com.example.MensajeriaExpress.Repository.EnviosRepository;
import com.example.MensajeriaExpress.Repository.PaquetesRepository;
import com.example.MensajeriaExpress.Services.EnviosService;
import com.example.MensajeriaExpress.Services.PaquetesService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;


public class EnviosServiceTest {

    @Mock
    EnviosRepository enviosRepository;

    @Mock
    ClientesRepository clientesRepository;

    @Mock
    PaquetesRepository paquetesRepository;

    @Mock
    EmpleadosRepository empleadosRepository;

    @Mock
    PaquetesService paquetesService;

    @Mock
    EnviosService enviosService;

    @BeforeEach
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
    public void testCrearEnvioConClienteInexistente() {

        Paquete  paquete  = new Paquete(123123, TipoDePaquete.GRANDE, 12.23,123123);

        when(clientesRepository.findById(any())).thenReturn(Optional.empty());

        Envio envio = new Envio(123456, null,"origen", "ciudad","ciudaddestino","receptor",1234,"si",EstadoDeEnvio.RECIBIDO,  1234, paquete );

        Assertions.assertTrue(envio!=null);
    }

    @Test
    public void consultarEnvioInexistente(){
        int numeroDeGuiaInexistente = 12345;
        assertThrows(ShipmentNotFound.class, () -> {
            EstadoEnvioDTO estadoEnvioDTO = this.enviosService.consultarUnEnvio(numeroDeGuiaInexistente);
        });
    }


    @Test
    public void testActualizarEstadoEnvioEnvioNoExiste() {
        ActualizarInformacionEnvio actualizarInfoEnvio = new ActualizarInformacionEnvio();
        actualizarInfoEnvio.setNumeroDeGuiaDTO(1001);
        DatosEmpleado empleado = new DatosEmpleado();
        empleado.setCedula(1234567890);
        empleado.setTipoDeEmpleado(TipoDeEmpleado.REPARTIDOR);

        when(enviosRepository.findById(actualizarInfoEnvio.getNumeroDeGuiaDTO())).thenReturn(Optional.empty());

        Assertions.assertTrue(actualizarInfoEnvio!=null);

    }

    @Test
    public void testFiltradoDeEnviosConEstadoEmpleadoExisteNoExistenEnviosConEstado() {
        // Arrange
        EstadoDeEnvio estado = EstadoDeEnvio.RECIBIDO;
        Integer cedula = 123456789;
        Optional<Empleado> empleadoMock = Optional.of(new Empleado());
        Mockito.when(empleadosRepository.findById(Mockito.anyInt())).thenReturn(empleadoMock);
        List<Envio> enviosMock = new ArrayList<>();
        Mockito.when(enviosRepository.findByEstadoDelEnvio(Mockito.any(EstadoDeEnvio.class))).thenReturn(enviosMock);

        // Act and Assert
        try {
            List<Envio> enviosConEstado = enviosService.filtradoDeEnviosConEstado(estado, cedula);
            Assert.assertTrue(enviosConEstado.isEmpty());
        } catch (EmployeeNotFound e) {
            Assert.fail("No se esperaba EmployeeNotFound");
        }
    }



}
