package com.booking.Models.Reserva;

import com.booking.Models.Alojamiento.Alojamiento;
import com.booking.Models.Alojamiento.DiaDeSol;

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
        System.out.println("se creo una reserva");
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

    @Override
    public void buscarAlojamiento(List<Alojamiento> alojamientos) {
        List<String> tiposPermitidos = List.of("Hotel", "Apartamento", "Finca", "DiaDeSol");
        for (Alojamiento alojamiento : alojamientos) {
            if (tiposPermitidos.contains(alojamiento.getTipoAlojamiento())) {
                if (alojamiento.getTipoAlojamiento().equals("DiaDeSol")) {
                    DiaDeSol diaDeSol = (DiaDeSol) alojamiento;
                    diaDeSol.mostrarInformacionDiaDeSol();

                    System.out.println(" ------------------------------------------------------------ ");
                } else {
                    String nombre = alojamiento.getNombre();
                    Float calificacion = alojamiento.getCalificacion();
                    Double precioPorNoche = alojamiento.getPrecioBase();
                    long diasEstadia = (alojamiento.getFechaFin().getTime() - alojamiento.getFechaInicio().getTime()) / (1000 * 60 * 60 * 24);
                    Double precioCalculado = precioPorNoche * diasEstadia;

                    String precioTotal = alojamiento.calcularPrecioTotal(alojamiento.getHabitaciones().size());

                    System.out.println("Nombre del hotel: " + nombre);
                    System.out.println("Calificación: " + calificacion);
                    System.out.println("Precio por noche: $" + precioPorNoche);
                    System.out.println("Precio calculado por " + diasEstadia + " días de estadía: $" + precioCalculado);
                    System.out.println(precioTotal);

                    System.out.println(" ------------------------------------------------------------ ");
                }
            } else {
                throw new IllegalArgumentException("Tipo de alojamiento no permitido: " + alojamiento.getTipoAlojamiento());
            }
        }
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
