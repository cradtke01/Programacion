public class Main {

    /**
     * Loads files and gets the menu running.
     *
     * @param args
     */
    public static void main(String[] args) {
        Library.loadSongs();
        UserInteraction.menu();
    }
}