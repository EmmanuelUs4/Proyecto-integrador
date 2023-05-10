package com.example.MensajeriaExpress;


import com.example.MensajeriaExpress.DTO.ClienteDTO.Cliente;
import com.example.MensajeriaExpress.DTO.EmpleadoDTO.Empleado;
import com.example.MensajeriaExpress.DTO.EmpleadoDTO.TipoDeEmpleado;
import com.example.MensajeriaExpress.Repository.EmpleadosRepository;
import com.example.MensajeriaExpress.Services.EmpleadosService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmpleadosServiceTest {

    EmpleadosRepository empleadosRepository;

    EmpleadosService  empleadosService;

    @BeforeEach
    void SetUp(){
        this.empleadosRepository=mock(EmpleadosRepository.class);
        this.empleadosService = new EmpleadosService(empleadosRepository);
    }

    @Test
    public void crearUnEmpleadoTest() {
        Empleado empleado = new Empleado(123, "Carlo", "jose");

        when(empleadosRepository.save(any(Empleado.class))).thenReturn(empleado);
        empleadosRepository.save(empleado);

        Empleado empleado1 = empleadosService.crearEmpleado(empleado);

        Assertions.assertSame(empleado1, empleado);
    }

    @Test
    public void eliminarEmpleadoConCedula() {

        Empleado empleado = new Empleado(12345, "carlo", "jose",12345,"Correoelectro@gmail.com","una direccion", "una ciudad","antiguedad","sangre", TipoDeEmpleado.REPARTIDOR);

        doNothing().when(empleadosRepository).deleteById(empleado.getCedula());

        Boolean resultado = empleadosService.eliminarEmpleadoPorCedula(empleado.getCedula());

        verify(empleadosRepository, times(1)).deleteById(empleado.getCedula());

        Assertions.assertTrue(resultado);
    }
    @Test
    void consultarEmpleadoConCedula() {
        Empleado empleado = new Empleado(123, "carlo", "magno", 1234,
                "uncorreo@gmail.com", "calle 1", "una ciudad","antiguedad","sangre",TipoDeEmpleado.REPARTIDOR);
        when(empleadosRepository.findById(123)).thenReturn(Optional.of(empleado));
        empleadosRepository.save(empleado);

        Optional<Empleado> empleadoEncontrado = Optional.ofNullable(empleadosService.consultarUnEmpleado(123));

        Assertions.assertTrue(empleadoEncontrado.isPresent());
        Assertions.assertSame(empleado, empleadoEncontrado.get());

    }
}
