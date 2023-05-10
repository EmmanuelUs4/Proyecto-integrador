package com.example.MensajeriaExpress.Services;

import com.example.MensajeriaExpress.Exception.EmployeeNotFound;
import com.example.MensajeriaExpress.DTO.EmpleadoDTO.Empleado;
import com.example.MensajeriaExpress.Repository.EmpleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmpleadosService {
    private EmpleadosRepository empleadosRepository;
@Autowired
    public EmpleadosService(EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
    }

    public Empleado crearEmpleado(Empleado empleado){
        this.empleadosRepository.save(empleado);
        return empleado;
    }
    public Empleado editarEmpleado(Empleado empleado){
        this.consultarUnEmpleado(empleado.getCedula());
        this.empleadosRepository.save(empleado);
        return empleado;
    }

    public Boolean eliminarEmpleadoPorCedula(Integer cedula) {
        this.empleadosRepository.deleteById(cedula);
        return true;
    }

    public Empleado consultarUnEmpleado(Integer cedula)throws RuntimeException{
        Optional<Empleado> empleadoOptional = this.empleadosRepository.findById(cedula);
        if (!empleadoOptional.isPresent()){
            throw new EmployeeNotFound("NO se ha encontrado el empleado.");
        }
        return empleadoOptional.get();
    }

    public List<Empleado> consultarTodosLosEmpleados(){
        return this.empleadosRepository.findAll();
    }
}
