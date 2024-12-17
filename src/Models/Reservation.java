// src/Models/Reservation.java
package Models;

import java.time.LocalDate;

public class Reservation extends Person {
    private String nationality;
    private LocalDate startDate;
    private LocalDate endDate;
    private int adultCount;
    private int childCount;
    private String roomType;

    public Reservation(String firstName, String lastName, String email, String nationality, String phoneNumber,
                       LocalDate startDate, LocalDate endDate, int adultCount, int childCount,
                       String roomType, LocalDate dateOfBirth) {
        super(firstName, lastName, email, phoneNumber, dateOfBirth);
        this.nationality = nationality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.roomType = roomType;
    }

    // Getters and Setters
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}