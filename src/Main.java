import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
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
        String finalProvincia1 = provincia;
        int totalHabitantes = ciudades.stream().filter(c -> c.getProvincia().equals(finalProvincia1)).mapToInt(ciudad::getHabitantes).sum();

        System.out.println("Numero total de habitantes en " + provincia + ": " + totalHabitantes);

        // Obtén una colección con los nombres de todas las ciudades
        List<String> nombresCiudades = ciudades.stream().map(ciudad::getNombre).collect(Collectors.toList());
        System.out.println("Nombres de las ciudades: " + nombresCiudades);

        //Obten una coleccion con los nombres de todas las provincias(sin repetir)
        List<String> nombresProvincias = ciudades.stream().map(ciudad::getProvincia).distinct().collect(Collectors.toList());
        System.out.println("Nombres de las provincias: " + nombresProvincias);

        // Responder a la pregunta de si Todas las ciudades son de más de 50.000 habitantes
        //recorrer todos los elementos a ver si cumplen todos la condicion, en el momento que uno no cumpla la variable sera FALSE
        final boolean[] ciudadGrande = {true};
        ciudades.stream().forEach((p)-> {
            if (((Integer) p.getHabitantes())<50000){
                ciudadGrande[0] = false;
            }
        });

        if (ciudadGrande[0] == false){
            System.out.println("TODAS LAS CIUDADES NO SON MAYORES DE 50.000 HABITANTES");
        }
        else {
            System.out.println("TODAS LAS CIUDADES SI SON MAYORES DE 50.000 HABITANTES");
        }

        //¿Alguna ciudad de una provincia determinada (introducida por el usuario) tiene más de 10.000 habitantes?
        ciudadGrande[0] = false;
        System.out.println("Introduce una provincia: ");
        provincia = sc.nextLine().toUpperCase();
        String finalProvincia = provincia;
        final String[] provincia1 = new String[1];
        final String[] provincia2 = new String[1];

        ciudades.stream().forEach((p)-> {
            provincia1[0] = p.getProvincia().toUpperCase();
            provincia2[0] = finalProvincia;

            if (provincia2[0].equals(provincia1[0])){
                if ((Integer)p.getHabitantes()>10000){ciudadGrande[0] = true;}
            }
        });

        if (ciudadGrande[0] == false){
            System.out.println("TODAS LAS CIUDADES DE LA PROVINCIA DE " + provincia + " TIENEN MENOS DE 10.000 HABITANTES");
        }
        else {
            System.out.println("AL MENOS 1 CIUDAD DE " + provincia + " TIENE MAS DE 10.000 HABITANTES");
        }

    }
}
