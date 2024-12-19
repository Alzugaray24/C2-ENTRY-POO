package com.booking.Models.Alojamiento;

import com.booking.Models.Habitacion.Habitacion;
import com.booking.Models.Reserva.ReservaData;

import java.util.Date;
import java.util.List;

public class DiaDeSol extends Alojamiento {

    private Boolean incluyeAlmuerzo;
    private Boolean incluyeRefrigerio;

    public DiaDeSol() {
    }

    public DiaDeSol(String nombre, String ciudad, String tipoAlojamiento, Double precioBase, List<Habitacion> habitaciones, Float calificacion, Date fechaInicio, Date fechaFin, List<ReservaData<?>> registroReservas, Boolean incluyeAlmuerzo, Boolean incluyeRefrigerio) {
        super(nombre, ciudad, tipoAlojamiento, precioBase, habitaciones, calificacion, fechaInicio, fechaFin, registroReservas);
        this.incluyeAlmuerzo = incluyeAlmuerzo;
        this.incluyeRefrigerio = incluyeRefrigerio;
    }

    @Override
    public String decorarAlojamiento() {
        return "Decorando día de sol...";
    }


    public void mostrarInformacionDiaDeSol() {
        System.out.println("Nombre del alojamiento: " + getNombre());
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Calificación: " + getCalificacion());
        System.out.println("Precio base: $" + getPrecioBase());
        System.out.println("Incluye almuerzo: " + (incluyeAlmuerzo ? "Sí" : "No"));
        System.out.println("Incluye refrigerio: " + (incluyeRefrigerio ? "Sí" : "No"));
        System.out.println("Actividades disponibles: " + getActividades());
    }

    private String getActividades() {
        return "Piscina, Deportes, Spa, etc.";
    }
}