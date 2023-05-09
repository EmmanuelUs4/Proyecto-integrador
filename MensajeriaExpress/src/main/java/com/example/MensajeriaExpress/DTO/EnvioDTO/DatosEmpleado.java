package com.example.MensajeriaExpress.DTO.EnvioDTO;

import com.example.MensajeriaExpress.DTO.EmpleadoDTO.TipoDeEmpleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class DatosEmpleado {
    private Integer cedula;

    private TipoDeEmpleado tipoDeEmpleado;
}
