import Models.AccommodationType;
import Models.Hotel;
import Models.Room;
import Services.HotelService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lista para almacenar los hoteles
        List<Hotel> hotels = initializeHotels();

        // Crear una instancia del servicio HotelService
        HotelService hotelService = new HotelService(hotels);

        // Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Buscar hoteles");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    searchHotelsOption(hotelService, scanner);
                    break;
                case 2:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 2);

        scanner.close();
    }

    private static List<Hotel> initializeHotels() {
        List<Hotel> hotels = new ArrayList<>();

        Hotel hotel1 = new Hotel("Gran Palacio", "Nueva York", AccommodationType.HOTEL, 4.5, true);
        hotel1.addRoom(new Room("Suite", "Cama King, Vista al mar, AC", 300.0, 2, 2, true));
        hotel1.addRoom(new Room("Habitación Doble", "2 camas dobles, AC", 200.0, 4, 0, true));
        hotel1.addRoom(new Room("Habitación Individual", "1 cama individual, AC", 100.0, 1, 0, true));
        hotel1.addRoom(new Room("Habitación Familiar", "2 camas dobles, 1 cama individual, AC", 250.0, 5, 0, true));
        hotel1.addRoom(new Room("Habitación Económica", "1 cama doble, AC", 80.0, 2, 0, true));
        hotels.add(hotel1);

        Hotel hotel2 = new Hotel("Posada de la Ciudad", "Chicago", AccommodationType.APARTAMENTO, 4.0, false);
        hotel2.addRoom(new Room("Habitación Individual", "1 cama individual, AC", 100.0, 1, 0, true));
        hotel2.addRoom(new Room("Habitación Doble", "2 camas dobles, AC", 150.0, 4, 0, true));
        hotel2.addRoom(new Room("Estudio", "1 cama doble, Kitchenette, AC", 120.0, 2, 0, true));
        hotel2.addRoom(new Room("Ático", "Cama King, Vista a la ciudad, AC", 400.0, 2, 2, true));
        hotel2.addRoom(new Room("Loft", "1 cama doble, AC", 130.0, 2, 0, true));
        hotels.add(hotel2);

        Hotel hotel3 = new Hotel("Lodge Vista al Lago", "Denver", AccommodationType.FINCA, 3.8, true);
        hotel3.addRoom(new Room("Cabaña", "Cama doble, Chimenea", 180.0, 2, 0, true));
        hotel3.addRoom(new Room("Cabaña Familiar", "2 camas dobles, Chimenea", 220.0, 4, 0, true));
        hotel3.addRoom(new Room("Cabaña Individual", "1 cama individual, Chimenea", 150.0, 1, 0, true));
        hotel3.addRoom(new Room("Cabaña de Lujo", "Cama King, Chimenea, Jacuzzi", 350.0, 2, 2, true));
        hotel3.addRoom(new Room("Cabaña Económica", "1 cama doble, Chimenea", 100.0, 2, 0, true));
        hotels.add(hotel3);

        Hotel hotel4 = new Hotel("Retiro en la Montaña", "Aspen", AccommodationType.HOTEL, 4.7, true);
        hotel4.addRoom(new Room("Suite", "Cama King, Vista a la montaña, AC", 320.0, 2, 2, true));
        hotel4.addRoom(new Room("Habitación Doble", "2 camas dobles, AC", 210.0, 4, 0, true));
        hotel4.addRoom(new Room("Habitación Individual", "1 cama individual, AC", 110.0, 1, 0, true));
        hotel4.addRoom(new Room("Habitación Familiar", "2 camas dobles, 1 cama individual, AC", 260.0, 5, 0, true));
        hotel4.addRoom(new Room("Habitación Económica", "1 cama doble, AC", 90.0, 2, 0, true));
        hotels.add(hotel4);

        Hotel hotel5 = new Hotel("Resort Frente al Mar", "Miami", AccommodationType.DIA_DE_SOL, 4.9, true);
        hotel5.addRoom(new Room("Suite", "Cama King, Vista al océano, AC", 350.0, 2, 2, true));
        hotel5.addRoom(new Room("Habitación Doble", "2 camas dobles, AC", 220.0, 4, 0, true));
        hotel5.addRoom(new Room("Habitación Individual", "1 cama individual, AC", 120.0, 1, 0, true));
        hotel5.addRoom(new Room("Habitación Familiar", "2 camas dobles, 1 cama individual, AC", 270.0, 5, 0, true));
        hotel5.addRoom(new Room("Habitación Económica", "1 cama doble, AC", 100.0, 2, 0, true));
        hotels.add(hotel5);

        return hotels;
    }

    private static void searchHotelsOption(HotelService hotelService, Scanner scanner) {
        // Mostrar ciudades disponibles
        List<String> availableCities = getAvailableCities(hotelService);
        System.out.println("Ciudades disponibles para búsqueda:");
        for (int i = 0; i < availableCities.size(); i++) {
            System.out.println((i + 1) + ". " + availableCities.get(i));
        }

        // Selección de ciudad
        String city = null;
        while (city == null) {
            System.out.print("Seleccione una ciudad ingresando el número correspondiente: ");
            int cityOption = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (cityOption > 0 && cityOption <= availableCities.size()) {
                city = availableCities.get(cityOption - 1);
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        // Menú para elegir el tipo de alojamiento
        System.out.println("\nSeleccione el tipo de alojamiento:");
        System.out.println("1. HOTEL");
        System.out.println("2. APARTAMENTO");
        System.out.println("3. FINCA");
        System.out.println("4. DIA_DE_SOL");
        System.out.println("5. Sin filtro");
        System.out.print("Opción: ");
        int typeOption = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        AccommodationType type = null;
        switch (typeOption) {
            case 1:
                type = AccommodationType.HOTEL;
                break;
            case 2:
                type = AccommodationType.APARTAMENTO;
                break;
            case 3:
                type = AccommodationType.FINCA;
                break;
            case 4:
                type = AccommodationType.DIA_DE_SOL;
                break;
            case 5:
                System.out.println("Continuando sin filtro de tipo de alojamiento...");
                break;
            default:
                System.out.println("Opción no válida. Continuando sin filtro de tipo de alojamiento.");
        }

        // Ingreso de fechas
        LocalDate startDate = null, endDate = null;
        while (startDate == null || endDate == null || !startDate.isBefore(endDate)) {
            try {
                System.out.print("Ingrese la fecha de inicio (AAAA-MM-DD): ");
                startDate = LocalDate.parse(scanner.nextLine());

                System.out.print("Ingrese la fecha de fin (AAAA-MM-DD): ");
                endDate = LocalDate.parse(scanner.nextLine());

                if (!startDate.isBefore(endDate)) {
                    System.out.println("La fecha de inicio debe ser anterior a la fecha de fin. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
            }
        }

        // Cantidad de adultos, niños y habitaciones
        System.out.print("Cantidad de adultos: ");
        int adults = scanner.nextInt();

        System.out.print("Cantidad de niños: ");
        int children = scanner.nextInt();

        System.out.print("Cantidad de habitaciones: ");
        int rooms = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Buscar hoteles
        List<String> filteredHotels = hotelService.searchHotels(city, type, startDate, endDate, adults, children, rooms);

        // Mostrar resultados
        if (filteredHotels.isEmpty()) {
            System.out.println("No se encontraron hoteles que coincidan con los criterios de búsqueda.");
        } else {
            System.out.println("\nHoteles disponibles:");
            for (String hotelInfo : filteredHotels) {
                System.out.println(hotelInfo);
            }
        }
    }

    // Método auxiliar para obtener las ciudades disponibles
    private static List<String> getAvailableCities(HotelService hotelService) {
        List<String> cities = new ArrayList<>();
        for (Hotel hotel : hotelService.getHotels()) {
            if (!cities.contains(hotel.getCity())) {
                cities.add(hotel.getCity());
            }
        }
        return cities;
    }
}