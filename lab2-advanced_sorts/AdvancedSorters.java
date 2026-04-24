import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    // --- Merge Sort ---

    /**
     * Sorts an array using Merge Sort.
     * Time complexity: O(n log n)
     * Space complexity: O(n)
     */
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        // Base case
        if (n < 2) {
            return;
        }

        // Divide
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        // Conquer
        mergeSort(S1, comp);
        mergeSort(S2, comp);

        // Combine
        merge(S, S1, S2, comp);
    }

    /**
     * Merges two sorted arrays S1 and S2 back into S.
     */
    private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator<K> comp) {
        int i = 0; // index for S1
        int j = 0; // index for S2
        int k = 0; // index for S

        // Compare elements from S1 and S2, then copy the smaller one into S.
        while (i < S1.length && j < S2.length) {
            if (comp.compare(S1[i], S2[j]) <= 0) {
                S[k] = S1[i];
                i++;
            } else {
                S[k] = S2[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from S1.
        while (i < S1.length) {
            S[k] = S1[i];
            i++;
            k++;
        }

        // Copy any remaining elements from S2.
        while (j < S2.length) {
            S[k] = S2[j];
            j++;
            k++;
        }
    }

    // --- Quick Sort ---

    /**
     * Sorts an array using Quick Sort.
     * Average time complexity: O(n log n)
     * Worst-case time complexity: O(n^2)
     * Space complexity: O(log n) average because of recursion.
     */
    public static <K> void quickSort(K[] S, Comparator<K> comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    /**
     * Recursive Quick Sort helper.
     */
    private static <K> void quickSort(K[] S, Comparator<K> comp, int a, int b) {
        // Base case
        if (a >= b) {
            return;
        }

        // Divide
        int pivotIndex = partition(S, comp, a, b);

        // Conquer
        quickSort(S, comp, a, pivotIndex - 1);
        quickSort(S, comp, pivotIndex + 1, b);
    }

    /**
     * Partitions the array using the first element as the pivot.
     * Elements smaller than or equal to the pivot go to the left.
     * Elements greater than the pivot go to the right.
     */
    private static <K> int partition(K[] S, Comparator<K> comp, int a, int b) {
        K pivot = S[a];
        int left = a + 1;
        int right = b;

        while (left <= right) {
            // Move left forward while S[left] <= pivot.
            while (left <= right && comp.compare(S[left], pivot) <= 0) {
                left++;
            }

            // Move right backward while S[right] > pivot.
            while (left <= right && comp.compare(S[right], pivot) > 0) {
                right--;
            }

            // Swap items that are on the wrong side.
            if (left < right) {
                K temp = S[left];
                S[left] = S[right];
                S[right] = temp;

                left++;
                right--;
            }
        }

        // Put pivot into its final position.
        S[a] = S[right];
        S[right] = pivot;

        return right;
    }
}
