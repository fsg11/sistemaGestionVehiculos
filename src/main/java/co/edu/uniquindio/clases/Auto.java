package co.edu.uniquindio.clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Auto extends Vehiculo{

    private int numeroPuertas;
    private static final double TARIFA_BASE = 50.0;

    public Auto(String matricula, String marca, String modelo, int anioFabricacion, int numeroPuertas) {
        super(matricula, marca, modelo, anioFabricacion);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    @Override
    public double calcularCostoReserva(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return dias * TARIFA_BASE;
    }

}
