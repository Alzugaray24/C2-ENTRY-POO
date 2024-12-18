package com.booking.Models.Habitacion;

import java.util.List;

public class Habitacion {

    private List<String> tipoDeHabitacion;
    private double precio;
    private String descripcion;
    private boolean disponibilidad;
    private int cantidadMenores;
    private int cantidadAdultos;
    private double precioBase;

    public Habitacion() {
    }

    public Habitacion(List<String> tipoDeHabitacion, double precio, String descripcion, boolean disponibilidad,
                      int cantidadMenores, int cantidadAdultos, double precioBase) {
        this.tipoDeHabitacion = tipoDeHabitacion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.cantidadMenores = cantidadMenores;
        this.cantidadAdultos = cantidadAdultos;
        this.precioBase = precioBase;
    }


    public void mostrarInformacion() {
        System.out.println("Información de la Habitación:");
        System.out.println("Tipo de Habitación: " + tipoDeHabitacion);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio Base: $" + precioBase);
        System.out.println("Precio Total: $" + precio);
        System.out.println("Capacidad: " + cantidadAdultos + " adultos, " + cantidadMenores + " menores");
    }

    @Override
    public String toString() {
        return "Habitacion:\n" +
                "  Tipo de Habitación: " + tipoDeHabitacion + "\n" +
                "  Descripción: " + descripcion + "\n" +
                "  Precio Base: $" + precioBase + "\n" +
                "  Precio Total: $" + precio + "\n" +
                "  Disponibilidad: " + (disponibilidad ? "Disponible" : "No Disponible") + "\n" +
                "  Capacidad: " + cantidadAdultos + " adultos, " + cantidadMenores + " menores";
    }

    public void mostrarDisponibilidad() {
        String estado = disponibilidad ? "Disponible" : "No Disponible";
        System.out.println("Disponibilidad: " + estado);
    }

    public List<String> getTipoDeHabitacion() {
        return tipoDeHabitacion;
    }

    public void setTipoDeHabitacion(List<String> tipoDeHabitacion) {
        this.tipoDeHabitacion = tipoDeHabitacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getCantidadMenores() {
        return cantidadMenores;
    }

    public void setCantidadMenores(int cantidadMenores) {
        this.cantidadMenores = cantidadMenores;
    }

    public int getCantidadAdultos() {
        return cantidadAdultos;
    }

    public void setCantidadAdultos(int cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
}