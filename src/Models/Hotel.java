package Models;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    // Attributes
    private String name; // Nombre del hotel
    private String city; // Ciudad donde está ubicado
    private AccommodationType accommodationType; // Tipo de alojamiento
    private double rating; // Calificación del 1 al 5
    private boolean includesLunch; // Indica si incluye almuerzo (por ejemplo, para Día de Sol)
    private List<Room> rooms; // Lista de habitaciones
    private List<Room> reservations; // Lista de reservaciones

    // Constructor
    public Hotel(String name, String city, AccommodationType accommodationType, double rating, boolean includesLunch) {
        this.name = name;
        this.city = city;
        this.accommodationType = accommodationType;
        this.rating = rating;
        this.includesLunch = includesLunch;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<Room>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5");
        }
    }

    public boolean isIncludesLunch() {
        return includesLunch;
    }

    public void setIncludesLunch(boolean includesLunch) {
        this.includesLunch = includesLunch;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getReservations() {
        return reservations;
    }

    public void setReservations(List<Room> reservations) {
        this.reservations = reservations;
    }

    // Additional methods to add rooms and reservations
    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void addReservation(Room reservation) {
        this.reservations.add(reservation);
    }
}