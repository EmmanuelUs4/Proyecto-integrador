package com.example.MensajeriaExpress.Services;

import com.example.MensajeriaExpress.DTO.PaqueteDTO.Paquete;
import com.example.MensajeriaExpress.DTO.PaqueteDTO.TipoDePaquete;
import com.example.MensajeriaExpress.Exception.InvalidPackageWeight;
import com.example.MensajeriaExpress.Repository.PaquetesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class PaquetesService {

    private static final Integer PESO_LIVIANO=30000;
    private static final Integer PESO_MEDIANO=40000;
    private static final Integer PESO_GRANDE=50000;
    private static final String CODIGO_DIGITOS="0123456789";



    private PaquetesRepository paquetesRepository;

    @Autowired
    public PaquetesService(PaquetesRepository paquetesRepository) {
        this.paquetesRepository = paquetesRepository;
    }

    public static int generarCodigo(){
        Random rnd = new Random();
        int codigo = 1000000000 + rnd.nextInt(900000000);
        return codigo;
    }


    private TipoDePaquete tipoPaquete(Double peso){
        if (peso < 2) {
            return TipoDePaquete.LIVIANO;
        }else if (peso < 5){
            return TipoDePaquete.MEDIANO;
        }else if(peso > 5){
            return TipoDePaquete.GRANDE;
        }else{
            throw new InvalidPackageWeight("Algo ha ocurrido con el peso");
        }
    }

    private int valorDelPaquete(Double peso, TipoDePaquete tipoPaquete){
        switch (tipoPaquete){
            case LIVIANO: return PESO_LIVIANO;
            case MEDIANO: return PESO_MEDIANO;
            case GRANDE: return PESO_GRANDE;
            default: throw new InvalidPackageWeight("Algo salió mal  asignando el valor");
        }
    }

    public  Paquete crearPaquete(Paquete paquete){
        int identificadorPaquete =  generarCodigo();
        paquete.setIdentificacionPaquete(identificadorPaquete);

        TipoDePaquete tipo = tipoPaquete(paquete.getPeso());
        paquete.setTipoDePaquete(tipo);

        int valorDelPaquete = valorDelPaquete(paquete.getPeso(), tipo);
        paquete.setValorDeclarado(valorDelPaquete);

        this.paquetesRepository.save(paquete);
        return paquete;
    }
}

