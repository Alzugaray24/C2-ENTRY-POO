package com.booking.Models.Alojamiento;

import com.booking.Models.Habitacion.Habitacion;

import java.util.Date;
import java.util.List;

public class DiaDeSol extends Alojamiento {

    private Boolean incluyeAlmuerzo;
    private Boolean incluyeRefrigerio;

    public DiaDeSol() {
    }

    public DiaDeSol(String nombre, Date fechaFin, Date fechaInicio, Double precioBase, List<Habitacion> habitaciones, String tipoAlojamiento, String ciudad, Float calificacion, Boolean incluyeAlmuerzo, Boolean incluyeRefrigerio) {
        super(nombre, fechaFin, fechaInicio, precioBase, habitaciones, tipoAlojamiento, ciudad, calificacion);
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
        // Aquí puedes agregar la lógica para obtener las actividades disponibles en el alojamiento
        return "Piscina, Deportes, Spa, etc.";
    }
}