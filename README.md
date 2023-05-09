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

# Funcionalidades

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

continuará...
