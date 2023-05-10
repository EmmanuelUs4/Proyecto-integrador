package com.example.MensajeriaExpress.Services;

import com.example.MensajeriaExpress.DTO.EmpleadoDTO.Empleado;
import com.example.MensajeriaExpress.DTO.EmpleadoDTO.TipoDeEmpleado;
import com.example.MensajeriaExpress.DTO.EnvioDTO.*;
import com.example.MensajeriaExpress.DTO.PaqueteDTO.Paquete;
import com.example.MensajeriaExpress.DTO.ClienteDTO.Cliente;
import com.example.MensajeriaExpress.Exception.*;
import com.example.MensajeriaExpress.Repository.ClientesRepository;
import com.example.MensajeriaExpress.Repository.EmpleadosRepository;
import com.example.MensajeriaExpress.Repository.EnviosRepository;
import com.example.MensajeriaExpress.Repository.PaquetesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import static com.example.MensajeriaExpress.DTO.EnvioDTO.EstadoDeEnvio.*;

@Service
public class EnviosService {

    private EnviosRepository enviosRepository;
    private ClientesRepository clientesRepository;
    private PaquetesRepository paquetesRepository;
    private EmpleadosRepository empleadosRepository;

    private PaquetesService paquetesService;

    @Autowired
    public EnviosService(EnviosRepository enviosRepository, ClientesRepository clientesRepository, PaquetesRepository paquetesRepository, EmpleadosRepository empleadosRepository, PaquetesService paquetesService) {
        this.enviosRepository = enviosRepository;
        this.clientesRepository = clientesRepository;
        this.paquetesRepository = paquetesRepository;
        this.empleadosRepository = empleadosRepository;
        this.paquetesService = paquetesService;
    }



    public Paquete crearEnvioDePaquete(Paquete paquete){
        return this.paquetesService.crearPaquete(paquete);
    }



    public EstadoEnvioDTO crearEnvio(@RequestBody Envio envio) {
        Optional<Cliente> cliente = clientesRepository.findById(envio.getCliente().getCedula());
        Paquete paquete = crearEnvioDePaquete(envio.getPaquete());
        int identificadorPaquete = PaquetesService.generarCodigo();

        if (!cliente.isPresent()){
            throw new ClientNotFound("Cliente no encontrado.");
        }else {
            Envio envioDTO = new Envio(
                    identificadorPaquete,
                    envio.getCliente(),
                    envio.getCiudadOrigen(),
                    envio.getCiudadDestino(),
                    envio.getDireccionDeDestino(),
                    envio.getNombreRecetor(),
                    envio.getCelularReceptor(),
                    envio.getHoraDeEntrega(),
                    RECIBIDO,
                    envio.getValorDelEnvio(),
                    paquetesService.crearPaquete(paquete)
            );
            enviosRepository.save(envioDTO);
        }
        EstadoEnvioDTO   estadoEnvioDTO =   new EstadoEnvioDTO(identificadorPaquete, RECIBIDO);
        return estadoEnvioDTO;
    }


    public EstadoEnvioDTO consultarUnEnvio(int numeroDeGuia){
        Optional<Envio> envioOptional = this.enviosRepository.findById(numeroDeGuia);
        if (!envioOptional.isPresent()){
            throw new ShipmentNotFound("No se ha encontrado el envío solicitado.");
        }
        Envio envio = envioOptional.get();
        EstadoEnvioDTO estadoEnvioDTO = new EstadoEnvioDTO(numeroDeGuia, envio.getEstadoDelEnvio());
        return estadoEnvioDTO;
    }

    public EdicionEstadoEnvioDTO actualizarEstadoEnvio(ActualizarInformacionEnvio actualizarInformacionEnvio, DatosEmpleado empleado){
        Integer cedula= empleado.getCedula();
        Optional<Envio> envioOptional = this.enviosRepository.findById(actualizarInformacionEnvio.getNumeroDeGuiaDTO());
        Optional<Empleado> empleadoConfirmacion  = this.empleadosRepository.findById(cedula);
        Envio envio = envioOptional.get();
        if (cedula == null){
            throw new EmployeeNotFound("No se encontró la cédula del empleado.");
        }
        if (!envioOptional.isPresent()){
            throw new ShipmentNotFound("No se encontró el envío.");
        }
        if (!empleadoConfirmacion.isPresent()){
            throw new EmployeeNotFound( "El empleado con cedula: " +cedula+", no existe en nuestra compania");
        }


        if (envio.getEstadoDelEnvio()== RECIBIDO &&
                (empleado.getTipoDeEmpleado()==TipoDeEmpleado.COORDINADOR ||
                 empleado.getTipoDeEmpleado()==TipoDeEmpleado.REPARTIDOR)){

            envio.setEstadoDelEnvio(EN_RUTA);
            enviosRepository.save(envio);

            EdicionEstadoEnvioDTO edicionEstadoEnvioDTO = new EdicionEstadoEnvioDTO(
                    envio.getNumeroDeGuia(),
                    envio.getEstadoDelEnvio());

            return edicionEstadoEnvioDTO;
        }
        if (envio.getEstadoDelEnvio()== EN_RUTA &&
                (empleado.getTipoDeEmpleado()==TipoDeEmpleado.COORDINADOR ||
                 empleado.getTipoDeEmpleado()==TipoDeEmpleado.REPARTIDOR)){

            envio.setEstadoDelEnvio(ENTREGADO);
            enviosRepository.save(envio);

            EdicionEstadoEnvioDTO  edicionEstadoEnvioDTO = new EdicionEstadoEnvioDTO(
                    envio.getNumeroDeGuia(),
                    envio.getEstadoDelEnvio());

            return edicionEstadoEnvioDTO;
        }else {
            throw new ShipEditFailed(
                    "No se ha podido   realizar el cambio, " +
                            "el empleado no tiene los permisos necesarios " +
                            "o el estado del envío es inválido.");
        }

    }
    public List<Envio> filtradoDeEnviosConEstado(EstadoDeEnvio estadoDeEnvio, Integer cedula){
        Optional<Empleado>empleadoConfirm = this.empleadosRepository.findById(cedula);
        if (!empleadoConfirm.isPresent()){
            throw new EmployeeNotFound("No se encontró al empleado por cédula ingresado.");
        }
        List<Envio> enviosConEstado = enviosRepository.findByEstadoDelEnvio(estadoDeEnvio);
        return enviosRepository.findByEstadoDelEnvio(estadoDeEnvio);
    }
}
/*


Paste para crear envios rápidamente

    {
  "celularReceptor": 1,
  "ciudadDestino": "Rionegro",
  "ciudadOrigen": "Medellin",
  "cliente": {
    "apellidos": "Usme",
    "cedula": 1,
    "celular": 1,
    "ciudad": "Rionegro",
    "correoElectronico": "correo@gmail.com",
    "direccionDeResidencia": "Si",
    "nombre": "Emmanuel"
  },
  "direccionDeDestino": "Si",
  "estadoDelEnvio": "RECIBIDO",
  "horaDeEntrega": "20:20",
  "nombreRecetor": "Emmanuel",
  "numeroDeGuia": 0,
  "paquete": {
    "identificacionPaquete": 0,
    "peso": 7,
    "tipoDePaquete": "LIVIANO",
    "valorDeclarado": 0
  },
  "valorDelEnvio": 10000
}



*/