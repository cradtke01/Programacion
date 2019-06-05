import java.util.ArrayList;
import java.util.Scanner;

public class InteraccionConUsuario {

    /** Espera la entrada del usuario. Dependiendo de la entrada, gestiona a que metodo se llamara luego.
    * @param zapatillas es el arreglo donde se almacenan las zapatillas
    */
    public static void menu(ArrayList<Zapatilla> zapatillas) {
        mostrarMenu();
        int respuesta = 0;
        try {
            respuesta = Integer.parseInt(obtenerRespuesta());
        } catch (Exception e) {
            System.out.println("Entrada inválida. Intente nuevamente.");
            menu(zapatillas);
        }
        switch (respuesta) {
            case 1:
                mostrarZapatillas(zapatillas);
                menu(zapatillas);
                break;
            case 2:
                crearZapatilla(zapatillas);
                menu(zapatillas);
                break;
            case 3:
                borrarZapatilla(zapatillas);
                menu(zapatillas);
                break;
            case 4:
                System.out.println("Adios!");
                System.exit(0);
                break;
            default:
                System.out.println("Entrada inválida. Intente nuevamente.");
                menu(zapatillas);
        }
    }

    /**
     * Despliega la interfaz del menu.
     */
    public static void mostrarMenu() {
        System.out.println("+--------------------------------------------+\n" +
                "|MENU                                        |\n" +
                "+--------------------------------------------+\n" +
                "|Ingresa 1 para mostrar todas las zapatillas.|\n" +
                "|Ingresa 2 para crear una zapatilla.         |\n" +
                "|Ingresa 3 para borrar una zapatilla.        |\n" +
                "|Ingresa 4 para salir.                       |\n" +
                "+--------------------------------------------+\n");
    }

    /**
     * Ingresa inputs del teclado.
     */
    public static String obtenerRespuesta() {
        return new Scanner(System.in).next();
    }

    /**
     * Despliega un listado de todas las zapatilla ya creadas.
     * @param zapatillas es el arreglo donde se almacenan las zapatillas
     */
    public static void mostrarZapatillas(ArrayList<Zapatilla> zapatillas) {
        if (zapatillas.size() == 0) {
            System.out.println("Aun no hay zapatillas.");
        } else {
            System.out.println("Mostrando zapatillas...");
            int iteracion = 1;
            for (Zapatilla zapatilla : zapatillas) {
                System.out.println(iteracion + "° " + zapatilla.toString());
                iteracion++;
            }
        }
    }

    /**
     * Guia la creacion de una nueva zapatilla.
     * @param zapatillas es el arreglo donde se almacenan las zapatillas
     */
    public static void crearZapatilla(ArrayList<Zapatilla> zapatillas) {
        System.out.println("Creando una zapatilla...");
        System.out.println("Marca?");
        String marca = obtenerRespuesta();
        System.out.println("Modelo?");
        String modelo = obtenerRespuesta();
        System.out.println("Color?");
        String color = obtenerRespuesta();
        zapatillas.add(new Zapatilla(marca, modelo, color));
        System.out.println("Zapatilla creada exitosamente.");
        GestorArchivos.guardarDatos(zapatillas);
    }

    /**
     * Elimina una zapatilla al ser ingresado su posicion en el arreglo "zapatillas".
     * @param zapatillas es el arreglo donde se almacenan las zapatillas
     */
    public static void borrarZapatilla(ArrayList<Zapatilla> zapatillas) {
        System.out.println("Borrando una zapatilla...");
        System.out.println("Ingrese la posición de la zapatilla que desea eliminar.");
        boolean error;
        int indice = 0;
        do {
            try {
                indice = Integer.parseInt(obtenerRespuesta());
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                error = true;
            }
        } while (error);
        if (indice <= 0 || indice > zapatillas.size()) {
            System.out.println("La zapatilla indicada no existe.");
        } else {
            zapatillas.remove(indice - 1);
            System.out.println("Zapatilla borrada exitosamente.");
        }
        GestorArchivos.guardarDatos(zapatillas);
    }
}
