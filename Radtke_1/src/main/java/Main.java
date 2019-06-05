/*
cradtke01
Programacion.
Lee completo un archivo de texto y luego añade una nueva linea al final
 */

public class Main {

    public static void main(String[] args) {
        System.out.println(FileManager.readFile("texto.txt"));
        FileManager.writeFile("texto.txt", FileManager.readFile("texto.txt") + "\n" + "The first man who stepped on the moon.");
        System.out.println(FileManager.readFile("texto.txt"));
    }
}