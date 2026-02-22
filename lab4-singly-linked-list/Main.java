import java.util.Scanner;

public class Main {

    private static void printMenu() {
        System.out.println("\n=== Music Playlist (Singly Linked List) ===");
        System.out.println("1) Add song");
        System.out.println("2) Display playlist");
        System.out.println("3) Play next");
        System.out.println("4) Remove song by title");
        System.out.println("5) Exit");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine().trim();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine().trim();

                    if (title.isEmpty() || artist.isEmpty()) {
                        System.out.println("Title and artist cannot be empty.");
                    } else {
                        playlist.addSong(new Song(title, artist));
                        System.out.println("Added: \"" + title + "\" by " + artist);
                    }
                }
                case "2" -> {
                    System.out.println("\n--- Playlist (" + playlist.size() + " songs) ---");
                    playlist.displayPlaylist();
                }
                case "3" -> {
                    Song playing = playlist.playNext();
                    if (playing == null) {
                        System.out.println("No songs to play (playlist is empty).");
                    } else {
                        System.out.println("Now playing: " + playing);
                    }
                }
                case "4" -> {
                    System.out.print("Enter the title to remove: ");
                    String title = scanner.nextLine().trim();
                    boolean removed = playlist.removeSong(title);
                    System.out.println(removed ? "Removed: " + title : "Song not found: " + title);
                }
                case "5" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option. Please choose 1-5.");
            }
        }

        scanner.close();
    }
}

