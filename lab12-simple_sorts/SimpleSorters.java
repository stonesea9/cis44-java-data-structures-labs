import java.util.Comparator;

public class SimpleSorters {

    /**
     * Sorts an array using the optimized Bubble Sort algorithm.
     * Best case: O(n) when the array is already sorted.
     * Worst case: O(n^2).
     */
    public static <K> void bubbleSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // After each pass, the largest item moves to the end,
            // so we do not need to check the last i elements again.
            for (int j = 0; j < n - 1 - i; j++) {
                if (comp.compare(S[j], S[j + 1]) > 0) {
                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swap happened, the array is already sorted.
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Sorts an array using the Insertion Sort algorithm.
     * Best case: O(n) when the array is already sorted.
     * Worst case: O(n^2), especially for reverse-sorted arrays.
     */
    public static <K> void insertionSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 1; i < n; i++) {
            K cur = S[i];
            int j = i - 1;

            // Shift elements greater than cur one position to the right.
            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            // Insert cur into the correct position.
            S[j + 1] = cur;
        }
    }
}
