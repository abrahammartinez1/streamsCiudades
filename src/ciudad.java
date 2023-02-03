import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class ciudad {
    private String nombre;
    private String provincia;
    private int habitantes;
    private int extension;

    public Ciudad(String nombre, String provincia, int habitantes, int extension) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.habitantes = habitantes;
        this.extension = extension;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public int getExtension() {
        return extension;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(new Ciudad("Madrid", "Madrid", 3000000, 600));
        ciudades.add(new Ciudad("Barcelona", "Barcelona", 2000000, 400));
        ciudades.add(new Ciudad("Valencia", "Valencia", 800000, 300));

        // De cuántas provincias diferentes son las ciudades?
        long numeroProvincias = ciudades.stream().map(Ciudad::getProvincia).distinct().count();
        System.out.println("Numero de provincias diferentes: " + numeroProvincias);

        // ¿Cuántas ciudades hay?
        System.out.println("Numero de ciudades: " + ciudades.size());

        // Calcula el número total de habitantes para una provincia determinada (introducida por el usuario, por ejemplo)
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una provincia: ");
        String provincia = sc.nextLine();
        int totalHabitantes = ciudades.stream().filter(c -> c.getProvincia().equals(provincia)).mapToInt(Ciudad::getHabitantes).sum();
        System.out.println("Numero total de habitantes en " + provincia + ": " + totalHabitantes);

        // Obtén una colección con los nombres de todas las ciudades
        List<String> nombresCiudades = ciudades.stream().map(Ciudad::getNombre).collect(Collectors.toList());
        System.out.println("Nombres de las ciudades: " + nombresCiudad);
    }