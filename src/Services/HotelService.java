package Services;

import Models.AccommodationType;
import Models.Hotel;
import Models.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Hotel> hotels; // Lista de hoteles en el sistema.

    public HotelService(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public List<String> searchHotels(String city, AccommodationType accommodationType,
                                     LocalDate startDate, LocalDate endDate,
                                     int adults, int children, int rooms) {
        List<String> filteredHotels = new ArrayList<>();

        for (Hotel hotel : hotels) {
            // Filtrar por ciudad
            if (!hotel.getCity().equalsIgnoreCase(city)) {
                continue;
            }

            // Filtrar por tipo de alojamiento
            if (accommodationType != null && hotel.getAccommodationType() != accommodationType) {
                continue;
            }

            // Verificar disponibilidad y calcular precios
            boolean hasAvailableRooms = false;
            for (Room room : hotel.getRooms()) {
                if (room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children)) {
                    double basePrice = room.getPricePerNight() * rooms;
                    double adjustedPrice = calculateAdjustedPrice(basePrice, startDate, endDate);
                    double discountOrIncrease = adjustedPrice - basePrice;
                    hasAvailableRooms = true;

                    // Agregar la información del hotel a la lista filtrada
                    filteredHotels.add("Hotel: " + hotel.getName() +
                            ", Calificación: " + hotel.getRating() +
                            ", Precio por noche: $" + room.getPricePerNight() +
                            ", Precio base por la estadía: $" + basePrice +
                            ", Ajuste: $" + discountOrIncrease +
                            ", Precio ajustado por la estadía: $" + adjustedPrice);
                }
            }

            if (hasAvailableRooms) {
                filteredHotels.add(hotel.getName());
            }
        }

        return filteredHotels;
    }

    // Método para calcular el precio ajustado
    private double calculateAdjustedPrice(double basePrice, LocalDate startDate, LocalDate endDate) {
        boolean isEndOfMonth = endDate.getDayOfMonth() > (endDate.lengthOfMonth() - 5);
        boolean isMidMonth = (startDate.getDayOfMonth() >= 10 && endDate.getDayOfMonth() <= 15);
        boolean isDiscountPeriod = (startDate.getDayOfMonth() >= 5 && endDate.getDayOfMonth() <= 10);

        if (isEndOfMonth) {
            return basePrice * 1.15;
        } else if (isMidMonth) {
            return basePrice * 1.10;
        } else if (isDiscountPeriod) {
            return basePrice * 0.92;
        }

        return basePrice;
    }
}