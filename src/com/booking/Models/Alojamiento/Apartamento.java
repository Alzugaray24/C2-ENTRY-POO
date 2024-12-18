package com.booking.Models.Alojamiento;

import com.booking.Models.Habitacion.Habitacion;

import java.util.Date;
import java.util.List;

public class Apartamento extends Alojamiento {

    public Apartamento() {

    }

    public Apartamento(String nombre, Date fechaFin, Date fechaInicio, Double precioBase, List<Habitacion> habitaciones, String tipoAlojamiento, String ciudad, Float calificacion) {
        super(nombre, fechaFin, fechaInicio, precioBase, habitaciones, tipoAlojamiento, ciudad, calificacion);
    }

    @Override
    public String decorarAlojamiento() {
        return "Decorando apartamento...";
    }

}
