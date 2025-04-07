import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Playlist> playlists;
    private Scanner scanner;

    // Constructor
    public Main() {
        this.playlists = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Método para mostrar las playlists disponibles
    public void mostrarPlaylistsDisponibles() {
        System.out.println("Playlists disponibles:");
        for (Playlist playlist : playlists) {
            System.out.println("Identificador: " + playlist.getIdentificador() + ", Nombre: " + playlist.getNombrePlaylist());
        }
    }

    // Método para reproducir una playlist
    public void reproducirPlaylist(String identificador) {
        for (Playlist playlist : playlists) {
            if (playlist.getIdentificador().equals(identificador)) {
                System.out.println("Reproduciendo playlist: " + playlist.getNombrePlaylist());
                playlist.mostrarCanciones();
                return;
            }
        }
        System.out.println("Playlist no encontrada.");
    }

    // Método para agregar una nueva playlist
    public void agregarPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    // Método para verificar si el usuario desea seguir usando la aplicación
    public boolean continuarUsandoAplicacion() {
        System.out.print("¿Desea seguir usando la aplicación? (Sí/No): ");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("sí") || respuesta.equals("si");
    }

    // Método principal
    public static void main(String[] args) {
        Main aplicacion = new Main();

        // Ejemplo de creación de algunas playlists y canciones
        Playlist playlist1 = new Playlist(2, "2024-04-07", "Pop Variado", "PV");
        Playlist playlist2 = new Playlist(1, "2024-04-07", "Rock Clásico", "RC");

        ArrayList<String> autoresCancion1 = new ArrayList<>();
        autoresCancion1.add("Autor 1");
        autoresCancion1.add("Autor 2");
        Cancion cancion1 = new Cancion("Canción 1", "4:30", "Pop", "Cantante 1", autoresCancion1);

        ArrayList<String> autoresCancion2 = new ArrayList<>();
        autoresCancion2.add("Autor 3");
        Cancion cancion2 = new Cancion("Canción 2", "3:45", "Rock", "Cantante 2", autoresCancion2);

        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist2.agregarCancion(cancion2);

        aplicacion.agregarPlaylist(playlist1);
        aplicacion.agregarPlaylist(playlist2);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Menú:");
            System.out.println("A. Agregar música a playlist");
            System.out.println("B. Reproducir música");
            System.out.println("C. Terminar programa");

            System.out.print("Seleccione una opción: ");
            String opcion = aplicacion.scanner.nextLine();

            switch (opcion.toUpperCase()) {
                case "A":
                    aplicacion.mostrarPlaylistsDisponibles();
                    System.out.print("Ingrese el identificador de la playlist a la que desea agregar música: ");
                    String identificadorPlaylistAgregar = aplicacion.scanner.nextLine();

                    // Buscar la playlist por su identificador
                    Playlist playlistAgregar = null;
                    for (Playlist playlist : aplicacion.playlists) {
                        if (playlist.getIdentificador().equals(identificadorPlaylistAgregar)) {
                            playlistAgregar = playlist;
                            break;
                        }
                    }

                    if (playlistAgregar != null) {
                        System.out.print("Ingrese el nombre de la canción: ");
                        String nombreCancion = aplicacion.scanner.nextLine();
                        System.out.print("Ingrese la duración de la canción: ");
                        String duracionCancion = aplicacion.scanner.nextLine();
                        System.out.print("Ingrese el género de la canción: ");
                        String generoCancion = aplicacion.scanner.nextLine();
                        System.out.print("Ingrese el nombre del cantante: ");
                        String cantanteCancion = aplicacion.scanner.nextLine();
                        System.out.print("Ingrese el número de autores: ");
                        int numAutores = Integer.parseInt(aplicacion.scanner.nextLine());
                        ArrayList<String> autoresCancion = new ArrayList<>();
                        for (int i = 0; i < numAutores; i++) {
                            System.out.print("Ingrese el nombre del autor " + (i + 1) + ": ");
                            autoresCancion.add(aplicacion.scanner.nextLine());
                        }

                        // Crear la canción y agregarla a la playlist
                        Cancion nuevaCancion = new Cancion(nombreCancion, duracionCancion, generoCancion, cantanteCancion, autoresCancion);
                        playlistAgregar.agregarCancion(nuevaCancion);
                        System.out.println("La canción se ha agregado a la playlist correctamente.");
                    } else {
                        System.out.println("Playlist no encontrada.");
                    }
                    break;
                case "B":
                    aplicacion.mostrarPlaylistsDisponibles();
                    System.out.print("Ingrese el identificador de la playlist que desea reproducir: ");
                    String identificadorPlaylist = aplicacion.scanner.nextLine();
                    aplicacion.reproducirPlaylist(identificadorPlaylist);
                    break;
                case "C":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }

        aplicacion.scanner.close();
    }
}
