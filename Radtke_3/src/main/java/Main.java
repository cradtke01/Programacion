import java.util.ArrayList;

public class Main {
    /**
     *Inicializa y carga los datos de sesiones anteriores en el arreglo zapatillas.
     */
    public static void main(String[] args) {
        ArrayList<Zapatilla> zapatillas = new ArrayList<Zapatilla>();
        GestorArchivos.cargarDatos(zapatillas);
        InteraccionConUsuario.menu(zapatillas);
    }
}
