package co.edu.uniquindio.controladores;

import co.edu.uniquindio.clases.Empresa;
import co.edu.uniquindio.clases.Reserva;

import java.time.LocalDate;
import co.edu.uniquindio.clases.Cliente;
import co.edu.uniquindio.clases.Vehiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;


public class ReservaController {

    private Empresa empresa;

    @FXML
    private TableView<Reserva> tablaReservas;

    @FXML
    private ComboBox<Cliente> comboBoxCliente;

    @FXML
    private ComboBox<Vehiculo> comboBoxVehiculo;

    @FXML
    private DatePicker fechaInicioReserva;
    
    @FXML
    private TableColumn<Reserva, String> colCliente;
    
    @FXML
    private TableColumn<Reserva, String> colVehiculo;
    
    @FXML
    private TableColumn<Reserva, String> colMatricula;
    
    @FXML
    private TableColumn<Reserva, LocalDate> colFechaInicio;
    
    @FXML
    private TableColumn<Reserva, LocalDate> colFechaFin;

    @FXML
    private DatePicker fechaFinReserva;
    
    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        comboBoxCliente.getItems().addAll(empresa.obtenerTodosLosClientes());
        comboBoxVehiculo.getItems().addAll(empresa.obtenerTodosLosVehiculos());
    }

    @FXML
    private void initialize() {
        colCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre()));
        colVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().getModelo()));
        colMatricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().getMatricula()));
        colFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        colFechaFin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
    }

    @FXML
    private void agregarReserva() {
        Cliente cliente = comboBoxCliente.getValue();
        Vehiculo vehiculo = comboBoxVehiculo.getValue();
        LocalDate fechaInicio = fechaInicioReserva.getValue();
        LocalDate fechaFin = fechaFinReserva.getValue();

        Reserva reserva = new Reserva(cliente, vehiculo, fechaInicio, fechaFin);
        
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Reserva Agregada");
            alert.setHeaderText(null);
            alert.setContentText("Añadiendo reserva a nombre de " + cliente.getNombre() +
                    ", con vehículo " + vehiculo.getModelo() +
                    " de placa " + vehiculo.getMatricula() +
                    ", desde " + fechaInicio + " hasta " + fechaFin);
            alert.showAndWait();

            tablaReservas.getItems().add(reserva);
    
    }

    @FXML
    private void eliminarReservaSeleccionada() {

        Cliente cliente = comboBoxCliente.getValue();
        Vehiculo vehiculo = comboBoxVehiculo.getValue();
        LocalDate fechaInicio = fechaInicioReserva.getValue();
        LocalDate fechaFin = fechaFinReserva.getValue();
    
        Reserva reservaSeleccionada = tablaReservas.getSelectionModel().getSelectedItem();
    
        if (reservaSeleccionada != null) {
    
            empresa.eliminarReserva(null, null);
        
            tablaReservas.getItems().remove(reservaSeleccionada);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Reserva Eliminada");
            alert.setHeaderText(null);
            alert.setContentText("Eliminando reserva a nombre de " + cliente.getNombre() +
                    ", con vehículo " + vehiculo.getModelo() +
                    " de placa " + vehiculo.getMatricula() +
                    ", desde " + fechaInicio + " hasta " + fechaFin);
            alert.showAndWait();
        
        } else {

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("La reserva ya fue eliminada");
            alert.showAndWait();

        }

}

    @FXML
    private void limpiarCampos() {

        fechaInicioReserva.setValue(null);
        fechaFinReserva.setValue(null);
        comboBoxCliente.setValue(null);
        comboBoxVehiculo.setValue(null);

    }

    @FXML
    private void cargarReservaSeleccionada() {
        Reserva reservaSeleccionada = tablaReservas.getSelectionModel().getSelectedItem();
    
        if (reservaSeleccionada != null) {

            comboBoxCliente.setValue(reservaSeleccionada.getCliente());
            comboBoxVehiculo.setValue(reservaSeleccionada.getVehiculo());
            fechaInicioReserva.setValue(reservaSeleccionada.getFechaInicio());
            fechaFinReserva.setValue(reservaSeleccionada.getFechaFin());
        } else {
            System.out.println("Por favor, selecciona una reserva para actualizar.");
        }
    }

    @FXML
    private void actualizarReserva() {
        Reserva reservaSeleccionada = tablaReservas.getSelectionModel().getSelectedItem();
        
        if (reservaSeleccionada != null) {
            reservaSeleccionada.setCliente(comboBoxCliente.getValue());
            reservaSeleccionada.setVehiculo(comboBoxVehiculo.getValue());
            reservaSeleccionada.setFechaInicio(fechaInicioReserva.getValue());
            reservaSeleccionada.setFechaFin(fechaFinReserva.getValue());
            
            tablaReservas.refresh();
            
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Actualizacion");
            alert.setHeaderText(null);
            alert.setContentText("La reserva fue actualizada con exito");
            alert.showAndWait();
           
        }
    }

    @FXML
    private void calcularCostoReserva() {
        
        Vehiculo vehiculoSeleccionado = comboBoxVehiculo.getValue();
        LocalDate fechaInicio = fechaInicioReserva.getValue();
        LocalDate fechaFin = fechaFinReserva.getValue();
        
        if (vehiculoSeleccionado != null && fechaInicio != null && fechaFin != null) {

            double costo = vehiculoSeleccionado.calcularCostoReserva(fechaInicio, fechaFin);
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Valor Reserva");
            alert.setHeaderText(null);
            alert.setContentText("El costo de la reserva es: $" + costo);
            alert.showAndWait();

        }
    }


 

    
}