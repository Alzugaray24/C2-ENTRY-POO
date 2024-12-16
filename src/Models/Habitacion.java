package Models;

public class Habitacion {
    // Atributos
    private String tipo; // Ej: Habitación Doble, Suite, etc.
    private String caracteristicas; // Ej: 2 camas dobles, aire acondicionado, etc.
    private double precioPorNoche;
    private int capacidadAdultos;
    private int capacidadNinos;
    private boolean disponibilidad;

    // Constructor
    public Habitacion(String tipo, String caracteristicas, double precioPorNoche, int capacidadAdultos, int capacidadNinos, boolean disponibilidad) {
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.precioPorNoche = precioPorNoche;
        this.capacidadAdultos = capacidadAdultos;
        this.capacidadNinos = capacidadNinos;
        this.disponibilidad = disponibilidad;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public int getCapacidadAdultos() {
        return capacidadAdultos;
    }

    public void setCapacidadAdultos(int capacidadAdultos) {
        this.capacidadAdultos = capacidadAdultos;
    }

    public int getCapacidadNinos() {
        return capacidadNinos;
    }

    public void setCapacidadNinos(int capacidadNinos) {
        this.capacidadNinos = capacidadNinos;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}