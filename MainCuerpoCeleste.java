import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MainCuerpoCeleste {
    private static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    private static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main(String[] args) {
        Planeta mercurio = new Planeta("Mercurio", 88);
        sistemaSolar.put(mercurio.getNombre(), mercurio);
        planetas.add(mercurio);

        crearPlaneta("Venus", 225);
        crearPlaneta("Tierra", 365);
        crearPlaneta("Marte", 687);
        crearPlaneta("Jupiter", 4332);
        crearPlaneta("Saturno", 10759);
        crearPlaneta("Urano", 30660);
        crearPlaneta("Neptuno", 165);
        crearPlaneta("Pluton", 248);

        Luna lunaTierra = new Luna("Luna", 27);
        sistemaSolar.get("Tierra").addSatelite(lunaTierra);

        Luna deimos = new Luna("Deimos", 1.3);
        Luna phobos = new Luna("Phobos", 0.3);
        sistemaSolar.get("Marte").addSatelite(deimos);
        sistemaSolar.get("Marte").addSatelite(phobos);

        crearLunas("Io", 1.8);
        crearLunas("Europa", 3.5);
        crearLunas("Ganymede", 7.1);
        crearLunas("Callisto", 16.7);

        System.out.println("Planetas almacenados:");
        for (CuerpoCeleste planeta : planetas) {
            System.out.println(planeta.getNombre());
        }

        System.out.println("Lunas de Marte:");
        for (CuerpoCeleste satelite : sistemaSolar.get("Marte").getSatelites()) {
            System.out.println(satelite.getNombre());
        }

        Set<CuerpoCeleste> lunas = new HashSet<>();
        for (CuerpoCeleste planeta : planetas) {
            lunas.addAll(planeta.getSatelites());
        }

        System.out.println("Conjunto de lunas:");
        for (CuerpoCeleste luna : lunas) {
            System.out.println(luna.getNombre());
        }

        Planeta plutoNuevo = new Planeta("Pluton", 884);
        System.out.println("¿Se ha agregado Plutón al conjunto de planetas? " + planetas.contains(plutoNuevo));

        PlanetaEnano plutonEnano = new PlanetaEnano("Pluton", 884);
        System.out.println("¿Se ha agregado Plutón como planeta enano? " + planetas.contains(plutonEnano));

        Set<CuerpoCeleste> diferencia = new HashSet<>(planetas);
        diferencia.removeAll(lunas);
        System.out.println("Diferencia entre planetas y lunas:");
        for (CuerpoCeleste diferenciaItem : diferencia) {
            System.out.println(diferenciaItem.getNombre());
        }

        Set<CuerpoCeleste> interseccion = new HashSet<>(planetas);
        interseccion.retainAll(lunas);
        System.out.println("Intersección entre planetas y lunas:");
        for (CuerpoCeleste interseccionItem : interseccion) {
            System.out.println(interseccionItem.getNombre());
        }
    }

    private static void crearPlaneta(String nombre, double periodoOrbital) {
        Planeta planeta = new Planeta(nombre, periodoOrbital);
        sistemaSolar.put(planeta.getNombre(), planeta);
        planetas.add(planeta);
    }

    private static void crearLunas(String nombre, double periodoOrbital) {
        Luna luna = new Luna(nombre, periodoOrbital);
        sistemaSolar.get("Jupiter").addSatelite(luna);
    }
}
