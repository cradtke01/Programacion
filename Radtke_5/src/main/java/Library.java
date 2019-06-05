import java.util.ArrayList;

public class Library {

    /**
     * Array to manage the songs.
     */
    public static ArrayList<Song> songs = new ArrayList<Song>();

    /**
     * Adds a new song to the array and creates a file for it's lyrics.
     *
     * @param title
     * @param authorName
     * @param albumName
     * @param year
     * @param lyrics
     */
    public static void addSong(String title, String authorName, String albumName, int year, String lyrics) {
        FileManager.writeFile((title + ".txt").replace(' ', '_'), lyrics);
        songs.add(new Song(songs.size(), title, authorName, albumName, year));
        Library.saveSongs();
    }

    /**
     * Shows all songs.
     */
    public static void showSong() {
        for (int i = 0; i < songs.size(); i++) {
            System.out.println(songs.get(i).toString());
        }
    }

    /**
     * Gets the lyrics for the song of the given id.
     *
     * @param id
     * @return String
     */
    public static String showLyrics(int id) {
        return FileManager.readFile((Library.songs.get(id).getTitle() + ".txt").replace(' ', '_'));
    }

    /**
     * Deletes the song of the given id.
     *
     * @param id
     */
    public static void deleteSong(int id) {
        FileManager.deleteFile((songs.get(id).getTitle() + ".txt").replace(' ', '_'));
        songs.remove(id);
        songs.trimToSize();
        saveSongs();
    }

    /**
     * Loads the songs from the files into the array
     */
    public static void loadSongs() {
        String[] individualSongs = FileManager.readFile("songs.txt").split("\n");
        for (int i = 0; i < individualSongs.length; i++) {
            Song song = new Song(i, "name", "author", "albumName", 0);
            Library.songs.add(song);
        }
        for (int i = 0; i < individualSongs.length; i++) {
            Library.songs.set(Integer.parseInt(individualSongs[i].split(";")[0].split(":")[1]), new Song(
                    Integer.parseInt(individualSongs[i].split(";")[0].split(":")[1]),
                    individualSongs[i].split(";")[1].split(":")[1],
                    individualSongs[i].split(";")[2].split(":")[1],
                    individualSongs[i].split(";")[3].split(":")[1],
                    Integer.parseInt(individualSongs[i].split(";")[4].split(":")[1])));
        }
    }

    /**
     * Saves the songs from the array into the files.
     */
    public static void saveSongs() {
        FileManager.writeFile("songs.txt", "");
        for (int i = 0; i < songs.size(); i++) {
            FileManager.writeFile("songs.txt",
                    FileManager.readFile("songs.txt") +
                            "id:" + songs.get(i).getId() +
                            ";title:" + songs.get(i).getTitle() +
                            ";author:" + songs.get(i).getAuthorName() +
                            ";album:" + songs.get(i).getAlbumName() +
                            ";year:" + songs.get(i).getYear() +
                            ";\n");
        }
        FileManager.writeFile("songs.txt", FileManager.readFile("songs.txt").trim());
    }
}