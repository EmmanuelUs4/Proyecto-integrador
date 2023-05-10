package com.example.MensajeriaExpress.DTO.EmpleadoDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado{

    @Id
    private Integer cedula;

    @Column(name = "nombre")
    private String nombreDelEmpleado;

    @Column(name = "apellido")
    private String apellidoDelEmpleado;

    @Column(name = "celular")
    private int celular;

    @Column(name = "correo")
    private String correoElectronico;

    @Column(name = "direccion")
    private String direccionDeResidencia;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "antiguedad")
    private String antiguedadEnLaEmpresa;

    @Column(name = "sangre")
    private String tipoDeSangre;

    @Column(name = "tipo")
    private TipoDeEmpleado tipoDeEmpleado;

    public Empleado() {
    }

    public Empleado(Integer cedula, String nombreDelEmpleado, String apellidoDelEmpleado) {
        this.cedula = cedula;
        this.nombreDelEmpleado = nombreDelEmpleado;
        this.apellidoDelEmpleado = apellidoDelEmpleado;
    }

    public Empleado(int cedula, String nombreDelEmpleado, String apellidoDelEmpleado, int celular, String correoElectronico, String direccionDeResidencia, String ciudad, String antiguedadEnLaEmpresa, String tipoDeSangre, TipoDeEmpleado tipoDeEmpleado) {
        this.cedula = cedula;
        this.nombreDelEmpleado = nombreDelEmpleado;
        this.apellidoDelEmpleado = apellidoDelEmpleado;
        this.celular = celular;
        this.correoElectronico = correoElectronico;
        this.direccionDeResidencia = direccionDeResidencia;
        this.ciudad = ciudad;
        this.antiguedadEnLaEmpresa = antiguedadEnLaEmpresa;
        this.tipoDeSangre = tipoDeSangre;
        this.tipoDeEmpleado = tipoDeEmpleado;
    }

    public Integer getCedula() {
        return cedula;
    }

    public String getNombreDelEmpleado() {
        return nombreDelEmpleado;
    }

    public String getApellidoDelEmpleado() {
        return apellidoDelEmpleado;
    }

    public int getCelular() {
        return celular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getDireccionDeResidencia() {
        return direccionDeResidencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getAntiguedadEnLaEmpresa() {
        return antiguedadEnLaEmpresa;
    }

    public String getTipoDeSangre() {
        return tipoDeSangre;
    }

    public  TipoDeEmpleado getTipoDeEmpleado() {
        return tipoDeEmpleado;
    }


    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public void setNombreDelEmpleado(String nombreDelEmpleado) {
        this.nombreDelEmpleado = nombreDelEmpleado;
    }

    public void setApellidoDelEmpleado(String apellidoDelEmpleado) {
        this.apellidoDelEmpleado = apellidoDelEmpleado;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setDireccionDeResidencia(String direccionDeResidencia) {
        this.direccionDeResidencia = direccionDeResidencia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setAntiguedadEnLaEmpresa(String antiguedadEnLaEmpresa) {
        this.antiguedadEnLaEmpresa = antiguedadEnLaEmpresa;
    }

    public void setTipoDeSangre(String tipoDeSangre) {
        this.tipoDeSangre = tipoDeSangre;
    }

    public void setTipoDeEmpleado(TipoDeEmpleado tipoDeEmpleado) {
        this.tipoDeEmpleado = tipoDeEmpleado;
    }
}