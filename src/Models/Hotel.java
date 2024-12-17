package Models;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    // Attributes
    private final String name; // Nombre del hotel
    private final String city; // Ciudad donde está ubicado
    private final AccommodationType accommodationType; // Tipo de alojamiento
    private final double rating; // Calificación del 1 al 5
    private final List<Room> rooms; // Lista de habitaciones
    private final List<Reservation> reservations; // Lista de reservaciones

    // Constructor
    public Hotel(String name, String city, AccommodationType accommodationType, double rating, boolean includesLunch) {
        this.name = name;
        this.city = city;
        this.accommodationType = accommodationType;
        this.rating = rating;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<Reservation>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public double getRating() {
        return rating;
    }

    public List<Room> getRooms() {
        return rooms;
    }


    public List<Reservation> getReservations() {
        return reservations;
    }

    // Additional methods to add rooms and reservations
    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
}