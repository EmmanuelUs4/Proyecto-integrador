package com.example.MensajeriaExpress.Services;

import com.example.MensajeriaExpress.Exception.ClientNotFound;
import com.example.MensajeriaExpress.DTO.ClienteDTO.Cliente;
import com.example.MensajeriaExpress.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    private ClientesRepository clientesRepository;


    @Autowired
    public ClientesService(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;

    }

    public Cliente crearCliente(Cliente cliente){
        return this.clientesRepository.save(cliente);

    }



    public Cliente editarCliente(Cliente cliente) {
        Integer cedula = cliente.getCedula();
        Optional<Cliente> clienteEncontrado = clientesRepository.findById(cedula);
        if (clienteEncontrado.isPresent()) {
            Cliente clienteActualizado = clienteEncontrado.get();
            clienteActualizado.setNombre(cliente.getNombre());
            clienteActualizado.setApellidos(cliente.getApellidos());
            clienteActualizado.setCelular(cliente.getCelular());
            clienteActualizado.setCorreoElectronico(cliente.getCorreoElectronico());
            clienteActualizado.setDireccionDeResidencia(cliente.getDireccionDeResidencia());
            clienteActualizado.setCiudad(cliente.getCiudad());
            return clientesRepository.save(clienteActualizado);
        } else {
            throw new ClientNotFound("No se encontró un cliente con la cédula" + cedula);
        }
    }

    public Boolean eliminarClientePorCedula(Integer cedula){
        this.clientesRepository.deleteById(cedula);
        return true;
    }

    public Optional<Cliente> consultarUnCliente(Integer cedula){
        return this.clientesRepository.findById(cedula);
    }

    public List<Cliente> consultarTodosLosClientes(){
        return this.clientesRepository.findAll();
    }


}
