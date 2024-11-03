package co.edu.uniquindio.clases;

import co.edu.uniquindio.controladores.ReservaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

    private Empresa empresa;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Inicializar la empresa y cargar datos de ejemplo
            empresa = new Empresa();
        
            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/reservaView.fxml"));
            AnchorPane root = loader.load();

            // Obtener el controlador y establecer la empresa
            ReservaController controller = loader.getController();
            controller.setEmpresa(empresa);

            // Crear la escena y mostrarla
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestión de Reservas");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    

   
    }    
    
    public static void main(String[] args) {
        launch(args);
    }
}
