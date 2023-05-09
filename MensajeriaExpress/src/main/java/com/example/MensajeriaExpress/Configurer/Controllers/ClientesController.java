package com.example.MensajeriaExpress.Configurer.Controllers;

import com.example.MensajeriaExpress.DTO.ClienteDTO.Cliente;
import com.example.MensajeriaExpress.Services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientesController {
    private ClientesService clientesService;

    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @PostMapping("/cliente")
    public Cliente crearCliente(Cliente cliente){
        return this.clientesService.crearCliente(cliente);
    }

    @PutMapping("/cliente")
    public Cliente editarCliente(Cliente cliente){
        return this.clientesService.editarCliente(cliente);
    }

    @DeleteMapping("/cliente/{cedula}")
    public ResponseEntity<?> borrarCliente(@PathVariable Integer cedula){
        this.clientesService.eliminarClientePorCedula(cedula);
        String message = "El cliente de cédula: "+cedula+", ha sido eliminado con éxito.";
        return ResponseEntity.ok(message);
    }

    @PostMapping("/cliente/{cedula}")
    public Cliente  consultarCliente(@PathVariable Integer cedula){
        return this.clientesService.consultarUnCliente(cedula);
    }

    @PostMapping("/clientes")
    public List<Cliente> consultarClientes(){
        return this.clientesService.consultarTodosLosClientes();
    }




}
