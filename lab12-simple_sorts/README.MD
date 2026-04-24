 Implementing Simple Sorts (Bubble & Insertion)
Objective
Implement and test the O(n^2) sorting algorithms Bubble Sort and Insertion Sort as described in the lecture/text. You will use the generic Comparator interface to make your sorts work with any data type.

Requirements
Create a SimpleSorters.java file. This file will contain your SimpleSorters class with static methods for each sort.
public static void bubbleSort(K[] S, Comparator comp):
Implement the optimized version of Bubble Sort that uses a boolean swapped flag to stop early if the array is already sorted.
This allows for O(n) best-case performance.
public static void insertionSort(K[] S, Comparator comp):
Implement the standard Insertion Sort algorithm, which mimics sorting a hand of playing cards.
It should iterate from i = 1, storing S[i] as cur, and shift elements greater than cur to the right.
Create a SimpleSortDriver.java file to test your implementations.
The driver must test both algorithms on at least three arrays:
An unsorted array of Integers.
A reverse-sorted array (worst-case for Insertion Sort).
An already-sorted array (best-case for optimized Bubble Sort and Insertion Sort).
The driver must print the array before and after each sort to verify correctness. Use Arrays.toString() for easy printing.
Code Templates
SimpleSorters.java
import java.util.Comparator;

public class SimpleSorters {

    /**
     * Sorts an array using the optimized Bubble Sort algorithm.
     */
    public static  void bubbleSort(K[] S, Comparator comp) {
        int n = S.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            // TODO: Implement the inner loop j
            // ...
                if (comp.compare(S[j], S[j + 1]) > 0) {
                    // TODO: Swap S[j] and S[j+1]
                    swapped = true;
                }
            // ... end inner loop ...

            // TODO: Add check for early termination
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Sorts an array using the Insertion Sort algorithm.
     */
    public static  void insertionSort(K[] S, Comparator comp) {
        int n = S.length;
        for (int i = 1; i < n; i++) {
            K cur = S[i];
            int j = i - 1;

            // TODO: Implement the while loop to shift elements
            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            // TODO: Insert 'cur' into its correct position
            S[j + 1] = cur;
        }
    }
}
SimpleSortDriver.java
import java.util.Arrays;
import java.util.Comparator;

public class SimpleSortDriver {
    public static void main(String[] args) {
        // Use a standard Integer comparator
        Comparator comp = Comparator.naturalOrder();

        // Test 1: Unsorted Array
        Integer[] arr1 = {5, 1, 9, 3, 7, 6};
        Integer[] arr1_copy = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test 1: Unsorted Array ---");
        System.out.println("Original: " + Arrays.toString(arr1));
        SimpleSorters.bubbleSort(arr1, comp);
        System.out.println("Bubble Sort: " + Arrays.toString(arr1));

        System.out.println("Original: " + Arrays.toString(arr1_copy));
        SimpleSorters.insertionSort(arr1_copy, comp);
        System.out.println("Insertion Sort: " + Arrays.toString(arr1_copy));

        // TODO: Add Test 2 (Reverse-Sorted) and Test 3 (Already-Sorted)
    }
}
