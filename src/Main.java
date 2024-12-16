import Models.AccommodationType;
import Models.Hotel;
import Models.Room;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lista para almacenar los hoteles
        List<Hotel> hotels = new ArrayList<>();

        // Hotel 1
        Hotel hotel1 = new Hotel("Grand Palace", "New York", AccommodationType.HOTEL, 4.5, true);
        hotel1.addRoom(new Room("Suite", "King bed, Sea view, AC", 300.0, 2, 2, true));
        hotel1.addRoom(new Room("Double Room", "2 double beds, AC", 200.0, 4, 0, true));
        hotels.add(hotel1);

        // Hotel 2
        Hotel hotel2 = new Hotel("City Inn", "Chicago", AccommodationType.APARTAMENTO, 4.0, false);
        hotel2.addRoom(new Room("Single Room", "1 single bed, AC", 100.0, 1, 0, true));
        hotel2.addRoom(new Room("Studio", "Queen bed, Small kitchen", 150.0, 2, 1, true));
        hotels.add(hotel2);

        // Hotel 3 (corregido)
        Hotel hotel3 = new Hotel("Lakeview Lodge", "Denver", AccommodationType.FINCA, 3.8, true);
        hotel3.addRoom(new Room("Cabin", "Double bed, Fireplace", 180.0, 2, 0, true));
        hotel3.addRoom(new Room("Family Room", "2 double beds, Living area", 250.0, 4, 2, true));
        hotels.add(hotel3);

        // Hotel 4
        Hotel hotel4 = new Hotel("Beachside Resort", "Miami", AccommodationType.HOTEL, 5.0, true);
        hotel4.addRoom(new Room("Ocean Suite", "King bed, Ocean view", 500.0, 2, 1, true));
        hotel4.addRoom(new Room("Deluxe Room", "Queen bed, Balcony", 350.0, 2, 1, true));
        hotels.add(hotel4);

        // Hotel 5
        Hotel hotel5 = new Hotel("Mountain Retreat", "Aspen", AccommodationType.FINCA, 4.2, false);
        hotel5.addRoom(new Room("Chalet", "Double bed, Mountain view", 300.0, 2, 1, true));
        hotel5.addRoom(new Room("Family Cabin", "3 double beds, Fireplace", 450.0, 6, 3, true));
        hotels.add(hotel5);

        // Mostrar los hoteles creados
        for (Hotel hotel : hotels) {
            System.out.println("Hotel: " + hotel.getName() + ", City: " + hotel.getCity() +
                    ", Type: " + hotel.getAccommodationType() + ", Rating: " + hotel.getRating());
            for (Room room : hotel.getRooms()) {
                System.out.println(" - Room Type: " + room.getType() + ", Price: " + room.getPricePerNight() +
                        ", Capacity: " + room.getCapacity() + ", Available: " + room.isAvailability());
            }
            System.out.println();
        }
    }
}