package Models;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    // Atributos
    private String nombre;
    private String ciudad;
    private TipoAlojamiento tipoAlojamiento;
    private double calificacion; // del 1 al 5
    private boolean incluyeAlmuerzo; // para Dia de Sol
    private List<Habitacion> habitaciones;
    private List<Reservacion> reservas;

    // Constructor
    public Hotel(String nombre, String ciudad, TipoAlojamiento tipoAlojamiento, double calificacion, boolean incluyeAlmuerzo) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipoAlojamiento = tipoAlojamiento;
        this.calificacion = calificacion;
        this.incluyeAlmuerzo = incluyeAlmuerzo;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public TipoAlojamiento getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(TipoAlojamiento tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        if (calificacion >= 1 && calificacion <= 5) {
            this.calificacion = calificacion;
        } else {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5");
        }
    }

    public boolean isIncluyeAlmuerzo() {
        return incluyeAlmuerzo;
    }

    public void setIncluyeAlmuerzo(boolean incluyeAlmuerzo) {
        this.incluyeAlmuerzo = incluyeAlmuerzo;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<Reservacion> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservacion> reservas) {
        this.reservas = reservas;
    }

    // Métodos adicionales para agregar habitaciones y reservas
    public void agregarHabitacion(Habitacion habitacion) {
        this.habitaciones.add(habitacion);
    }

    public void agregarReservacion(Reservacion reservacion) {
        this.reservas.add(reservacion);
    }
}