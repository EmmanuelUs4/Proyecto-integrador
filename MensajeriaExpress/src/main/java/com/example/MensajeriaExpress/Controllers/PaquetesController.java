package com.example.MensajeriaExpress.Controllers;

import com.example.MensajeriaExpress.DTO.PaqueteDTO.Paquete;
import com.example.MensajeriaExpress.Services.PaquetesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PaquetesController {

private PaquetesService paquetesService;
@Autowired
    public PaquetesController(PaquetesService paquetesService) {
        this.paquetesService = paquetesService;
    }

    @PostMapping("/paquete")
    public Paquete crearPaquete(@RequestParam("peso") String pesoString){
    Double peso = Double.parseDouble(pesoString);
    Paquete paquete = new Paquete();
    paquete.setPeso(peso);
    return this.paquetesService.crearPaquete(paquete);
    }

}
