package Services;

import Models.AccommodationType;
import Models.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {
    List<Hotel> getHotels(); // Obtener todos los hoteles


    List<String> searchHotels(String city, AccommodationType accommodationType,
                              LocalDate startDate, LocalDate endDate,
                              int adults, int children, int rooms); // Buscar hoteles

    List<String> confirmRooms(String hotelName, LocalDate startDate, LocalDate endDate,
                                       int adults, int children, int roomsRequired);
}