package com.booking.Models.Alojamiento;

import com.booking.Models.Habitacion.Habitacion;

import java.util.Date;
import java.util.List;

public class DiaDeSol extends Alojamiento {

    private Boolean incluyeAlmuerzo;
    private Boolean incluyeRefrigerio;

    public DiaDeSol() {
    }

    public DiaDeSol(String nombre, Date fechaFin, Date fechaInicio, Double precioBase, List<Habitacion> habitaciones, String tipoAlojamiento, String ciudad) {
        super(nombre, fechaFin, fechaInicio, precioBase, habitaciones, tipoAlojamiento, ciudad);
    }

    @Override
    public String decorarAlojamiento() {
        return "";
    }
}
