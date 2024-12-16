package Services;

import Models.Hotel;
import Models.Habitacion;
import Models.TipoAlojamiento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Hotel> hoteles; // Lista de hoteles en el sistema.

    public HotelService(List<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public List<Hotel> buscarHoteles(String ciudad, TipoAlojamiento tipoAlojamiento,
                                     LocalDate fechaInicio, LocalDate fechaFin,
                                     int cantidadAdultos, int cantidadNinos, int cantidadHabitaciones) {
        List<Hotel> hotelesFiltrados = new ArrayList<>();

        return hotelesFiltrados;
    }
}