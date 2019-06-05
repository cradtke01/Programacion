import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

//Clase GestorArchivos; posee metodos herramienta para gestionar archivos.
public class GestorArchivos {

    /**
     * Metodo generico que captura un archivo de texto y retorna su contenido como un String.
     *
     * @param nombreArchivo es el nombre del archivo
     */
    public static String leerArchivo(String nombreArchivo) {
        Path archivo = Paths.get(nombreArchivo);
        String data = "";
        try {
            data = new String(Files.readAllBytes(archivo));
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo.");
        }
        return data;
    }

    /**
     * Metodo generico que captura un archivo de texto y lo sobreescribe con otro texto.
     *
     * @param data          sera el nuevo contenido del archivo
     * @param nombreArchivo es el nombre del archivo
     */
    public static void escribirArchivo(String nombreArchivo, String data) {
        Path archivo = Paths.get(nombreArchivo);
        try {
            Files.write(archivo, data.getBytes());
        } catch (Exception e) {
            System.out.println("No se pudo sobrescribir el archivo.");
        }
    }

    /**
     * Metodo que guarda los datos desde el programa al archivo.
     *
     * @param zapatillas es el arreglo donde se almacenan las zapatillas
     */
    public static void guardarDatos(ArrayList<Zapatilla> zapatillas) {
        GestorArchivos.escribirArchivo("src/main/zapatillas.json", "{\"zapatillas\" : [");
        for (Zapatilla zapatilla : zapatillas) {
            GestorArchivos.escribirArchivo("src/main/zapatillas.json", GestorArchivos.leerArchivo("src/main/zapatillas.json") + zapatilla.toString() + "\n  ");
        }
        if (zapatillas.size() > 0) {
            GestorArchivos.escribirArchivo("src/main/zapatillas.json", GestorArchivos.leerArchivo("src/main/zapatillas.json").substring(0, GestorArchivos.leerArchivo("src/main/zapatillas.json").length() - 3) + "]}");
        } else {
            GestorArchivos.escribirArchivo("src/main/zapatillas.json", GestorArchivos.leerArchivo("src/main/zapatillas.json") + "]}");
        }
    }

    /**
     * Metodo que carga los datos desde el archivo al programa.
     *
     * @param zapatillas es el arreglo donde se almacenan las zapatillas
     */
    public static void cargarDatos(ArrayList<Zapatilla> zapatillas) {
        String datos = GestorArchivos.leerArchivo("src/main/zapatillas.json");
        if (!datos.equals("")) {
            datos = datos.substring(datos.indexOf('[') + 1, datos.indexOf("]"));
            String[] objetosZapatilla = datos.split("\\{");
            for (int i = 1; i < objetosZapatilla.length; i++) {
                objetosZapatilla[i] = objetosZapatilla[i].substring(0, objetosZapatilla[i].indexOf("}"));
                String[] atributosZapatilla = objetosZapatilla[i].split(",");
                try {
                    zapatillas.add(new Zapatilla(atributosZapatilla[0].substring(atributosZapatilla[0].indexOf(":") + 2, atributosZapatilla[0].length() - 1), atributosZapatilla[1].substring(atributosZapatilla[1].indexOf(":") + 2, atributosZapatilla[1].length() - 1), atributosZapatilla[2].substring(atributosZapatilla[2].indexOf(":") + 2, atributosZapatilla[2].length() - 1)));
                } catch (Exception e) {
                    System.out.println("Error de formato en zapatillas.json.");
                    System.exit(0);
                }
            }
        }
    }
}
