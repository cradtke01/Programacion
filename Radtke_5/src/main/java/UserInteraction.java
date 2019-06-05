import java.util.Scanner;

public class UserInteraction {

    /**
     * Manages the user's selections.
     *
     * @return void
     */
    public static void menu() {
        showMenu();
        int answer = 0;
        try {
            answer = Integer.parseInt(getInput());
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            menu();
        }
        switch (answer) {
            case 1:
                Library.showSong();
                menu();
                break;
            case 2:
                System.out.println("Enter the id of the song you want the lyrics from.");
                try {
                    int id = Integer.parseInt(getInput());
                    Library.showLyrics(id);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                }
                menu();
                break;
            case 3:
                System.out.println("Enter the title of the new song.");
                String title = new Scanner(System.in).nextLine();
                System.out.println("Enter the name of the author of the new song.");
                String authorName = new Scanner(System.in).nextLine();
                System.out.println("Enter the name of the album of the new song.");
                String albumName = new Scanner(System.in).nextLine();
                System.out.println("Enter the year of release of the new song.");
                int year = 0;
                boolean error;
                do {
                    try {
                        year = Integer.parseInt(getInput());
                        error = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please try again.");
                        error = true;
                    }
                } while (error);
                System.out.println("Enter the lyrics of the new song.");
                String lyrics = new Scanner(System.in).nextLine();
                Library.addSong(title, authorName, albumName, year, lyrics);
                menu();
                break;
            case 4:
                System.out.println("Enter the id of the song to be deleted.");
                try {
                    int id = Integer.parseInt(getInput());
                    Library.deleteSong(id);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                }
                menu();
                break;
            case 5:
                Library.saveSongs();
                System.out.println("Bye bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                menu();
        }
    }


    /**
     * Shows the menu options.
     *
     * @return void
     */
    public static void showMenu() {
        System.out.println("+--------------------------------------+\n" +
                "|MENU                                  |\n" +
                "+--------------------------------------+\n" +
                "|Enter 1 to show all songs.            |\n" +
                "|Enter 2 to show the lyrics of a songs.|\n" +
                "|Enter 3 to add a song.                |\n" +
                "|Enter 4 to delete a song.             |\n" +
                "|Enter 5 to exit.                      |\n" +
                "+--------------------------------------+\n");
    }


    /**
     * Reads user inputs.
     *
     * @return String
     */
    public static String getInput() {
        return new Scanner(System.in).next();
    }
}