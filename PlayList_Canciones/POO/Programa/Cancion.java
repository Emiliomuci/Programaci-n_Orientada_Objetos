import java.util.ArrayList;

public class Cancion {
    private String nombre;
    private String duracion;
    private String genero;
    private String cantante;
    private ArrayList<String> autores;

    // Constructor
    public Cancion(String nombre, String duracion, String genero, String cantante, ArrayList<String> autores) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.genero = genero;
        this.cantante = cantante;
        this.autores = autores;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }
}
