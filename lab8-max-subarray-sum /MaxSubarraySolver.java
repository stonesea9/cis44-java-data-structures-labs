public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     *
     * Primitive operation analysis:
     * Let n = arr.length.
     *
     * Outer loop runs n times.
     * For each i, the inner loop runs from j = i to n - 1.
     * That gives:
     * n + (n - 1) + (n - 2) + ... + 1
     * = n(n + 1) / 2
     *
     * Inside the inner loop, we do only constant-time work:
     * - currentSum += arr[j]
     * - compare currentSum > maxSum
     * - maybe assign maxSum
     *
     * So total primitive operations are proportional to
     * n(n + 1) / 2, which is O(n^2).
     */
    public static int bruteForceMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }

        int maxSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;

            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     *
     * Analysis:
     * This algorithm makes a single pass through the array.
     * The loop runs n - 1 times after initialization.
     *
     * In each iteration, it performs only constant-time work:
     * - one comparison for Math.max(arr[i], currentMax + arr[i])
     * - one addition
     * - one comparison for Math.max(globalMax, currentMax)
     *
     * Since the algorithm uses one loop and constant work per iteration,
     * its running time is O(n).
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }

        int currentMax = arr[0];
        int globalMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }
}
