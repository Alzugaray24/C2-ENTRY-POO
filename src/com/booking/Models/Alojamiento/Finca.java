package com.booking.Models.Alojamiento;

import java.util.Date;
import java.util.List;

import com.booking.Models.Habitacion.Habitacion;

public class Finca extends Alojamiento {

    public Finca() {

    }

    public Finca(String nombre, Date fechaFin, Date fechaInicio, Double precioBase, List<Habitacion> habitaciones, String tipoAlojamiento, String ciudad) {
        super(nombre, fechaFin, fechaInicio, precioBase, habitaciones, tipoAlojamiento, ciudad);
    }

    @Override
    public String decorarAlojamiento() {
        return "";
    }
}
