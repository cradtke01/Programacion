import java.util.ArrayList;

public class Main {
    //Inicializa y carga los datos de sesiones anteriores en el arreglo tShirts.
    public static void main(String[] args) {
        ArrayList<TShirt> tShirts = new ArrayList<TShirt>();
        FileManager.loadData(tShirts);
        UserInteraction.menu(tShirts);
    }
}
