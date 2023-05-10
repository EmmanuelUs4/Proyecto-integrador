package com.example.MensajeriaExpress.Controllers;

import com.example.MensajeriaExpress.DTO.ClienteDTO.Cliente;
import com.example.MensajeriaExpress.Services.ClientesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ClientesController {
    private ClientesService clientesService;

    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @PostMapping("/cliente")
    @ApiOperation(value = "Crear un cliente", response = Cliente.class)
    @PreAuthorize("hasRole('WRITE')")
    public Cliente crearCliente(Cliente cliente){
        return this.clientesService.crearCliente(cliente);
    }

    @PutMapping("/cliente/{cedula}")
    @ApiOperation(value = "Editar un cliente ", response = Cliente.class)
    @PreAuthorize("hasRole('WRITE')")
    public Cliente editarCliente(Cliente cliente){
        return this.clientesService.editarCliente(cliente);
    }

    @DeleteMapping("/cliente/{cedula}")
    @ApiOperation(value = "Eliminar un cliente por cédula", response = Cliente.class)
    @PreAuthorize("hasRole('WRITE')")
    public ResponseEntity<?> borrarCliente(@PathVariable Integer cedula){
        this.clientesService.eliminarClientePorCedula(cedula);
        String message = "El cliente de cédula: "+cedula+", ha sido eliminado con éxito.";
        return ResponseEntity.ok(message);
    }

    @PostMapping("/cliente/{cedula}")
    @ApiOperation(value = "Consultar un cliente por cédula", response = Cliente.class)
    @PreAuthorize("hasRole('READ')")
    public Optional<Cliente> consultarCliente(@PathVariable Integer cedula){
        return this.clientesService.consultarUnCliente(cedula);
    }

    @PostMapping("/clientes")
    @ApiOperation(value = "Consultar clientes", response = Cliente.class)
    @PreAuthorize("hasRole('WRITE')")
    public List<Cliente> consultarClientes(){
        return this.clientesService.consultarTodosLosClientes();
    }




}
