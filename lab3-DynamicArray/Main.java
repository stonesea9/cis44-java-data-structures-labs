import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DynamicArray<Integer> numbers = new DynamicArray<>();

        // 1. Add initial elements
        int i;
        for (i = 1; i <= 15; i++) {
            numbers.add(i * 10);
        }

        System.out.println("Initial DynamicArray:");
        System.out.println(numbers);
        System.out.println();
        System.out.println("Size after adding 15 elements = " + numbers.size());
        System.out.println("(Resize happened when size exceeded 10)");
        System.out.println();
        System.out.println("Size = " + numbers.size());
        System.out.println("capacity = " + numbers.length());
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        // 2. Get element by user input
        try {
            System.out.print("Enter an index to get an element: ");
            int getIndex = scanner.nextInt();

            int value = numbers.get(getIndex);
            System.out.println("Element at index " + getIndex + " is: " + value);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds.");

        } catch (Exception e) {
            System.out.println("Error: Please enter a valid integer.");
            scanner.nextLine(); // clear invalid input
        }

        System.out.println();
        System.out.println("Current DynamicArray:");
        System.out.println(numbers);
        System.out.println();

        // 3. Remove element by user input
        try {
            System.out.print("Enter an index to remove an element: ");
            int removeIndex = scanner.nextInt();

            int removed = numbers.remove(removeIndex);
            System.out.println("Removed element: " + removed);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds.");

        } catch (Exception e) {
            System.out.println("Error: Please enter a valid integer.");
        }

        System.out.println();
        System.out.println("DynamicArray after removal:");
        System.out.println(numbers);
        System.out.println("Size = " + numbers.size());

        scanner.close();
    }
}
