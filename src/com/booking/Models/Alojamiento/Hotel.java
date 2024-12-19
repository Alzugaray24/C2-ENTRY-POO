package com.booking.Models.Alojamiento;

import java.util.Date;
import java.util.List;

import com.booking.Models.Habitacion.Habitacion;
import com.booking.Models.Reserva.ReservaData;

public class Hotel extends Alojamiento {

    public Hotel () {

    }

    public Hotel(String nombre, String ciudad, String tipoAlojamiento, Double precioBase, List<Habitacion> habitaciones, Float calificacion, Date fechaInicio, Date fechaFin, List<ReservaData<?>> registroReservas) {
        super(nombre, ciudad, tipoAlojamiento, precioBase, habitaciones, calificacion, fechaInicio, fechaFin, registroReservas);
    }

    @Override
    public String decorarAlojamiento() {
        return "Decorando hotel...";
    }

}