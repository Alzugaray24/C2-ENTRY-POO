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
    private int roomCount; // Cantidad de habitaciones reservadas
    private String roomType; // Tipo de habitación reservada
    private String arrivalTime; // Hora de llegada del cliente

    // Constructor
    public Reservation(String clientFirstName, String clientLastName, String clientEmail,
                       String nationality, String phoneNumber, LocalDate startDate,
                       LocalDate endDate, int adultCount, int childCount,
                       int roomCount, String roomType, String arrivalTime) {
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.clientEmail = clientEmail;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.roomCount = roomCount;
        this.roomType = roomType;
        this.arrivalTime = arrivalTime;
    }

    // Getters and Setters
    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}