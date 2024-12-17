package Utils;

import Models.Hotel;
import Services.HotelService;

import java.util.ArrayList;
import java.util.List;

public class HotelUtils {

    // Método para obtener las ciudades disponibles a partir de los hoteles
    public static List<String> getAvailableCities(HotelService hotelService) {
        List<String> cities = new ArrayList<>();
        for (Hotel hotel : hotelService.getHotels()) {
            if (!cities.contains(hotel.getCity())) {
                cities.add(hotel.getCity());
            }
        }
        return cities;
    }
}