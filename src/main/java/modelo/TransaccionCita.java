/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.CitaDAO;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 *
 * @author march
 */
public class TransaccionCita {
    private Cita cita;
    private LocalDateTime fechaHora;
    private String estadoAnterior;
    private String estadoActual;
    private Persona user;

    public TransaccionCita() {
        this.cita = new Cita();
        this.fechaHora = LocalDateTime.now();
        this.estadoAnterior = "";
        this.estadoActual = "";
        this.user = new Usuario();
    }
    
    public TransaccionCita(Cita cita, LocalDateTime fechaHora, String estadoAnterior, String estadoActual, Persona user) {
        this.cita = cita;
        this.fechaHora = fechaHora;
        this.estadoAnterior = estadoAnterior;
        this.estadoActual = estadoActual;
        this.user = user;
    }
    
    public static LinkedList<TransaccionCita> getListado() {
        try {
            return CitaDAO.obtenerCitalog();
        } catch (SQLException e) {
            return null;
        }
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Persona getUser() {
        return user;
    }

    public void setUser(Persona user) {
        this.user = user;
    }
    
    
    
}
