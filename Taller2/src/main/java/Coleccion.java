import java.util.ArrayList;

public class Coleccion {
    private static ArrayList<Vinilo> vinilos = new ArrayList<>();

    public static ArrayList<Vinilo> getVinilos() {
        return vinilos;
    }

    public static void setVinilos(ArrayList<Vinilo> vinilos) {
        Coleccion.vinilos = vinilos;
    }

    public static void addVinilo(Vinilo vinilo) {
        if (0 < cuantosEspacios()) {
            vinilos.add(vinilo);
        } else System.out.println("No se pueden agregar mas vinilos.");
    }

    public static void deleteVinilo(int index) {
        if (-1 < index && index < vinilos.size()) {
            vinilos.remove(index);
        } else System.out.println("No existe vinilo con tal indice.");
    }

    public static void searchVinilo(String criteria) {
        System.out.println("Coincidencias por nombre del artista:");
        for (int i = 0; i < vinilos.size(); i++) {
            if (vinilos.get(i).getName_Artist().toLowerCase().contains(criteria.toLowerCase())) {
                System.out.println(i + "° " + vinilos.get(i).toString());
            }
        }
        System.out.println("Coincidencias por titulo del disco:");
        for (int i = 0; i < vinilos.size(); i++) {
            if (vinilos.get(i).getTitle_LP().toLowerCase().contains(criteria.toLowerCase())) {
                System.out.println(i + "° " + vinilos.get(i).toString());
            }
        }
    }

    public static int cuantosVinilos() {
        vinilos.trimToSize();
        return vinilos.size();
    }

    public static int cuantosEspacios() {
        return 100 - cuantosVinilos();
    }

    public static void showAll() {
        for (int i = 0; i < vinilos.size(); i++) {
            System.out.println(i + "° " + vinilos.get(i).toString());
        }
        if (cuantosVinilos() == 0){
            System.out.println("No hay vinilos en la coleccion.");
        }
    }
}
