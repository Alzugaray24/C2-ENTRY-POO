package Services;

import Models.AccommodationType;
import Models.Hotel;
import Models.Reservation;
import Models.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HotelService implements IHotelService {
    private final List<Hotel> hotels;

    public HotelService(List<Hotel> hotels) {
        if (hotels == null || hotels.isEmpty()) {
            throw new IllegalArgumentException("La lista de hoteles no puede estar vacía.");
        }
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
        if (city == null || city.isBlank()) throw new IllegalArgumentException("La ciudad no puede estar vacía.");
        if (startDate == null || endDate == null || !startDate.isBefore(endDate)) {
            throw new IllegalArgumentException("Las fechas de inicio y fin no son válidas.");
        }

        List<String> filteredHotels = new ArrayList<>();

        for (Hotel hotel : hotels) {
            if (!hotel.getCity().equalsIgnoreCase(city)) continue;
            if (accommodationType != null && hotel.getAccommodationType() != accommodationType) continue;

            StringBuilder hotelInfo = new StringBuilder();
            boolean hasAvailableRooms = false;

            hotelInfo.append("Hotel: ").append(hotel.getName())
                    .append(", Calificación: ").append(hotel.getRating())
                    .append("\nHabitaciones Disponibles:\n");

            for (Room room : hotel.getRooms()) {
                if (room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children)) {
                    hasAvailableRooms = true;
                    hotelInfo.append(" - ").append(room.getType())
                            .append(", Precio: $").append(room.getPricePerNight()).append("\n");
                }
            }

            if (hasAvailableRooms) {
                filteredHotels.add(hotelInfo.toString());
            }
        }

        if (filteredHotels.isEmpty()) {
            throw new IllegalStateException("No se encontraron hoteles disponibles para los criterios ingresados.");
        }

        return filteredHotels;
    }

    @Override
    public List<String> confirmRooms(String hotelName, LocalDate startDate, LocalDate endDate,
                                     int adults, int children, int roomsRequired) {
        if (hotelName == null || hotelName.isBlank()) throw new IllegalArgumentException("El nombre del hotel no puede estar vacío.");
        if (startDate == null || endDate == null || !startDate.isBefore(endDate)) {
            throw new IllegalArgumentException("Las fechas de inicio y fin no son válidas.");
        }

        for (Hotel hotel : hotels) {
            if (!hotel.getName().equalsIgnoreCase(hotelName)) continue;

            List<String> availableRooms = new ArrayList<>();
            int roomCount = 0;

            for (Room room : hotel.getRooms()) {
                if (room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children)) {
                    availableRooms.add("Tipo: " + room.getType() + ", Características: " + room.getFeatures());
                    roomCount++;
                }
                if (roomCount == roomsRequired) break;
            }

            if (availableRooms.isEmpty()) {
                throw new IllegalStateException("No hay habitaciones disponibles en este hotel.");
            }

            return availableRooms;
        }

        throw new IllegalArgumentException("El hotel especificado no existe.");
    }

    @Override
    public String makeReservation(String firstName, String lastName, String email, String nationality,
                                  String phoneNumber, String arrivalTime, LocalDate startDate,
                                  LocalDate endDate, int adults, int children, LocalDate birthday) {
        // Validaciones iniciales
        if (firstName == null || lastName == null || email == null || phoneNumber == null) {
            throw new IllegalArgumentException("Los datos personales no pueden estar vacíos.");
        }
        if (startDate == null || endDate == null || !startDate.isBefore(endDate)) {
            throw new IllegalArgumentException("Las fechas de inicio y fin no son válidas.");
        }

        // Buscar hoteles disponibles
        List<Hotel> availableHotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            for (Room room : hotel.getRooms()) {
                if (room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children)) {
                    availableHotels.add(hotel);
                    break;
                }
            }
        }

        if (availableHotels.isEmpty()) {
            throw new IllegalStateException("No hay hoteles con habitaciones disponibles para las fechas y condiciones indicadas.");
        }

        // Selección del primer hotel disponible y habitación
        Hotel selectedHotel = availableHotels.get(0);
        Room selectedRoom = selectedHotel.getRooms().stream()
                .filter(room -> room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No hay habitaciones disponibles en el hotel seleccionado."));

        // Crear la reserva
        Reservation reservation = new Reservation(
                firstName, lastName, email, nationality, phoneNumber,
                startDate, endDate, adults, children, 1, selectedRoom.getType(), arrivalTime, birthday, 0
        );

        // Actualizar la habitación y agregar la reserva al hotel
        selectedRoom.setAvailability(false);
        selectedHotel.addReservation(reservation);

        // Mostrar detalles completos de la reserva usando toString()
        return "Reserva realizada con éxito.\n" + reservation.toString();
    }

    @Override
    public String updateReservation(String email, LocalDate dateOfBirth, int option, int roomOption, int newRoomOption) {
        for (Hotel hotel : hotels) {
            Optional<Reservation> reservationOpt = hotel.getReservations().stream()
                    .filter(reservation -> reservation.getEmail().equalsIgnoreCase(email) &&
                            reservation.getDateOfBirth().equals(dateOfBirth))
                    .findFirst();

            if (reservationOpt.isPresent()) {
                Reservation reservation = reservationOpt.get();
                // Mostrar datos de la reserva
                System.out.println("Datos de la reserva:");
                System.out.println("Hotel: " + hotel.getName());
                System.out.println("Habitación: " + reservation.getRoomType());
                System.out.println("Fecha de llegada: " + reservation.getStartDate());
                System.out.println("Fecha de salida: " + reservation.getEndDate());

                if (option == 1) {
                    // Cambiar de habitación
                    Room currentRoom = hotel.getRooms().get(roomOption - 1);
                    List<Room> availableRooms = hotel.getRooms().stream()
                            .filter(room -> room.isAvailable(reservation.getStartDate(), reservation.getEndDate())
                                    && room.getCapacity() >= (reservation.getAdultCount() + reservation.getChildCount()))
                            .toList();

                    Room newRoom = availableRooms.get(newRoomOption - 1);
                    currentRoom.setAvailability(true);
                    newRoom.setAvailability(false);
                    reservation.setRoomType(newRoom.getType());

                    return "Reserva actualizada con éxito. Nueva habitación: " + newRoom.getType();
                } else if (option == 2) {
                    // Cambiar de alojamiento
                    hotel.getReservations().remove(reservation);
                    return "Reserva eliminada. Por favor, cree una nueva reserva.";
                } else {
                    return "Opción no válida.";
                }
            }
        }
        return "No se encontró la reserva.";
    }
}
