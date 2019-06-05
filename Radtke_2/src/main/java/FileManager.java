import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileManager {

    public static String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            System.out.println("File could not be read.");
            return "";
        }
    }

    public static void writeFile(String filePath, String fileContent) {
        try {
            Files.write(Paths.get(filePath), fileContent.getBytes());
        } catch (Exception e) {
            System.out.println("File could not be written.");
        }
    }

    public static void deleteFile(String filePath) {
        if (new File(filePath).delete()) {
        } else System.out.println("File could not be deleted.");
    }

    //----------------------------------------------------------------------------------------------------------------//

    //Metodo que carga los datos desde el archivo al programa.
    public static void loadData(ArrayList<TShirt> tShirts) {
        String data = FileManager.readFile("src/main/tShirts.csv");
        if (!data.equals("")) {
            String[] tShirtObjects = data.split("\n");
            for (int i = 1; i < tShirtObjects.length; i++) {
                String[] tShirtAttributes = tShirtObjects[i].split(",");
                try {
                    tShirts.add(i - 1, new TShirt(Boolean.parseBoolean(tShirtAttributes[0]), Integer.parseInt(tShirtAttributes[1]), tShirtAttributes[2], tShirtAttributes[3]));
                } catch (Exception e) {
                    System.out.println("A ocurrido un error en el formato de tShirt.csv.");
                    System.exit(0);
                }
            }
        }
    }

    //Metodo que guarda los datos desde el programa al archivo.
    public static void saveData(ArrayList<TShirt> tShirts) {
        FileManager.writeFile("src/main/tShirts.csv", "printed,id,material,size");
        for (TShirt tShirt : tShirts) {
            FileManager.writeFile("src/main/tShirts.csv", FileManager.readFile("src/main/tShirts.csv") + "\n" + tShirt.isPrinted() + "," + tShirt.getId() + "," + tShirt.getMaterial() + "," + tShirt.getSize());
        }
    }
}