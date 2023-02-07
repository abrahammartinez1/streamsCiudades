import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        List<ciudad> ciudades = new ArrayList<>();
        ciudades.add(new ciudad("MADRID", "MADRID", 3000000, 600));
        ciudades.add(new ciudad("ALCOBENDAS", "MADRID", 1000000, 600));
        ciudades.add(new ciudad("BARCELONA", "BARCELONA", 2000000, 400));
        ciudades.add(new ciudad("VALENCIA", "VALENCIA", 800000, 300));
        ciudades.add(new ciudad("SANTANDER", "CANTABRIA", 200000, 200));
        ciudades.add(new ciudad("TORRELAVEGA", "CANTABRIA", 100000, 100));
        ciudades.add(new ciudad("OVIEDO", "ASTURIAS", 300000, 400));
        ciudades.add(new ciudad("ALGETE", "MADRID", 20000, 50));


        // De cuántas provincias diferentes son las ciudades?
        long numeroProvincias = ciudades.stream().map(ciudad::getProvincia).distinct().count();
        System.out.println("Numero de provincias diferentes: " + numeroProvincias);

        // ¿Cuántas ciudades hay?
        System.out.println("Numero de ciudades: " + ciudades.size());

        // Calcula el número total de habitantes para una provincia determinada (introducida por el usuario, por ejemplo)
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una provincia: ");
        String provincia = sc.nextLine().toUpperCase();
        int totalHabitantes = ciudades.stream().filter(c -> c.getProvincia().equals(provincia)).mapToInt(ciudad::getHabitantes).sum();

        System.out.println("Numero total de habitantes en " + provincia + ": " + totalHabitantes);

        // Obtén una colección con los nombres de todas las ciudades
        List<String> nombresCiudades = ciudades.stream().map(ciudad::getNombre).collect(Collectors.toList());
        System.out.println("Nombres de las ciudades: " + nombresCiudades);
    }
}