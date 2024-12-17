package data;

import Models.AccommodationType;
import Models.Hotel;
import Models.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelDataLoader {
    public static List<Hotel> initializeHotels() {
        List<Hotel> hotels = new ArrayList<>();

        // Crear hoteles y agregar habitaciones
        Hotel hotel1 = new Hotel("Gran Palacio", "Nueva York", AccommodationType.HOTEL, 4.5, true);
        hotel1.addRoom(new Room("Suite", "Cama King, Vista al mar, AC", 300.0, 2, 2, true));
        hotel1.addRoom(new Room("Habitación Doble", "2 camas dobles, AC", 200.0, 4, 0, true));
        hotels.add(hotel1);

        Hotel hotel2 = new Hotel("Posada de la Ciudad", "Chicago", AccommodationType.APARTAMENTO, 4.0, false);
        hotel2.addRoom(new Room("Habitación Individual", "1 cama individual, AC", 100.0, 1, 0, true));
        hotel2.addRoom(new Room("Estudio", "1 cama doble, Kitchenette, AC", 120.0, 2, 0, true));
        hotels.add(hotel2);

        Hotel hotel3 = new Hotel("Lodge Vista al Lago", "Denver", AccommodationType.FINCA, 3.8, true);
        hotel3.addRoom(new Room("Cabaña", "Cama doble, Chimenea", 180.0, 2, 0, true));
        hotel3.addRoom(new Room("Cabaña Familiar", "2 camas dobles, Chimenea", 220.0, 4, 0, true));
        hotels.add(hotel3);

        Hotel hotel4 = new Hotel("Retiro en la Montaña", "Aspen", AccommodationType.HOTEL, 4.7, true);
        hotel4.addRoom(new Room("Suite", "Cama King, Vista a la montaña, AC", 320.0, 2, 2, true));
        hotel4.addRoom(new Room("Habitación Doble", "2 camas dobles, AC", 210.0, 4, 0, true));
        hotels.add(hotel4);

        Hotel hotel5 = new Hotel("Resort Frente al Mar", "Miami", AccommodationType.DIA_DE_SOL, 4.9, true);
        hotel5.addRoom(new Room("Suite", "Cama King, Vista al océano, AC", 350.0, 2, 2, true));
        hotel5.addRoom(new Room("Habitación Doble", "2 camas dobles, AC", 220.0, 4, 0, true));
        hotels.add(hotel5);

        return hotels;
    }
}