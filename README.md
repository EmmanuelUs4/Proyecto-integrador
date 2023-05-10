# Proyecto-Mensajeria

# Problemática

Se requiere crear un servicio que ofrezca a una empresa (Mensajería Express), registrar, editar, eliminar y consultar clientes;
registrar, editar, eliminar y consultar empleados; crear, editar y consultar envios  y crear paquetes. 

# Descripción del microservicio

Este microservicio permite a Mensajería Express poder registras clientes y manejar sus datos, al igual que para los empleados y los envíos de clientes. Todo esto para cumplir con la función de mensajería de paquetes,  llevando  un registro de los clientes, los paquetes, envíos y empleados.

# Tecnologías

-SpringBoot
-SpringJPA
-H2
-Java
-Swagger

# Funcionalidades acerca del cliente

@PostMapping

crearUnCliente{ Este método nos permite registrar un cliente, ingresando sus datos
     "cedula":"",
     "nombre":"",
     "apellidos":"",
     "celular":"",
     "correoElectronico":"",
     "direccionDeResidencia":"",
     "ciudad":"",
}

consultarUnCliente(Integer cedula){Este método nos permite consultar un cliente a través de su  cédula, el cliente debe estar registrado previamente}

consultarClientes(){Este método nos permite consultar todos los clientes registrados}

@PutMapping

editarUnCliente(Integer cedula){ Este método nos permite editar un cliente previamente registrado a través de su cédula
     
     "cedula":"",
     "nombre":"",
     "apellidos":"",
     "celular":"",
     "correoElectronico":"",
     "direccionDeResidencia":"",
     "ciudad":"",
}

@DeleteMapping

eliminarUnCliente(Integer cedula) {Este método permite eliminar un cliente a través de su cédula}

# Funcionalidades acerca del empleado

@PostMapping

crearEmpleado(Empleado empleado) {Permite crear un empleado
     
     "cedula":"",
     "nombreDelEmpleado":"",
     "apellidoDelEmpleado":"",
     "celular":"",
     "correoElectronico":"",
     "direccionDeResidencia":"",
     "ciudad":"",
     "antiguedadEnLaEmpresa":"",
     "tipoDeSangre":"",
     "tipoDeEmpleado":""

}

Empleado consultarEmpleado(@PathVariable Integer cedula){Mediante una cédula, podremos consultar el empleado
     "cedula":""
}

List<Empleado> consultarEmpleados(){Consultar todos los empleados, ejemplo del retorno:
     
     [
          {
          "cedula":"",
          "nombreDelEmpleado":"",
          "apellidoDelEmpleado":"",
          "celular":"",
          "correoElectronico":"",
          "direccionDeResidencia":"",
          "ciudad":"",
          "antiguedadEnLaEmpresa":"",
          "tipoDeSangre":"",
          "tipoDeEmpleado":""
          },
          {
          "cedula":"",
          "nombreDelEmpleado":"",
          "apellidoDelEmpleado":"",
          "celular":"",
          "correoElectronico":"",
          "direccionDeResidencia":"",
          "ciudad":"",
          "antiguedadEnLaEmpresa":"",
          "tipoDeSangre":"",
          "tipoDeEmpleado":""
          }
     ]
}


@PutMapping
     
     
Empleado editarEmpleado(Empleado empleado){editar un empleado}


@DeleteMapping

ResponseEntity<?> deleteEmpleado(@PathVariable Integer cedula){eliminar un empleado apartir de su cédula}


# Funcionalidades acerca del Envio

@PostMapping

crearEnvio(@RequestBody Envio envio){Con esta funcionalidad podremos crear un envio, ejemplo de creacion:

          {
               "celularReceptor": 0,
               "ciudadDestino": "string",
               "ciudadOrigen": "string",
               "cliente": {
               "apellidos": "string",
               "cedula": 0,
               "celular": 0,
               "ciudad": "string",
               "correoElectronico": "string",
               "direccionDeResidencia": "string",
               "nombre": "string"
          },
               "direccionDeDestino": "string",
               "estadoDelEnvio": "RECIBIDO",
               "horaDeEntrega": "string",
               "nombreRecetor": "string",
               "numeroDeGuia": 0,
               "paquete": {
                    "identificacionPaquete": 0,
                    "peso": 0,
                    "tipoDePaquete": "LIVIANO",
                    "valorDeclarado": 0
          },
               "valorDelEnvio": 0
          }

}


consultarUnEnvio(@PathVariable int numeroDeGuia, Envio envio){Consultar un  envío empleado el numero de guía}

filtradoDeEnviosPorEstado(EstadoDeEnvio estadoDeEnvio, Integer cedula){filtrar envios de acuerdo a su estado: RECIBIDO / EN_RUTA / ENTREGADO}

@PutMapping

EdicionEstadoEnvioDTO actualizacionDeEnvio(ActualizarInformacionEnvio actualizarInformacionEnvio, DatosEmpleado empleado){Editar el estado a través de su numero de guía y basándose en el rol del empleado pues, solo los REPARTIDOR y COORDINADOR pueden realizar cambios}


# Diagrama general del Cliente
![Diagrama general de Cliente drawio](https://github.com/EmmanuelUs4/Proyecto-integrador/assets/120135105/5009b55a-ef1b-4d62-b3c6-b3eee3abab19)

# Diagrama general del Empleado
![Diagrama general de Empleado drawio](https://github.com/EmmanuelUs4/Proyecto-integrador/assets/120135105/754515e0-c3f5-4c73-a6a8-a8cf476f9092)

# Diagrama general del Paquete
![Diagrama general de Paquete drawio](https://github.com/EmmanuelUs4/Proyecto-integrador/assets/120135105/b9b6f2d0-2944-411b-b94e-cb5874acd4e3)

# Diagrama general del Envio
![Diagrama general de Envios drawio](https://github.com/EmmanuelUs4/Proyecto-integrador/assets/120135105/9900729e-9f31-4b77-9350-2c82ada7136d)







