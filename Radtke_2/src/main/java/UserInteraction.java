import java.util.ArrayList;
import java.util.Scanner;

public class UserInteraction {

    //Gestiona la eleccion del usuario.
    public static void menu(ArrayList<TShirt> tShirts) {
        showMenu();
        int answer = 0;
        try {
            answer = Integer.parseInt(getInput());
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            menu(tShirts);
        }
        switch (answer) {
            case 1:
                TShirt.showTShirts(tShirts);
                menu(tShirts);
                break;
            case 2:
                TShirt.createTShirt(tShirts);
                menu(tShirts);
                break;
            case 3:
                TShirt.deleteTShirt(tShirts);
                menu(tShirts);
                break;
            case 4:
                System.out.println("Bye bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                menu(tShirts);
        }
    }

    //Muestra las opciones del menu.
    public static void showMenu() {
        System.out.println("+-----------------------------+\n" +
                "|MENU                         |\n" +
                "+-----------------------------+\n" +
                "|Enter 1 to show all T-Shirts.|\n" +
                "|Enter 2 to create a T-Shirt. |\n" +
                "|Enter 3 to delete a T-Shirt. |\n" +
                "|Enter 4 to exit.             |\n" +
                "+-----------------------------+\n");
    }

    //Metodo generico para recibir entradas del usuario.
    public static String getInput() {
        return new Scanner(System.in).next();
    }
}
