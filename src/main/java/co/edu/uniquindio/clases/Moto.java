package co.edu.uniquindio.clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Moto extends Vehiculo{

    private boolean esAutomatica;
    private static final double TARIFA_BASE = 30.0;
    private static final double TARIFA_ADICIONAL_AUTOMATICA = 10.0;

    public Moto(String matricula, String marca, String modelo, int anioFabricacion, boolean esAutomatica) {
        super(matricula, marca, modelo, anioFabricacion);
        this.esAutomatica = esAutomatica;
    }

    @Override
    public double calcularCostoReserva(LocalDate fechaInicio, LocalDate fechaFin){
        
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        if (esAutomatica == true) {
            return dias * TARIFA_BASE + TARIFA_ADICIONAL_AUTOMATICA;
        } else {
            return dias * TARIFA_BASE;
        }
       
    }
    

}
