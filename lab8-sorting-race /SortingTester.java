
import java.util.Random;

public class SortingTester {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n======================================");
            System.out.println("Testing for array size n = " + n);
            System.out.println("======================================");

            runAndTimeAllSorts("Average Case (Random)", generateRandomArray(n));
            runAndTimeAllSorts("Best Case (Sorted)", generateSortedArray(n));
            runAndTimeAllSorts("Worst Case (Reverse Sorted)", generateReverseSortedArray(n));
        }
    }

    /**
     * Runs all three sorting algorithms on copies of the same input array
     * and prints their execution times.
     */
    public static void runAndTimeAllSorts(String caseName, int[] original) {
        System.out.println("\n--- " + caseName + " ---");

        // Selection Sort
        int[] selectionArray = original.clone();
        long start = System.nanoTime();
        SortingAlgorithms.selectionSort(selectionArray);
        long end = System.nanoTime();
        printResult("Selection Sort", end - start, isSorted(selectionArray));

        // Insertion Sort
        int[] insertionArray = original.clone();
        start = System.nanoTime();
        SortingAlgorithms.insertionSort(insertionArray);
        end = System.nanoTime();
        printResult("Insertion Sort", end - start, isSorted(insertionArray));

        // Merge Sort
        int[] mergeArray = original.clone();
        start = System.nanoTime();
        SortingAlgorithms.mergeSort(mergeArray);
        end = System.nanoTime();
        printResult("Merge Sort", end - start, isSorted(mergeArray));
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = RANDOM.nextInt(1_000_000);
        }
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printResult(String algorithmName, long nanoseconds, boolean sortedCorrectly) {
        double milliseconds = nanoseconds / 1_000_000.0;
        System.out.printf("%-15s : %12.3f ms   | Sorted Correctly: %s%n",
                algorithmName, milliseconds, sortedCorrectly ? "Yes" : "No");
    }
}
