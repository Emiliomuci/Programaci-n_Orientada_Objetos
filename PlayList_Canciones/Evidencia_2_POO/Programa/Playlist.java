import java.util.ArrayList;

public class Playlist {
    private int numCanciones;
    private String fechaRegistro;
    private String nombrePlaylist;
    private String identificador;
    private ArrayList<Cancion> canciones;

    // Constructor
    public Playlist(int numCanciones, String fechaRegistro, String nombrePlaylist, String identificador) {
        this.numCanciones = numCanciones;
        this.fechaRegistro = fechaRegistro;
        this.nombrePlaylist = nombrePlaylist;
        this.identificador = identificador;
        this.canciones = new ArrayList<>();
    }

    // Método para agregar una canción a la playlist
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    // Método para mostrar los datos de cada canción en la playlist
    public void mostrarCanciones() {
        for (Cancion cancion : canciones) {
            System.out.println("Nombre: " + cancion.getNombre());
            System.out.println("Duración: " + cancion.getDuracion());
            System.out.println("Género: " + cancion.getGenero());
            System.out.println("Cantante: " + cancion.getCantante());
            System.out.println("Autores: " + String.join(", ", cancion.getAutores()));
        }
    }

    // Getters y setters
    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public void setNombrePlaylist(String nombrePlaylist) {
        this.nombrePlaylist = nombrePlaylist;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }
}
