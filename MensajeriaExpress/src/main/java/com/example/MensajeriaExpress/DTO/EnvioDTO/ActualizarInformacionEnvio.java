package com.example.MensajeriaExpress.DTO.EnvioDTO;

import com.example.MensajeriaExpress.DTO.EmpleadoDTO.Empleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ActualizarInformacionEnvio {
    private int numeroDeGuiaDTO;

    private EstadoDeEnvio estadoDeEnvio;



}
