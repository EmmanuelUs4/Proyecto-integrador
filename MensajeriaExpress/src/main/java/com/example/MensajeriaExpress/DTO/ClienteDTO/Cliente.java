package com.example.MensajeriaExpress.DTO.ClienteDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    private int cedula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellidos;

    @Column(name = "celular")
    private int celular;

    @Column(name = "correo")
    private String correoElectronico;

    @Column(name = "direccion")
    private String direccionDeResidencia;

    @Column(name = "ciudad")
    private String ciudad;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Cliente(int cedula, String nombre, String apellidos, int celular, String correoElectronico, String direccionDeResidencia, String ciudad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.celular = celular;
        this.correoElectronico = correoElectronico;
        this.direccionDeResidencia = direccionDeResidencia;
        this.ciudad = ciudad;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
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

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
}
