package com.example.MensajeriaExpress.Configurer.Controllers;


import com.example.MensajeriaExpress.DTO.EmpleadoDTO.Empleado;
import com.example.MensajeriaExpress.Services.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmpleadosController {

    private EmpleadosService empleadosService;
    @Autowired
    public EmpleadosController(EmpleadosService empleadosService) {
        this.empleadosService = empleadosService;
    }

    @PostMapping("/empleado")
    public Empleado crearEmpleado(Empleado empleado) {
        return this.empleadosService.crearEmpleado(empleado);
    }


    @PutMapping("/empleado")
    public Empleado editarEmpleado(Empleado empleado){
        return this.empleadosService.editarEmpleado(empleado);
    }

    @DeleteMapping("/empleado/{cedula}")
    public ResponseEntity<?> deleteEmpleado(@PathVariable Integer cedula){
        this.empleadosService.eliminarEmpleadoPorCedula(cedula);
        String message = "Empleado con cédula: "+cedula+", eliminado  con éxito.";
        return ResponseEntity.ok(message);
    }

    @PostMapping("/empleado/{cedula}")
    public Empleado consultarEmpleado(@PathVariable Integer cedula){
        return this.empleadosService.consultarUnEmpleado(cedula);
    }

    @PostMapping("/empleados")
    public List<Empleado> consultarEmpleados(){
        return this.empleadosService.consultarTodosLosEmpleados();
    }
}
