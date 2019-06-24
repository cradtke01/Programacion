package data;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileManagerTest {

    @org.junit.jupiter.api.Test
    void writeReadDelete() {
        FileManager.writeFile("testText.txt","content");
        assertEquals("content",FileManager.readFile("testText.txt"));
        FileManager.deleteFile("testText.txt");
    }

}