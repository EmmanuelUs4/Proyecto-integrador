package com.example.MensajeriaExpress.Services;

import com.example.MensajeriaExpress.Exception.ClientNotFound;
import com.example.MensajeriaExpress.DTO.ClienteDTO.Cliente;
import com.example.MensajeriaExpress.Repository.ClientesRepository;
import com.example.MensajeriaExpress.Repository.EnviosRepository;
import com.example.MensajeriaExpress.Repository.PaquetesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    private ClientesRepository clientesRepository;

    private PaquetesRepository paquetesRepository;

    private EnviosRepository enviosRepository;

    @Autowired
    public ClientesService(ClientesRepository clientesRepository, PaquetesRepository paquetesRepository, EnviosRepository enviosRepository) {
        this.clientesRepository = clientesRepository;
        this.paquetesRepository = paquetesRepository;
        this.enviosRepository = enviosRepository;
    }

    public Cliente crearCliente(Cliente cliente){
        this.clientesRepository.save(cliente);
        return cliente;
    }

    public Cliente editarCliente(Cliente cliente){
        //
        this.clientesRepository.save(cliente);
        return cliente;
    }

    public void eliminarClientePorCedula(Integer cedula){
        Optional<Cliente>clienteOptional = clientesRepository.findById(cedula);
        if (!clienteOptional.isPresent()){
            throw new ClientNotFound("No se encontró el cliente.");
        }
        this.clientesRepository.deleteById(cedula);
    }

    public Cliente consultarUnCliente(Integer cedula){
        Optional<Cliente> clienteOptional = this.clientesRepository.findById(cedula);
        if (!clienteOptional.isPresent()){
            throw new ClientNotFound("No se ha encontrado el cliente solicitado.");
        }
        return clienteOptional.get();
    }

    public List<Cliente> consultarTodosLosClientes(){
        return this.clientesRepository.findAll();
    }


}
