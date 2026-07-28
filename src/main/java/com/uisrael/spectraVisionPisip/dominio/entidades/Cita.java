package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    private int idCita;
    private Cliente fkCliente;
    private LocalDate fecha;
    private LocalTime hora;
    private String tipoCita;
    private String estado;

    
    private String nombreCliente;

    public Cita(int idCita, Cliente fkCliente, LocalDate fecha,
                LocalTime hora, String tipoCita, String estado) {
        this.idCita = idCita;
        this.fkCliente = fkCliente;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoCita = tipoCita;
        this.estado = estado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Cliente getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}