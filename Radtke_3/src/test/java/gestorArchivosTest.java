import java.io.IOException;

class gestorArchivosTest {

    @org.junit.jupiter.api.Test
    void leerArchivoInexistente() {
        System.out.println(GestorArchivos.leerArchivo("ArchivoNoExistente.file"));
    }

    @org.junit.jupiter.api.Test
    void escribirArchivoInexistente() throws IOException {
        GestorArchivos.escribirArchivo("ArchivoNoExistente.file","ejemplo");
    }
}