package com.example.MensajeriaExpress.DTO.EnvioDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ConsultarEnvioDTO {
    private int numeroDeGuia;
    private EstadoDeEnvio estadoDeEnvio;

}
