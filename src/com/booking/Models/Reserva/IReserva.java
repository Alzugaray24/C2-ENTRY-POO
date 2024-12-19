package com.booking.Models.Reserva;

import com.booking.Models.Alojamiento.Alojamiento;

import java.util.Date;
import java.util.List;

public interface IReserva {

    public void crearReserva(List<ReservaData> reservaData, Integer cantidadHabitaciones, Date horaDeLlegada);

    public void eliminarReserva();

    public void modificarReserva();

    public void consultarReserva();

    public void buscarAlojamiento(List<Alojamiento> alojamientos);
}
