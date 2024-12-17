import Services.HotelService;
import Models.AccommodationType;
import Models.Hotel;
import data.HotelDataLoader; // Importa la clase para cargar los hoteles
import java.util.ArrayList;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cargar los hoteles desde HotelDataLoader
        List<Hotel> hotels = HotelDataLoader.initializeHotels();

        // Crear una instancia del servicio HotelService
        HotelService hotelService = new HotelService(hotels);

        // Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Buscar hoteles");
            System.out.println("2. Confirmar habitaciones disponibles");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    searchHotelsOption(hotelService, scanner);
                    break;
                case 2:
                    confirmRoomOption(hotelService, scanner);
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 3);

        scanner.close();
    }

    // Método para confirmar habitaciones disponibles
    private static void confirmRoomOption(HotelService hotelService, Scanner scanner) {
        List<Hotel> hotels = hotelService.getHotels();
        if (hotels.isEmpty()) {
            System.out.println("No hay hoteles disponibles en el sistema.");
            return;
        }

        System.out.println("\nHoteles disponibles:");
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println((i + 1) + ". " + hotels.get(i).getName() + " - " + hotels.get(i).getCity());
        }

        int hotelOption = -1;
        while (hotelOption < 1 || hotelOption > hotels.size()) {
            System.out.print("Seleccione un hotel ingresando el número correspondiente: ");
            hotelOption = scanner.nextInt();
            scanner.nextLine();

            if (hotelOption < 1 || hotelOption > hotels.size()) {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        String hotelName = hotels.get(hotelOption - 1).getName();

        LocalDate startDate = null, endDate = null;
        while (startDate == null || endDate == null || !startDate.isBefore(endDate)) {
            try {
                System.out.print("Ingrese la fecha de inicio (AAAA-MM-DD): ");
                startDate = LocalDate.parse(scanner.nextLine());
                System.out.print("Ingrese la fecha de fin (AAAA-MM-DD): ");
                endDate = LocalDate.parse(scanner.nextLine());
                if (!startDate.isBefore(endDate)) {
                    System.out.println("La fecha de inicio debe ser anterior a la fecha de fin.");
                }
            } catch (Exception e) {
                System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
            }
        }

        System.out.print("Cantidad de adultos: ");
        int adults = scanner.nextInt();
        System.out.print("Cantidad de niños: ");
        int children = scanner.nextInt();
        System.out.print("Cantidad de habitaciones: ");
        int rooms = scanner.nextInt();
        scanner.nextLine();

        List<String> availableRooms = hotelService.confirmRooms(hotelName, startDate, endDate, adults, children, rooms);

        System.out.println("\nHabitaciones disponibles:");
        if (availableRooms.isEmpty()) {
            System.out.println("No hay habitaciones disponibles para las fechas y condiciones dadas.");
        } else {
            availableRooms.forEach(System.out::println);
        }
    }

    // Método para buscar hoteles
    private static void searchHotelsOption(HotelService hotelService, Scanner scanner) {
        // Mostrar las ciudades disponibles
        List<String> cities = getAvailableCities(hotelService);
        System.out.println("Ciudades disponibles:");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + ". " + cities.get(i));
        }

        int cityOption = -1;
        String city = null;

        while (city == null) {
            System.out.print("Seleccione una ciudad ingresando el número correspondiente: ");
            cityOption = scanner.nextInt();
            scanner.nextLine();

            if (cityOption > 0 && cityOption <= cities.size()) {
                city = cities.get(cityOption - 1);
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        System.out.println("Seleccione el tipo de alojamiento:");
        System.out.println("1. HOTEL\n2. APARTAMENTO\n3. FINCA\n4. DIA_DE_SOL\n5. Sin filtro");
        int typeOption = scanner.nextInt();
        scanner.nextLine();

        AccommodationType type = switch (typeOption) {
            case 1 -> AccommodationType.HOTEL;
            case 2 -> AccommodationType.APARTAMENTO;
            case 3 -> AccommodationType.FINCA;
            case 4 -> AccommodationType.DIA_DE_SOL;
            default -> null;
        };

        System.out.print("Ingrese la fecha de inicio (AAAA-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Ingrese la fecha de fin (AAAA-MM-DD): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Cantidad de adultos: ");
        int adults = scanner.nextInt();

        System.out.print("Cantidad de niños: ");
        int children = scanner.nextInt();

        System.out.print("Cantidad de habitaciones: ");
        int rooms = scanner.nextInt();
        scanner.nextLine();

        List<String> filteredHotels = hotelService.searchHotels(city, type, startDate, endDate, adults, children, rooms);

        System.out.println("\nHoteles disponibles:");
        if (filteredHotels.isEmpty()) {
            System.out.println("No se encontraron hoteles que coincidan con los criterios.");
        } else {
            filteredHotels.forEach(System.out::println);
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