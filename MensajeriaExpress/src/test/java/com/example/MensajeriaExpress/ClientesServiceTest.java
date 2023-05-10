package com.example.MensajeriaExpress;

import com.example.MensajeriaExpress.DTO.ClienteDTO.Cliente;
import com.example.MensajeriaExpress.Repository.ClientesRepository;
import com.example.MensajeriaExpress.Services.ClientesService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;

public class ClientesServiceTest {
    ClientesRepository clientesRepository;
    ClientesService clientesService;

    @BeforeEach
    public void SetUp() {
        this.clientesRepository = mock(ClientesRepository.class);
        this.clientesService = new ClientesService(clientesRepository);
    }

    @Test
    public void crearUnClienteTest() {
        Cliente cliente = new Cliente(123, "Carlo", "jose");

        when(clientesRepository.save(any(Cliente.class))).thenReturn(cliente);
        clientesRepository.save(cliente);

        Cliente cliente1 = clientesService.crearCliente(cliente);

        Assertions.assertSame(cliente1, cliente);
    }


    @Test
    public void eliminarClienteConCedula() {

        Cliente cliente = new Cliente(12345, "Mateo", "Restrepo", 12345, "mateor@gmail.com", "Calle 451", "Ciudad");

        doNothing().when(clientesRepository).deleteById(cliente.getCedula());

        Boolean resultado = clientesService.eliminarClientePorCedula(cliente.getCedula());

        verify(clientesRepository, times(1)).deleteById(cliente.getCedula());

        Assertions.assertTrue(resultado);
    }
    @Test
    void consultarClienteConCedula() {
        Cliente cliente = new Cliente(123, "carlo", "jose", 123456709,
                "correo@gmail.com", "calle 1", "medellin");
        when(clientesRepository.findById(123)).thenReturn(Optional.of(cliente));
        clientesRepository.save(cliente);

        Optional<Cliente> clienteEncontrado = clientesService.consultarUnCliente(123);

        Assertions.assertTrue(clienteEncontrado.isPresent());
        Assertions.assertSame(cliente, clienteEncontrado.get());

    }
}
