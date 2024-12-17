package Models;

import java.time.LocalDate;

public class Reservation {
    // Attributes
    private String clientFirstName; // Nombre del cliente
    private String clientLastName; // Apellido del cliente
    private String clientEmail; // Email del cliente
    private String nationality; // Nacionalidad del cliente
    private String phoneNumber; // Número de teléfono del cliente
    private LocalDate startDate; // Fecha de inicio de la reserva
    private LocalDate endDate; // Fecha de fin de la reserva
    private int adultCount; // Cantidad de adultos
    private int childCount; // Cantidad de niños
    private String roomType; // Tipo de habitación reservada
    private LocalDate dateOfBirth; // Fecha de nacimiento del cliente

    // Constructor
    public Reservation(String clientFirstName, String clientLastName, String clientEmail,
                       String nationality, String phoneNumber, LocalDate startDate,
                       LocalDate endDate, int adultCount, int childCount,
                       int roomCount, String roomType, String arrivalTime, LocalDate dateOfBirth, int id) {
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.clientEmail = clientEmail;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.roomType = roomType;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }


    public int getAdultCount() {
        return adultCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return clientEmail;
    }

    @Override
    public String toString() {
        return "Detalles de la Reserva:\n" +
                "Cliente: " + clientFirstName + " " + clientLastName + "\n" +
                "Email: " + clientEmail + "\n" +
                "Teléfono: " + phoneNumber + "\n" +
                "Nacionalidad: " + nationality + "\n" +
                "Fecha de nacimiento: " + dateOfBirth + "\n" +
                "Estadía: Desde " + startDate + " hasta " + endDate + "\n" +
                "Habitación: " + roomType + "\n" +
                "Adultos: " + adultCount + ", Niños: " + childCount;
    }
}