package Services;

import Models.AccommodationType;
import Models.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {
    List<Hotel> getHotels();

    List<String> searchHotels(String city, AccommodationType accommodationType,
                              LocalDate startDate, LocalDate endDate,
                              int adults, int children, int rooms);

    List<String> confirmRooms(String hotelName, LocalDate startDate, LocalDate endDate,
                              int adults, int children, int roomsRequired);

    String makeReservation(String firstName, String lastName, String email, String nationality,
                           String phoneNumber, String arrivalTime, LocalDate startDate,
                           LocalDate endDate, int adults, int children, LocalDate birthday);

    String updateReservation(String email, LocalDate dateOfBirth, int option, int roomOption, int newRoomOption);
}