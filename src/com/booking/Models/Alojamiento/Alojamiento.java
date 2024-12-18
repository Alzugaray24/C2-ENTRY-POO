package com.booking.Models.Alojamiento;

import com.booking.Models.Habitacion.Habitacion;

import java.util.Date;
import java.util.List;

public abstract class Alojamiento {

    private String nombre;
    private String ciudad;
    private String tipoAlojamiento;
    private Double precioBase;
    private List<Habitacion> habitaciones;
    private Float calificacion;
    private Date fechaInicio;
    private Date fechaFin;

    public Alojamiento() {

    }

    public Alojamiento(String nombre, Date fechaFin, Date fechaInicio, Double precioBase, List<Habitacion> habitaciones, String tipoAlojamiento, String ciudad, Float calificacion) {
        this.nombre = nombre;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.precioBase = precioBase;
        this.habitaciones = habitaciones;
        this.tipoAlojamiento = tipoAlojamiento;
        this.ciudad = ciudad;
        this.calificacion = calificacion;
    }


    public abstract String decorarAlojamiento();

    public String calcularPrecioTotal(int cantidadHabitaciones) {
        if (habitaciones.isEmpty()) {
            return "No hay habitaciones disponibles.";
        }

        double precioHabitacionSimple = habitaciones.stream()
                .mapToDouble(Habitacion::getPrecio)
                .min()
                .orElse(precioBase);

        double precioBaseTotal = precioHabitacionSimple * cantidadHabitaciones;

        double ajuste = calcularAjuste(precioBaseTotal);
        double precioFinal = precioBaseTotal + ajuste;

        return "Precio base por " + cantidadHabitaciones + " habitaciones: $" + precioBaseTotal + "\n" +
                (ajuste > 0 ? "Aumento aplicado: $" + ajuste : "Descuento aplicado: $" + ajuste) + "\n" +
                "Precio final: $" + precioFinal;
    }

    private double calcularAjuste(double precioBase) {
        int diaInicio = fechaInicio.getDate();
        int diaFin = fechaFin.getDate();

        if (diaFin > (fechaFin.getMonth() + 1 == 2 ? 28 : 30) - 5) {
            return precioBase * 0.15;
        }
        if (diaInicio >= 10 && diaFin <= 15) {
            return precioBase * 0.10;
        }
        if (diaInicio >= 5 && diaFin <= 10) {
            return -precioBase * 0.08;
        }

        return 0.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alojamiento:\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Ciudad: ").append(ciudad).append("\n");
        sb.append("Tipo de Alojamiento: ").append(tipoAlojamiento).append("\n");
        sb.append("Precio Base: $").append(precioBase).append("\n");
        sb.append("Fecha de Inicio: ").append(fechaInicio).append("\n");
        sb.append("Fecha de Fin: ").append(fechaFin).append("\n");
        sb.append("Habitaciones:\n");
        for (Habitacion habitacion : habitaciones) {
            sb.append(habitacion).append("\n");
        }
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(String tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }
}