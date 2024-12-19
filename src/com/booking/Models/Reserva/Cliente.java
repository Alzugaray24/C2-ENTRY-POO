package com.booking.Models.Reserva;

import java.time.LocalDate;

public class Cliente {

    private String nombre;
    private String apellido;
    private String correo;
    private String numeroDeTelefono;
    private String nacionalidad;
    private LocalDate fechaDeNacimiento;
    private ReservaData<?> reservaData; // Reserva genérica

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String correo, String numeroDeTelefono,
                   String nacionalidad, LocalDate fechaDeNacimiento, ReservaData<?> reservaData) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numeroDeTelefono = numeroDeTelefono;
        this.nacionalidad = nacionalidad;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.reservaData = reservaData;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public ReservaData<?> getReservaData() {
        return reservaData;
    }

    public void setReservaData(ReservaData<?> reservaData) {
        this.reservaData = reservaData;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public void mostrarInformacionCliente() {
        System.out.println("Información del Cliente:");
        System.out.println("Nombre completo: " + getNombreCompleto());
        System.out.println("Correo: " + correo);
        System.out.println("Número de Teléfono: " + numeroDeTelefono);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Fecha de Nacimiento: " + fechaDeNacimiento);
        if (reservaData != null) {
            System.out.println("Datos de la Reserva:");
            reservaData.mostrarInformacionReserva();
        } else {
            System.out.println("No hay reservas asociadas.");
        }
    }
}