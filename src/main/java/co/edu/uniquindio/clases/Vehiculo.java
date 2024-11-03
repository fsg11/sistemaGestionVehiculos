package co.edu.uniquindio.clases;

public abstract class Vehiculo implements Ivehiculo{

    private String matricula;
    private String marca;
    private String modelo;
    private int anioFabricacion;

    public Vehiculo(String matricula, String marca, String modelo, int anioFabricacion) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    @Override
    public String toString() {
        return matricula + " " +   marca  + " " +  modelo  + " " + anioFabricacion;
    }

    

}
