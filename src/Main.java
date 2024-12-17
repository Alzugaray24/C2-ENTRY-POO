import Services.HotelService;
import Models.AccommodationType;
import Models.Hotel;
import data.HotelDataLoader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Hotel> hotels = HotelDataLoader.initializeHotels();
        HotelService hotelService = new HotelService(hotels);
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do {
            try {
                System.out.println("\n--- Menú Principal ---");
                System.out.println("1. Buscar hoteles");
                System.out.println("2. Confirmar habitaciones disponibles");
                System.out.println("3. Realizar una reserva");
//                System.out.println("4. Ver reservas");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        searchHotelsOption(hotelService, scanner);
                        break;
                    case 2:
                        confirmRoomOption(hotelService, scanner);
                        break;
                    case 3:
                        makeReservationOption(hotelService, scanner);
                        break;
//                    case 4:
//                        viewReservationsOption(hotelService, scanner);
//                        break;
                    case 4:
                        System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    // Método para realizar una reserva
    private static void makeReservationOption(HotelService hotelService, Scanner scanner) {
        try {
            System.out.println("\n--- Realizar una Reserva ---");

            System.out.print("Nombre: ");
            String name = scanner.nextLine();

            System.out.print("Apellido: ");
            String lastName = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Nacionalidad: ");
            String nationality = scanner.nextLine();

            System.out.print("Número de Teléfono: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Hora aproximada de llegada: ");
            String arrivalTime = scanner.nextLine();

            System.out.print("Fecha de inicio de estadía (AAAA-MM-DD): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Fecha de fin de estadía (AAAA-MM-DD): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Cantidad de adultos: ");
            int adults = Integer.parseInt(scanner.nextLine());

            System.out.print("Cantidad de niños: ");
            int children = Integer.parseInt(scanner.nextLine());

            String result = hotelService.makeReservation(name, lastName, email, nationality, phoneNumber,
                    arrivalTime, startDate, endDate, adults, children);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error al realizar la reserva. Verifique los datos ingresados e intente nuevamente.");
        }
    }

    // Método para confirmar habitaciones disponibles
    private static void confirmRoomOption(HotelService hotelService, Scanner scanner) {
        try {
            List<Hotel> hotels = hotelService.getHotels();
            if (hotels.isEmpty()) {
                System.out.println("No hay hoteles disponibles en el sistema.");
                return;
            }

            System.out.println("\nHoteles disponibles:");
            for (int i = 0; i < hotels.size(); i++) {
                System.out.println((i + 1) + ". " + hotels.get(i).getName() + " - " + hotels.get(i).getCity());
            }

            System.out.print("Seleccione un hotel ingresando el número correspondiente: ");
            int hotelOption = Integer.parseInt(scanner.nextLine());
            String hotelName = hotels.get(hotelOption - 1).getName();

            System.out.print("Fecha de inicio (AAAA-MM-DD): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Fecha de fin (AAAA-MM-DD): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Cantidad de adultos: ");
            int adults = Integer.parseInt(scanner.nextLine());

            System.out.print("Cantidad de niños: ");
            int children = Integer.parseInt(scanner.nextLine());

            System.out.print("Cantidad de habitaciones: ");
            int rooms = Integer.parseInt(scanner.nextLine());

            List<String> availableRooms = hotelService.confirmRooms(hotelName, startDate, endDate, adults, children, rooms);

            System.out.println("\nHabitaciones disponibles:");
            if (availableRooms.isEmpty()) {
                System.out.println("No hay habitaciones disponibles para las fechas y condiciones dadas.");
            } else {
                availableRooms.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error al confirmar habitaciones. Verifique los datos ingresados e intente nuevamente.");
        }
    }

    // Método para buscar hoteles
    private static void searchHotelsOption(HotelService hotelService, Scanner scanner) {
        try {
            List<String> cities = getAvailableCities(hotelService);
            System.out.println("Ciudades disponibles:");
            for (int i = 0; i < cities.size(); i++) {
                System.out.println((i + 1) + ". " + cities.get(i));
            }

            System.out.print("Seleccione una ciudad ingresando el número correspondiente: ");
            int cityOption = Integer.parseInt(scanner.nextLine());
            String city = cities.get(cityOption - 1);

            System.out.println("Seleccione el tipo de alojamiento:");
            System.out.println("1. HOTEL\n2. APARTAMENTO\n3. FINCA\n4. DIA_DE_SOL\n5. Sin filtro");
            int typeOption = Integer.parseInt(scanner.nextLine());

            AccommodationType type = switch (typeOption) {
                case 1 -> AccommodationType.HOTEL;
                case 2 -> AccommodationType.APARTAMENTO;
                case 3 -> AccommodationType.FINCA;
                case 4 -> AccommodationType.DIA_DE_SOL;
                default -> null;
            };

            System.out.print("Fecha de inicio (AAAA-MM-DD): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Fecha de fin (AAAA-MM-DD): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Cantidad de adultos: ");
            int adults = Integer.parseInt(scanner.nextLine());

            System.out.print("Cantidad de niños: ");
            int children = Integer.parseInt(scanner.nextLine());

            System.out.print("Cantidad de habitaciones: ");
            int rooms = Integer.parseInt(scanner.nextLine());

            List<String> filteredHotels = hotelService.searchHotels(city, type, startDate, endDate, adults, children, rooms);

            System.out.println("\nHoteles disponibles:");
            if (filteredHotels.isEmpty()) {
                System.out.println("No se encontraron hoteles que coincidan con los criterios.");
            } else {
                filteredHotels.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar hoteles. Verifique los datos ingresados e intente nuevamente.");
        }
    }

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