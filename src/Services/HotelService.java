package Services;

import Models.AccommodationType;
import Models.Hotel;
import Models.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelService implements IHotelService {
    private final List<Hotel> hotels;

    public HotelService(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public List<Hotel> getHotels() {
        return hotels;
    }

    @Override
    public List<String> searchHotels(String city, AccommodationType accommodationType,
                                     LocalDate startDate, LocalDate endDate,
                                     int adults, int children, int rooms) {
        List<String> filteredHotels = new ArrayList<>();

        for (Hotel hotel : hotels) {
            // Filtrar por ciudad
            if (!hotel.getCity().equalsIgnoreCase(city)) continue;

            // Filtrar por tipo de alojamiento si se especifica
            if (accommodationType != null && hotel.getAccommodationType() != accommodationType) continue;

            StringBuilder hotelInfo = new StringBuilder();
            boolean hasAvailableRooms = false;

            hotelInfo.append("\n---------------------------------------\n");
            hotelInfo.append("Hotel: ").append(hotel.getName()).append("\n");
            hotelInfo.append("Ciudad: ").append(hotel.getCity()).append("\n");
            hotelInfo.append("Tipo de Alojamiento: ").append(hotel.getAccommodationType()).append("\n");
            hotelInfo.append("Calificación: ").append(hotel.getRating()).append("/5\n");
            hotelInfo.append("Incluye Almuerzo: ").append(hotel.isIncludeLunch() ? "Sí" : "No").append("\n");
            hotelInfo.append("Habitaciones Disponibles:\n");

            for (Room room : hotel.getRooms()) {
                if (room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children)) {
                    hasAvailableRooms = true;

                    // Calcular el precio total ajustado
                    long daysOfStay = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
                    double basePrice = room.getPricePerNight() * daysOfStay;
                    double adjustedPrice = calculateAdjustedPrice(basePrice, startDate, endDate);

                    // Agregar detalles de la habitación
                    hotelInfo.append(" - Tipo de Habitación: ").append(room.getType()).append("\n");
                    hotelInfo.append("   Características: ").append(room.getFeatures()).append("\n");
                    hotelInfo.append("   Capacidad: ").append(room.getAdultCapacity())
                            .append(" adultos, ").append(room.getChildCapacity()).append(" niños\n");
                    hotelInfo.append("   Precio por noche: $").append(room.getPricePerNight()).append("\n");
                    hotelInfo.append("   Precio Total Ajustado: $").append(adjustedPrice).append("\n");
                }
            }

            if (hasAvailableRooms) {
                filteredHotels.add(hotelInfo.toString());
            }
        }

        return filteredHotels;
    }

    // Método para calcular el precio ajustado con descuentos y aumentos
    private double calculateAdjustedPrice(double basePrice, LocalDate startDate, LocalDate endDate) {
        boolean isEndOfMonth = endDate.getDayOfMonth() > (endDate.lengthOfMonth() - 5);
        boolean isMidMonth = (startDate.getDayOfMonth() >= 10 && endDate.getDayOfMonth() <= 15);
        boolean isDiscountPeriod = (startDate.getDayOfMonth() >= 5 && endDate.getDayOfMonth() <= 10);

        if (isEndOfMonth) {
            return basePrice * 1.15; // Aumento del 15%
        } else if (isMidMonth) {
            return basePrice * 1.10; // Aumento del 10%
        } else if (isDiscountPeriod) {
            return basePrice * 0.92; // Descuento del 8%
        }
        return basePrice; // Precio base si no hay ajustes
    }

    @Override
    public List<String> confirmRooms(String hotelName, LocalDate startDate, LocalDate endDate,
                                              int adults, int children, int roomsRequired) {
        List<String> availableRoomDetails = new ArrayList<>();

        for (Hotel hotel : hotels) {
            if (!hotel.getName().equalsIgnoreCase(hotelName)) continue;

            int roomCount = 0;
            for (Room room : hotel.getRooms()) {
                if (room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children)) {
                    roomCount++;
                    availableRoomDetails.add("Tipo de Habitación: " + room.getType() +
                            "\nCaracterísticas: " + room.getFeatures() +
                            "\nPrecio por noche: $" + room.getPricePerNight() +
                            "\n-----------------------------");
                }
                if (roomCount == roomsRequired) break;
            }

            if (availableRoomDetails.isEmpty()) {
                availableRoomDetails.add("No hay habitaciones disponibles para las fechas y condiciones dadas.");
            }
            return availableRoomDetails;
        }

        availableRoomDetails.add("El hotel especificado no existe.");
        return availableRoomDetails;
    }
}