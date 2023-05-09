package com.example.MensajeriaExpress.DTO.EnvioDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CrearEnvioDTO {

    private Integer cedulaClienteDTO;
    private String ciudadOrigenDTO;
    private String ciudadDestinoDTO;
    private String direccionDestinoDTO;
    private String nombreRecibeDTO;
    private int celularDTO;
    private int valorDeclaradoDTO;
    private Double pesoDTO;
    //private Paquete paqueteDTO;
}
