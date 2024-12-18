package com.booking.Models.Reserva;

import com.booking.Models.Alojamiento.Alojamiento;

import java.util.List;

public interface IReserva {

    public void crearReserva();

    public void eliminarReserva();

    public void modificarReserva();

    public void consultarReserva();

    public void buscarAlojamiento(List<Alojamiento> alojamientos);
}
