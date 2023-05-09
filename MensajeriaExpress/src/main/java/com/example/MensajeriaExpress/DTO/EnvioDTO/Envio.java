package com.example.MensajeriaExpress.DTO.EnvioDTO;

import com.example.MensajeriaExpress.DTO.ClienteDTO.Cliente;
import com.example.MensajeriaExpress.DTO.PaqueteDTO.Paquete;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Envios")
public class Envio {

    @Id
    @Column(name="numeroguia")
    private int numeroDeGuia;

    @ManyToOne
    @JoinColumn(name = "Cliente")
    private Cliente cliente;

    @Column(name = "origen")
    private String ciudadOrigen;

    @Column(name = "cdestino")
    private String ciudadDestino;

    @Column(name = "ddestino")
    private String direccionDeDestino;

    @Column(name = "receptor")
    private String nombreRecetor;

    @Column(name = "celular")
    private int celularReceptor;

    @Column(name = "hora")
    private String horaDeEntrega;

    @Column(name = "estado")
    private EstadoDeEnvio estadoDelEnvio;

    @Column(name = "valor")
    private int valorDelEnvio;

    @OneToOne
    @JoinColumn(name = "paquete")
    private Paquete paquete;

    public Envio() {
    }

    public Envio(int numeroDeGuia, Cliente cliente, String ciudadOrigen, String ciudadDestino, String direccionDeDestino, String nombreRecetor, int celularReceptor, String horaDeEntrega, EstadoDeEnvio estadoDelEnvio, int valorDelEnvio, Paquete paquete) {
        this.numeroDeGuia = numeroDeGuia;
        this.cliente = cliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDeDestino = direccionDeDestino;
        this.nombreRecetor = nombreRecetor;
        this.celularReceptor = celularReceptor;
        this.horaDeEntrega = horaDeEntrega;
        this.estadoDelEnvio = estadoDelEnvio;
        this.valorDelEnvio = valorDelEnvio;
        this.paquete = paquete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public int getNumeroDeGuia() {
        return numeroDeGuia;
    }



    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public String getDireccionDeDestino() {
        return direccionDeDestino;
    }

    public String getNombreRecetor() {
        return nombreRecetor;
    }

    public int getCelularReceptor() {
        return celularReceptor;
    }

    public String getHoraDeEntrega() {
        return horaDeEntrega;
    }

    public EstadoDeEnvio getEstadoDelEnvio() {
        return estadoDelEnvio;
    }

    public int getValorDelEnvio() {
        return valorDelEnvio;
    }




    public void setNumeroDeGuia(int numeroDeGuia) {
        this.numeroDeGuia = numeroDeGuia;
    }



    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public void setDireccionDeDestino(String direccionDeDestino) {
        this.direccionDeDestino = direccionDeDestino;
    }

    public void setNombreRecetor(String nombreRecetor) {
        this.nombreRecetor = nombreRecetor;
    }

    public void setCelularReceptor(int celularReceptor) {
        this.celularReceptor = celularReceptor;
    }

    public void setHoraDeEntrega(String horaDeEntrega) {
        this.horaDeEntrega = horaDeEntrega;
    }

    public void setEstadoDelEnvio(EstadoDeEnvio estadoDelEnvio) {
        this.estadoDelEnvio = estadoDelEnvio;
    }

    public void setValorDelEnvio(int valorDelEnvio) {
        this.valorDelEnvio = valorDelEnvio;
    }

}