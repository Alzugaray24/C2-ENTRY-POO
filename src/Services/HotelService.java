package Services;

import Models.AccommodationType;
import Models.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Hotel> hotels; // Lista de hoteles en el sistema.

    public HotelService(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<Hotel> searchHotels(String city, AccommodationType accommodationType,
                                    LocalDate startDate, LocalDate endDate,
                                    int adults, int children, int rooms) {
        List<Hotel> filteredHotels = new ArrayList<>();

        for (Hotel hotel : hotels) {
            // Filtrar por ciudad
            if (!hotel.getCity().equalsIgnoreCase(city)) {
                continue; // Si el hotel no está en la ciudad especificada, pasar al siguiente
            }

            // Filtrar por tipo de alojamiento
            if (accommodationType != null && hotel.getAccommodationType() != accommodationType) {
                continue; // Si el tipo de alojamiento no coincide, pasar al siguiente
            }

            // Filtrar por disponibilidad
            boolean hasAvailability = hotel.getRooms().stream().anyMatch(room ->
                    room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children));

            if (!hasAvailability) {
                continue; // Si no hay habitaciones disponibles en el rango de fechas, pasar al siguiente
            }

            // Filtrar por cantidad de habitaciones
            long availableRooms = hotel.getRooms().stream()
                    .filter(room -> room.isAvailable(startDate, endDate))
                    .count();

            if (availableRooms < rooms) {
                continue; // Si el hotel no tiene suficientes habitaciones disponibles, pasar al siguiente
            }

            // Si pasa todos los filtros, agregar el hotel a la lista filtrada
            filteredHotels.add(hotel);
        }

        return filteredHotels;
    }
}