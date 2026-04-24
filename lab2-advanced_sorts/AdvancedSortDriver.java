import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AdvancedSortDriver {

    public static void main(String[] args) {
        Comparator<Integer> comp = Comparator.naturalOrder();

        int N = 100;
        Random rand = new Random();

        Integer[] arr1 = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = rand.nextInt(1000);
        }

        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test: Random Array (N=100) ---");
        System.out.println("Original:");
        System.out.println(Arrays.toString(arr1));
        System.out.println();

        AdvancedSorters.mergeSort(arr1, comp);
        System.out.println("Merge Sort:");
        System.out.println(Arrays.toString(arr1));
        System.out.println();

        AdvancedSorters.quickSort(arr2, comp);
        System.out.println("Quick Sort:");
        System.out.println(Arrays.toString(arr2));
    }
}
