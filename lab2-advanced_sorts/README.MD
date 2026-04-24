Project 2: Implementing Divide-and-Conquer Sorts (Merge-Sort & Quick-Sort)
Objective
Implement the O(n log n) sorting algorithms Merge Sort and Quick Sort using the Divide-and-Conquer paradigm discussed in the lecture/text.

Requirements
Create an AdvancedSorters.java file. This class will contain static methods for each sort.
MergeSort:
public static void mergeSort(K[] S, Comparator comp): The public "wrapper" method. It should handle the base case (n < 2) and create the temporary arrays S1 and S2 using Arrays.copyOfRange().
It will then make recursive calls to mergeSort on S1 and S2.
Finally, it will call the merge helper method to combine the results back into S.
private static void merge(K[] S, K[] S1, K[] S2, Comparator comp): A private helper method that merges the two sorted arrays (S1, S2) into the original array (S). This method is responsible for the O(n) space complexity.
QuickSort:
public static void quickSort(K[] S, Comparator comp): The public "wrapper" method. It just calls the recursive helper.
private static void quickSort(K[] S, Comparator comp, int a, int b): The private recursive helper. It handles the base case (a >= b), calls partition, and then makes two recursive calls on the sub-arrays.
private static int partition(K[] S, Comparator comp, int a, int b): A private helper that implements the in-place partition logic (e.g., Hoare partitioning from the lecture). It chooses a pivot, rearranges the sub-array, and returns the final index of the pivot.
Create an AdvancedSortDriver.java file to test your implementations.
The driver must test both algorithms on a large (e.g., 100+ elements) array of Integers. You can use java.util.Random to populate this array.
The driver must print the sorted arrays (or a subset) to verify correctness.
Code Templates
AdvancedSorters.java
import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    // --- MergeSort ---
    public static  void mergeSort(K[] S, Comparator comp) {
        int n = S.length;
        if (n < 2) return; // Base case

        // TODO: Divide
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        // TODO: Conquer (recursive calls)
        mergeSort(S1, comp);
        mergeSort(S2, comp);

        // TODO: Combine
        merge(S, S1, S2, comp);
    }

    private static  void merge(K[] S, K[] S1, K[] S2, Comparator comp) {
        int i = 0, j = 0;
        // TODO: Implement the merge logic from the lecture
        // while (i < S1.length && j < S2.length) ...
        // ...
        // TODO: Copy remaining elements of S1 or S2
        // ...
    }

    // --- QuickSort ---
    public static  void quickSort(K[] S, Comparator comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    private static  void quickSort(K[] S, Comparator comp, int a, int b) {
        if (a >= b) return; // Base case

        // TODO: Divide
        int pivotIndex = partition(S, comp, a, b);

        // TODO: Conquer (recursive calls)
        quickSort(S, comp, a, pivotIndex - 1);
        quickSort(S, comp, pivotIndex + 1, b);
    }

    private static  int partition(K[] S, Comparator comp, int a, int b) {
        // TODO: Implement partition logic (e.g., Hoare's from lecture)
        // 1. Choose a pivot (e.g., S[a])
        // 2. Set up 'left' and 'right' pointers
        // 3. Loop and swap elements
        // 4. Return the final index of the pivot
        return a; // placeholder
    }
}
AdvancedSortDriver.java
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AdvancedSortDriver {
    public static void main(String[] args) {
        Comparator comp = Comparator.naturalOrder();
        int N = 20;
        Random rand = new Random();

        Integer[] arr1 = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = rand.nextInt(100);
        }
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test: Random Array (N=20) ---");
        System.out.println("Original: " + Arrays.toString(arr1));

        AdvancedSorters.mergeSort(arr1, comp);
        System.out.println("Merge Sort: " + Arrays.toString(arr1));

        System.out.println("Original: " + Arrays.toString(arr2));
        AdvancedSorters.quickSort(arr2, comp);
        System.out.println("Quick Sort: " + Arrays.toString(arr2));
 nbsp; }br}/pre
/div
