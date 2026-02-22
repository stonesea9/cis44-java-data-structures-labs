import java.util.Scanner;

public class Main {

    private static void printMenu() {
        System.out.println("\n=== Text Editor (Doubly Linked List Undo/Redo) ===");
        System.out.println("1) Type / Add text");
        System.out.println("2) Undo");
        System.out.println("3) Redo");
        System.out.println("4) Print current text");
        System.out.println("5) Exit");
        System.out.print("Choose: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter text to append: ");
                    String newText = scanner.nextLine(); // keep spaces
                    editor.add(newText);
                    System.out.println("Added. Now:");
                    editor.printCurrent();
                }
                case "2" -> {
                    String state = editor.undo();
                    System.out.println("Undo -> " + state);
                }
                case "3" -> {
                    String state = editor.redo();
                    System.out.println("Redo -> " + state);
                }
                case "4" -> editor.printCurrent();
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
