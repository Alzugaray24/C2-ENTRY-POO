package Services;

import Models.AccommodationType;
import Models.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {
    /**
     * Obtener la lista de todos los hoteles disponibles.
     * @return Lista de hoteles.
     */
    List<Hotel> getHotels();

    /**
     * Buscar hoteles según criterios específicos.
     * @param city Ciudad donde se desea buscar.
     * @param accommodationType Tipo de alojamiento (HOTEL, APARTAMENTO, FINCA, DIA_DE_SOL).
     * @param startDate Fecha de inicio de estadía.
     * @param endDate Fecha de fin de estadía.
     * @param adults Cantidad de adultos.
     * @param children Cantidad de niños.
     * @param rooms Cantidad de habitaciones.
     * @return Lista de hoteles disponibles en formato String.
     */
    List<String> searchHotels(String city, AccommodationType accommodationType,
                              LocalDate startDate, LocalDate endDate,
                              int adults, int children, int rooms);

    /**
     * Confirmar las habitaciones disponibles en un hotel específico.
     * @param hotelName Nombre del hotel.
     * @param startDate Fecha de inicio de estadía.
     * @param endDate Fecha de fin de estadía.
     * @param adults Cantidad de adultos.
     * @param children Cantidad de niños.
     * @param roomsRequired Cantidad de habitaciones necesarias.
     * @return Lista con la información de habitaciones disponibles.
     */
    List<String> confirmRooms(String hotelName, LocalDate startDate, LocalDate endDate,
                              int adults, int children, int roomsRequired);

    /**
     * Realizar una reserva en un hotel.
     * @param firstName Nombre del cliente.
     * @param lastName Apellido del cliente.
     * @param email Correo electrónico del cliente.
     * @param nationality Nacionalidad del cliente.
     * @param phoneNumber Número de teléfono del cliente.
     * @param arrivalTime Hora aproximada de llegada.
     * @param startDate Fecha de inicio de estadía.
     * @param endDate Fecha de fin de estadía.
     * @param adults Cantidad de adultos.
     * @param children Cantidad de niños.
     * @return Mensaje de confirmación de la reserva.
     */
    String makeReservation(String firstName, String lastName, String email, String nationality,
                           String phoneNumber, String arrivalTime, LocalDate startDate,
                           LocalDate endDate, int adults, int children);
}