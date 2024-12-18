package com.booking;

import com.booking.Models.Alojamiento.Alojamiento;
import com.booking.Models.Alojamiento.DiaDeSol;
import com.booking.Models.Alojamiento.Hotel;
import com.booking.Models.Habitacion.Habitacion;
import com.booking.Models.Reserva.ReservaImplementacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Crear lista de habitaciones para el primer hotel
        List<Habitacion> habitacionesHotel1 = new ArrayList<>();
        habitacionesHotel1.add(new Habitacion(
                Arrays.asList("Simple"),
                50.0,
                "Habitación básica con 1 cama individual",
                true,
                0,
                1,
                50.0
        ));
        habitacionesHotel1.add(new Habitacion(
                Arrays.asList("Doble", "Económica"),
                80.0,
                "Habitación con 2 camas individuales, básica y económica",
                true,
                1,
                2,
                80.0
        ));
        habitacionesHotel1.add(new Habitacion(
                Arrays.asList("Suite", "Premium"),
                200.0,
                "Suite con cama king, jacuzzi y vista al mar",
                true,
                2,
                2,
                200.0
        ));

        Calendar calendar = Calendar.getInstance();
        Date fechaInicio = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Date fechaFin = calendar.getTime();

        Hotel hotel1 = new Hotel("Hotel de la Ciudad", fechaFin, fechaInicio, 100.0, habitacionesHotel1, "Hotel", "Bogotá", 4.5f);
        DiaDeSol hotel2 = new DiaDeSol("Resort Frente al Mar", fechaFin, fechaInicio, 200.0, habitacionesHotel1, "DiaDeSol", "Miami", 4.9f, true, true);

        List<Alojamiento> listaHoteles = new ArrayList<>();
        listaHoteles.add(hotel1);
        listaHoteles.add(hotel2);

        ReservaImplementacion reserva = new ReservaImplementacion();

        try {
            reserva.buscarAlojamiento(listaHoteles);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}