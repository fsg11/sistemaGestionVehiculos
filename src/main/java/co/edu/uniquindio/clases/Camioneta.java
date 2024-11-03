package co.edu.uniquindio.clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Camioneta extends Vehiculo{

    private double capacidadCarga;
    private static final double TARIFA_BASE = 100.0;
    private static final double TARIFA_POR_TONELADA = 0.05;

    public Camioneta(String matricula, String marca, String modelo, int anioFabricacion, double capacidadCarga) {
        super(matricula, marca, modelo, anioFabricacion);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularCostoReserva(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return dias * TARIFA_BASE * (1 + TARIFA_POR_TONELADA * capacidadCarga);
    }

}
