package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    // Attributes
    private String type; // Ej: Double Room, Suite, etc.
    private String features; // Ej: 2 double beds, air conditioning, etc.
    private double pricePerNight; // Precio por noche
    private int adultCapacity; // Capacidad de adultos
    private int childCapacity; // Capacidad de niños
    private boolean availability; // Disponibilidad de la habitación
    private List<Reservation> reservations; // Lista de reservaciones asociadas a la habitación

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

    public void setType(String type) {
        this.type = type;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getAdultCapacity() {
        return adultCapacity;
    }

    public void setAdultCapacity(int adultCapacity) {
        this.adultCapacity = adultCapacity;
    }

    public int getChildCapacity() {
        return childCapacity;
    }

    public void setChildCapacity(int childCapacity) {
        this.childCapacity = childCapacity;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public int getCapacity() {
        return adultCapacity + childCapacity;
    }

    // Method to check availability for a given date range
    public boolean isAvailable(LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : reservations) {
            // Check if the requested dates overlap with existing reservations
            if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
                return false; // The room is not available
            }
        }
        return availability; // Return true only if no conflicts and room is marked available
    }

    // Method to add a reservation
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }


}