package com.booking;

import com.booking.Models.Alojamiento.Alojamiento;
import com.booking.Models.Alojamiento.Hotel;
import com.booking.Models.Habitacion.Habitacion;
import com.booking.Models.Reserva.Cliente;
import com.booking.Models.Reserva.ReservaData;
import com.booking.Models.Reserva.ReservaImplementacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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

        // Crear el segundo hotel con sus habitaciones
        List<Habitacion> habitacionesHotel2 = new ArrayList<>();
        habitacionesHotel2.add(new Habitacion(
                Arrays.asList("Simple"),
                60.0,
                "Habitación estándar con cama individual",
                true,
                0,
                1,
                60.0
        ));
        habitacionesHotel2.add(new Habitacion(
                Arrays.asList("Doble"),
                120.0,
                "Habitación con cama doble, ideal para parejas",
                true,
                0,
                2,
                120.0
        ));
        habitacionesHotel2.add(new Habitacion(
                Arrays.asList("Suite"),
                300.0,
                "Suite de lujo con todas las comodidades",
                true,
                2,
                3,
                300.0
        ));

        Calendar calendar = Calendar.getInstance();
        Date fechaInicio = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Date fechaFin = calendar.getTime();

        List<ReservaData<?>> registroReservas1 = new ArrayList<>();
        List<ReservaData<?>> registroReservas2 = new ArrayList<>();

        Hotel hotel1 = new Hotel("Hotel de la Ciudad", "Bogotá", "Hotel", 100.0, habitacionesHotel1, 4.5f, fechaInicio, fechaFin, registroReservas1);
        Hotel hotel2 = new Hotel("Hotel Playa Sol", "Cartagena", "Hotel", 150.0, habitacionesHotel2, 4.8f, fechaInicio, fechaFin, registroReservas2);

        List<Alojamiento> listaHoteles = new ArrayList<>();
        listaHoteles.add(hotel1);
        listaHoteles.add(hotel2);

        ReservaData<Hotel> reservaData1 = new ReservaData<>(null, hotel1);

        Cliente cliente1 = new Cliente(
                "Juan",
                "Pérez",
                "juan.perez@example.com",
                "123456789",
                "Colombia",
                LocalDate.of(1990, 5, 20),
                reservaData1
        );

        reservaData1.setUsuario(cliente1);

        ReservaImplementacion reserva = new ReservaImplementacion();

        try {
            System.out.println("=== Búsqueda de Alojamientos ===");
            reserva.buscarAlojamiento(listaHoteles);

            System.out.println("\n=== Confirmación de Habitaciones ===");
            hotel1.confirmarHabitaciones(habitacionesHotel1, fechaInicio, fechaFin, 2, 1, 2);

            System.out.println("\n=== Creación de Reserva ===");
            reserva.crearReserva(List.of(reservaData1), 2, fechaInicio);

            System.out.println("\n=== Información de la Reserva ===");
            reservaData1.mostrarInformacionReserva();

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}