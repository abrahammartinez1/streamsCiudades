import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        ciudades.add(new ciudad("AJALVIR", "MADRID", 5000, 10));
        ciudades.add(new ciudad("EL POBLADO", "EXTREMADURA", 5000, 10));

        // De cuántas provincias diferentes son las ciudades?
        long numeroProvincias = ciudades.stream().map(ciudad::getProvincia).distinct().count();
        System.out.println("NUMERO DE PROVINCIAS DIFERENTES EN LA LISTA: " + numeroProvincias);

        //Obten una coleccion con los nombres de todas las provincias(sin repetir)
        List<String> nombresProvincias = ciudades.stream().map(ciudad::getProvincia).distinct().toList();
        System.out.println("NOMBRES DE TODAS LAS PROVINCIAS EN LA LISTA: " + nombresProvincias);


        // ¿Cuántas ciudades hay?
        System.out.println("NUMERO DE CIUDADES EN LA LISTA: " + ciudades.size());

        // Responder a la pregunta de si Todas las ciudades son de más de 50.000 habitantes
        //recorrer todos los elementos a ver si cumplen todos la condicion, en el momento que uno no cumpla la variable sera FALSE
        final boolean[] ciudadGrande = {true};
        ciudades.forEach((p)-> {
            if (( p.getHabitantes())<50000){
                ciudadGrande[0] = false;
            }
        });

        if (!ciudadGrande[0]){
            System.out.println("TODAS LAS CIUDADES DE LA LISTA NO SON MAYORES DE 50.000 HABITANTES");
        }
        else {
            System.out.println("TODAS LAS CIUDADES SI SON MAYORES DE 50.000 HABITANTES");
        }

        // Calcula el número total de habitantes para una provincia determinada (introducida por el usuario, por ejemplo)
        Scanner sc = new Scanner(System.in);
        System.out.println("INTRODUCE UNA PROVINCIA: ");
        String provincia = sc.nextLine().toUpperCase();
        String finalProvincia1 = provincia;
        int totalHabitantes = ciudades.stream().filter(c -> c.getProvincia().equals(finalProvincia1)).mapToInt(ciudad::getHabitantes).sum();

        System.out.println("NUMERO TOTAL DE HABITANTES EN " + provincia + ": " + totalHabitantes);

        //¿Alguna ciudad de una provincia determinada (introducida por el usuario) tiene más de 10.000 habitantes?
        ciudadGrande[0] = false;
        System.out.println("INTRODUCE UNA PROVINCIA: ");
        provincia = sc.nextLine().toUpperCase();
        String finalProvincia = provincia;
        final String[] provincia1 = new String[1];
        final String[] provincia2 = new String[1];
        final String[] listaCiudadesGrandes = {""};

        ciudades.forEach((p)-> {
            provincia1[0] = p.getProvincia().toUpperCase();
            provincia2[0] = finalProvincia;

            if (provincia2[0].equals(provincia1[0])){
                if (p.getHabitantes()>10000){
                    ciudadGrande[0] = true;
                    listaCiudadesGrandes[0] = listaCiudadesGrandes[0] + p.getNombre().toUpperCase() + " ";
                }
            }
        });

        if (!ciudadGrande[0]){
            System.out.println("TODAS LAS CIUDADES DE LA PROVINCIA DE " + provincia + " TIENEN MENOS DE 10.000 HABITANTES");
        }
        else {
            System.out.println("AL MENOS 1 CIUDAD DE " + provincia + " TIENE MAS DE 10.000 HABITANTES, ESTAS CIUDADES SON " + listaCiudadesGrandes[0]);
        }

    }
}
