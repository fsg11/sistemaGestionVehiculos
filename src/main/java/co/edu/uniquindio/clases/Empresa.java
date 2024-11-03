package co.edu.uniquindio.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;
    private List<Reserva> reservas;

    public Empresa() {
        this.clientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        
       
        clientes.add(new Cliente("Juan Pérez", "1234567890"));
        clientes.add(new Cliente("Ana Gómez", "0987654321"));
        clientes.add(new Cliente("Carlos Ramírez", "1122334455"));
       
        vehiculos.add(new Auto("ABC123", "Toyota", "Corolla", 2020, 4));
        vehiculos.add(new Moto("XYZ987", "Honda", "CBR", 2021, true));
        vehiculos.add(new Camioneta("LMN456", "Ford", "Ranger", 2019, 1.5));
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clientes;
    }

    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return vehiculos;
    }

    
    public void agregarReserva(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        reservas.add(new Reserva(cliente, vehiculo, fechaInicio, fechaFin));
    }

    public void actualizarReserva(Cliente cliente, Vehiculo vehiculo, int dias) {
       
    }

    public void eliminarReserva(Cliente cliente, Vehiculo vehiculo) {
        reservas.removeIf(r -> r.getCliente().equals(cliente) && r.getVehiculo().equals(vehiculo));
    }

    public void agregarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (!vehiculos.contains(vehiculo)) {
            vehiculos.add(vehiculo);
        }
    }

}
