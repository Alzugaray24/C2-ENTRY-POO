package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    // Attributes
    private final String type; // Ej: Double Room, Suite, etc.
    private final String features; // Ej: 2 double beds, air conditioning, etc.
    private final double pricePerNight; // Precio por noche
    private final int adultCapacity; // Capacidad de adultos
    private final int childCapacity; // Capacidad de niños
    private boolean availability; // Disponibilidad de la habitación
    private final List<Reservation> reservations; // Lista de reservaciones asociadas a la habitación

    // Constructor
    public Room(String type, String features, double pricePerNight, int adultCapacity, int childCapacity, boolean availability) {
        this.type = type;
        this.features = features;
        this.pricePerNight = pricePerNight;
        this.adultCapacity = adultCapacity;
        this.childCapacity = childCapacity;
        this.availability = availability;
        this.reservations = new ArrayList<>();
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public String getFeatures() {
        return features;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getCapacity() {
        return adultCapacity + childCapacity;
    }

    public boolean isAvailable(LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : reservations) {
            if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
                return false;
            }
        }
        return availability;
    }

}