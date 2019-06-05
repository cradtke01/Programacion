import java.io.File;
        import java.nio.file.Files;
        import java.nio.file.Paths;

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
}
