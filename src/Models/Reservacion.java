package Models;

import java.time.LocalDate;

public class Reservacion {
    // Atributos
    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private String nacionalidad;
    private String numeroTelefono;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int cantidadAdultos;
    private int cantidadNinos;
    private int cantidadHabitaciones;
    private String tipoHabitacion;
    private String horaLlegada;

    // Constructor
    public Reservacion(String nombreCliente, String apellidoCliente, String emailCliente,
                       String nacionalidad, String numeroTelefono, LocalDate fechaInicio,
                       LocalDate fechaFin, int cantidadAdultos, int cantidadNinos,
                       int cantidadHabitaciones, String tipoHabitacion, String horaLlegada) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.emailCliente = emailCliente;
        this.nacionalidad = nacionalidad;
        this.numeroTelefono = numeroTelefono;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadNinos = cantidadNinos;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.tipoHabitacion = tipoHabitacion;
        this.horaLlegada = horaLlegada;
    }

    // Getters y Setters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantidadAdultos() {
        return cantidadAdultos;
    }

    public void setCantidadAdultos(int cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }

    public int getCantidadNinos() {
        return cantidadNinos;
    }

    public void setCantidadNinos(int cantidadNinos) {
        this.cantidadNinos = cantidadNinos;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
}