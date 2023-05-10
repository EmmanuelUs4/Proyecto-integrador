package com.example.MensajeriaExpress.Controllers;

import com.example.MensajeriaExpress.DTO.EnvioDTO.*;
import com.example.MensajeriaExpress.Services.EnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EnviosController {

    private EnviosService enviosService;

    @Autowired
    public EnviosController(EnviosService enviosService) {
        this.enviosService = enviosService;
    }


    @PostMapping("/envio")
    public EstadoEnvioDTO crearEnvio(@RequestBody Envio envio) {
        return this.enviosService.crearEnvio(envio);
    }

    @PostMapping("/envio/{numeroDeGuia}")
    public EstadoEnvioDTO  consultarUnEnvio(@PathVariable int numeroDeGuia){
        return this.enviosService.consultarUnEnvio(numeroDeGuia);
    }


    @PutMapping("/envio/{cedula}")
    public EdicionEstadoEnvioDTO actualizacionDeEnvio(ActualizarInformacionEnvio actualizarInformacionEnvio, DatosEmpleado empleado){
        return this.enviosService.actualizarEstadoEnvio(actualizarInformacionEnvio, empleado);
    }

    @PostMapping("/envios/{estadoDeEnvio}")
    public List<Envio> filtradoDeEnviosPorEstado(EstadoDeEnvio estadoDeEnvio, Integer cedula){
        return  this.enviosService.filtradoDeEnviosConEstado(estadoDeEnvio, cedula);
    }
}
