import java.util.Scanner;

public class UserInteraction {
    public static void menu() {
        displayMenu();
        int respuesta = 0;
        try {
            respuesta = Integer.parseInt(getInput());
        } catch (Exception e) {
            System.out.println("Entrada inválida. Intente nuevamente.");
            menu();
        }
        switch (respuesta) {
            case 1:
                Game.play();
                menu();
                break;
            case 2:
                System.out.println("Bye bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Entrada inválida. Intente nuevamente.");
                menu();
        }
    }

    /**
     * Despliega la interfaz del menu.
     */
    public static void displayMenu() {
        System.out.println(
                "+----------------+\n" +
                "|MENU            |\n" +
                "+----------------+\n" +
                "|Enter 1 to play.|\n" +
                "|Enter 2 to exit.|\n" +
                "+----------------+\n");
    }

    /**
     * Ingresa inputs del teclado.
     */
    public static String getInput() {
        return new Scanner(System.in).next();
    }
}
