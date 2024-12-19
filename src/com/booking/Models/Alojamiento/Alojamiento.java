package com.booking.Models.Alojamiento;

import com.booking.Models.Habitacion.Habitacion;
import com.booking.Models.Reserva.ReservaData;  

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public abstract class Alojamiento {

    private String nombre;
    private String ciudad;
    private String tipoAlojamiento;
    private Double precioBase;
    private List<Habitacion> habitaciones;
    private Float calificacion;
    private Date fechaInicio;
    private Date fechaFin;
    private List<ReservaData<?>> registroReservas;

    public Alojamiento() {

    }

    public Alojamiento(String nombre, String ciudad, String tipoAlojamiento, Double precioBase, List<Habitacion> habitaciones, Float calificacion, Date fechaInicio, Date fechaFin, List<ReservaData<?>> registroReservas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipoAlojamiento = tipoAlojamiento;
        this.precioBase = precioBase;
        this.habitaciones = habitaciones;
        this.calificacion = calificacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.registroReservas = registroReservas;
    }

    public Alojamiento(String nombre, Date fechaFin, Date fechaInicio, Double precioBase, List<Habitacion> habitaciones, String tipoAlojamiento, String ciudad, Float calificacion) {
    }

    public abstract String decorarAlojamiento();

    public void agregarReserva(ReservaData<?> reserva) {
        this.registroReservas.add(reserva);
    }

    public void mostrarRegistroReservas() {
        System.out.println("Registro de Reservas para el Hotel: " + this.getNombre());
        if (registroReservas.isEmpty()) {
            System.out.println("No hay reservas realizadas.");
        } else {
            for (ReservaData<?> reserva : registroReservas) {
                reserva.mostrarInformacionReserva();
            }
        }
    }

    public List<ReservaData<?>> getRegistroReservas() {
        return registroReservas;
    }

    public String calcularPrecioTotal(int cantidadHabitaciones) {
        if (habitaciones.isEmpty()) {
            return "No hay habitaciones disponibles.";
        }

        double precioHabitacionSimple = habitaciones.stream()
                .mapToDouble(Habitacion::getPrecio)
                .min()
                .orElse(precioBase);

        double precioBaseTotal = precioHabitacionSimple * cantidadHabitaciones;

        double ajuste = calcularAjuste(precioBaseTotal);
        double precioFinal = precioBaseTotal + ajuste;

        return "Precio base por " + cantidadHabitaciones + " habitaciones: $" + precioBaseTotal + "\n" +
                (ajuste > 0 ? "Aumento aplicado: $" + ajuste : "Descuento aplicado: $" + ajuste) + "\n" +
                "Precio final: $" + precioFinal;
    }

    private double calcularAjuste(double precioBase) {
        int diaInicio = fechaInicio.getDate();
        int diaFin = fechaFin.getDate();

        if (diaFin > (fechaFin.getMonth() + 1 == 2 ? 28 : 30) - 5) {
            return precioBase * 0.15;
        }
        if (diaInicio >= 10 && diaFin <= 15) {
            return precioBase * 0.10;
        }
        if (diaInicio >= 5 && diaFin <= 10) {
            return -precioBase * 0.08;
        }

        return 0.0;
    }

    public void confirmarHabitaciones(List<Habitacion> habitaciones, Date startDate, Date endDate,
                                      int adultos, int ninos, int habitacionesRequeridas) {
        // Validar los parámetros de entrada
        if (habitaciones == null || habitaciones.isEmpty()) {
            throw new IllegalArgumentException("La lista de habitaciones no puede estar vacía.");
        }
        if (startDate == null || endDate == null || startDate.compareTo(endDate) >= 0) {
            throw new IllegalArgumentException("Las fechas de inicio y fin no son válidas.");
        }
        if (adultos < 0 || ninos < 0 || habitacionesRequeridas <= 0) {
            throw new IllegalArgumentException("Los valores de adultos, niños o habitaciones son inválidos.");
        }

        // Filtrar habitaciones disponibles
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponibilidad() &&
                    habitacion.getCantidadAdultos() >= adultos &&
                    habitacion.getCantidadMenores() >= ninos) {
                habitacionesDisponibles.add(habitacion);
            }
        }

        // Verificar si hay suficientes habitaciones disponibles
        if (habitacionesDisponibles.size() < habitacionesRequeridas) {
            throw new IllegalStateException("No hay suficientes habitaciones disponibles para las fechas dadas.");
        }

        // Mostrar información de las habitaciones confirmadas
        System.out.println("Habitaciones confirmadas:");
        for (int i = 0; i < habitacionesRequeridas; i++) {
            Habitacion habitacion = habitacionesDisponibles.get(i);
            System.out.println("- Tipo: " + habitacion.getTipoDeHabitacion());
            System.out.println("  Precio: $" + habitacion.getPrecio());
            System.out.println("  Descripción: " + habitacion.getDescripcion());
            System.out.println("  Capacidad: " + habitacion.getCantidadAdultos() + " adultos, " + habitacion.getCantidadMenores() + " niños");
            System.out.println("  -----------------------------");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alojamiento:\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Ciudad: ").append(ciudad).append("\n");
        sb.append("Tipo de Alojamiento: ").append(tipoAlojamiento).append("\n");
        sb.append("Precio Base: $").append(precioBase).append("\n");
        sb.append("Fecha de Inicio: ").append(fechaInicio).append("\n");
        sb.append("Fecha de Fin: ").append(fechaFin).append("\n");
        sb.append("Habitaciones:\n");
        for (Habitacion habitacion : habitaciones) {
            sb.append(habitacion).append("\n");
        }
        return sb.toString();
    }

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

    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(String tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }
}