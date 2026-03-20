import java.util.Random;

public class SubarrayTester {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n==============================================");
            System.out.println("Testing for array size n = " + n);
            System.out.println("==============================================");

            int[] arr = generateRandomArrayWithNegatives(n);

            runAndTimeAlgorithms(arr);
        }
    }

    private static void runAndTimeAlgorithms(int[] original) {
        int[] arr1 = original.clone();
        int[] arr2 = original.clone();

        // Brute force timing
        long start = System.nanoTime();
        int bruteForceResult = MaxSubarraySolver.bruteForceMaxSum(arr1);
        long end = System.nanoTime();
        long bruteForceTime = end - start;

        // Kadane timing
        start = System.nanoTime();
        int kadaneResult = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr2);
        end = System.nanoTime();
        long kadaneTime = end - start;

        // Verify both algorithms produce the same answer
        boolean sameResult = bruteForceResult == kadaneResult;

        System.out.printf("Brute Force  Result: %12d | Time: %12.3f ms%n",
                bruteForceResult, bruteForceTime / 1_000_000.0);

        System.out.printf("Kadane's     Result: %12d | Time: %12.3f ms%n",
                kadaneResult, kadaneTime / 1_000_000.0);

        System.out.println("Results Match: " + (sameResult ? "Yes" : "No"));
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            // Random values from -1000 to 1000
            arr[i] = RANDOM.nextInt(2001) - 1000;
        }

        return arr;
    }
}
