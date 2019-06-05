import java.util.Scanner;

public class GuiMenu {

    /**
     * Manages the user's selections.
     *
     * @return void
     */
    public static void menu() {
        showMenu();
        int answer = getNumericInput();
        switch (answer) {
            case 1:
                System.out.println("Ingrese nombre del artista.");
                String name_Artist = getInput();
                System.out.println("Ingrese el titulo del disco.");
                String title_LP = getInput();
                System.out.println("Ingrese el año.");
                int year = getNumericInput();
                Coleccion.addVinilo(new Vinilo(name_Artist, title_LP, year));
                menu();
                break;
            case 2:
                System.out.println("Ingrese el texto a buscar.");
                Coleccion.searchVinilo(getInput());
                menu();
                break;
            case 3:
                System.out.println("Ingrese la posicion del disco a eliminar.");
                int index = getNumericInput();
                Coleccion.deleteVinilo(index);
                menu();
                break;
            case 4:
                System.out.println("Hay " + Coleccion.cuantosVinilos() + " vinilos en la coleccion.");
                menu();
                break;
            case 5:
                System.out.println("Hay " + Coleccion.cuantosEspacios() + " espacios libres en la coleccion.");
                menu();
                break;
            case 6:
                Coleccion.showAll();
                menu();
                break;
            case 7:
                System.out.println("Adios!");
                System.exit(0);
                break;
            default:
                System.out.println("Opcion inexistente. Porfavor intentelo nuevamente.");
                menu();
        }
    }

    /**
     * Shows the menu options.
     *
     * @return void
     */
    public static void showMenu() {
        System.out.println("+--------------------------------------------------------------------------+\n" +
                "|MENU                                                                      |\n" +
                "+--------------------------------------------------------------------------+\n" +
                "|Ingresa 1 para agregar un vinilo a la colección.                          |\n" +
                "|Ingresa 2 para buscar un vinilo en la colección.                          |\n" +
                "|Ingresa 3 para eliminar un vinilo de la colección.                        |\n" +
                "|Ingresa 4 para consultar cuantos vinilos tiene la colección.              |\n" +
                "|Ingresa 5 para consultar cuantos espacios disponibles hay en la colección.|\n" +
                "|Ingresa 6 para mostrar todo el contenido de la colección.                 |\n" +
                "|Ingresa 7 para salir.                                                     |\n" +
                "+--------------------------------------------------------------------------+\n");
    }

    /**
     * Reads user inputs.
     *
     * @return String
     */
    public static String getInput() {
        return new Scanner(System.in).nextLine();
    }

    /**
     * Reads numerical user inputs.
     *
     * @return String
     */
    public static int getNumericInput() {
        boolean error;
        int answer = 0;
        do {
            try {
                answer = Integer.parseInt(getInput());
                error = false;
            } catch (Exception e) {
                System.out.println("Entrada invalida. Porfavor intentelo nuevamente.");
                error = true;
            }
        } while (error);
        return answer;
    }
}
