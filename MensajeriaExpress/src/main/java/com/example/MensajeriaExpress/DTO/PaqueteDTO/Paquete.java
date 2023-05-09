package com.example.MensajeriaExpress.DTO.PaqueteDTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "Paquetes")
public class Paquete {

    @Id
    @Column(name = "identificador")
    private int identificacionPaquete;

    @Column(name = "tipo")
    private static TipoDePaquete tipoDePaquete;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "valor")
    private int valorDeclarado;


    public Paquete() {
    }

    public Paquete(int identificacionPaquete, TipoDePaquete tipoDePaquete, Double peso, int valorDeclarado) {
        this.identificacionPaquete = identificacionPaquete;
        this.tipoDePaquete = tipoDePaquete;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }

    public void setIdentificacionPaquete(int identificacionPaquete) {
        this.identificacionPaquete = identificacionPaquete;
    }

    public void setTipoDePaquete(TipoDePaquete tipoDePaquete) {
        this.tipoDePaquete = tipoDePaquete;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setValorDeclarado(int valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public int getIdentificacionPaquete() {
        return identificacionPaquete;
    }

    public TipoDePaquete getTipoDePaquete() {
        return tipoDePaquete;
    }

    public Double getPeso() {
        return peso;
    }

    public int getValorDeclarado() {
        return valorDeclarado;
    }
}