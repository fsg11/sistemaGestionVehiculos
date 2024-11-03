package co.edu.uniquindio.clases;

public class Cliente {

    private String nombre;
    private String identificacion;

    public Cliente(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return nombre + " (" + identificacion + ")";
    }
}
