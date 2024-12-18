package com.booking.Models.Reserva;

import java.util.Date;
import java.util.List;

public class ReservaImplementacion implements IReserva {
    private Date horaDeLlegada;
    private Integer cantidadHabitaciones;
    private List<ReservaData> reservaData;

    public ReservaImplementacion() {
    }

    public ReservaImplementacion(Date horaDeLlegada, Integer cantidadHabitaciones, List<ReservaData> reservaData) {
        this.horaDeLlegada = horaDeLlegada;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.reservaData = reservaData;
    }


    @Override
    public void crearReserva() {

    }

    @Override
    public void eliminarReserva() {

    }

    @Override
    public void modificarReserva() {

    }

    @Override
    public void consultarReserva() {

    }

    public void buscarHabitacion (){

    }

    public Date getHoraDeLlegada() {
        return horaDeLlegada;
    }

    public void setHoraDeLlegada(Date horaDeLlegada) {
        this.horaDeLlegada = horaDeLlegada;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public List<ReservaData> getReservaData() {
        return reservaData;
    }

    public void setReservaData(List<ReservaData> reservaData) {
        this.reservaData = reservaData;
    }
}
