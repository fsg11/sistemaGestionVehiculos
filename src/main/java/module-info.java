module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens co.edu.uniquindio.clases to javafx.fxml;
    exports co.edu.uniquindio.clases;

    opens co.edu.uniquindio.controladores to javafx.fxml; 
    exports co.edu.uniquindio.controladores;
}
