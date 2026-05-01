Instructions
Below is a runnable Java template containing five incomplete methods. Your task is to replace the TODO comments with correct, working code.

Recursion:

Method: recursiveFibonacci(int n)

Goal: Write a recursive function that calculates the $n^{th}$ Fibonacci number.

Key Requirement: Identify multiple Base Cases ($n=0$ and $n=1$) and the Recursive Step where the problem reduces by summing the two previous values.

Analysis of Algorithms:

Method: findSecondMax(int[] arr)

Goal: Implement an algorithm to find the second largest value in an integer array.

Constraint: Your solution must be efficient, traversing the array only once (Time Complexity: $O(n)$).

Trees:

Method: sumLeafNodes(Node root)

Goal: Write a recursive method to sum the values of only the leaf nodes (nodes with no children).

Hint: If a node is null, return 0. If it is a leaf, return its value. Otherwise, return the sum of its children's leaf sums.

Search Algorithms:

Method: binarySearch(int[] arr, int target)

Goal: Implement a Binary Search algorithm to find a specific target value in a sorted array.

Return: The index of the target if found, or -1 if it is not in the array.

Sorting Algorithms:

Method: selectionSort(int[] arr)

Goal: Implement the Selection Sort algorithm to sort an array in ascending order.

Key Requirement: Find the minimum element in the unsorted portion and perform exactly one swap per outer loop iteration.

Testing Your Work
The main method in the template is pre-configured with test cases for all five methods.

Run the Code: Initially, the tests will fail (printing [FAIL]) because the methods are empty or return placeholders.

Implement: As you correctly implement each method, re-run the code.

Verify: Your goal is to get all 5 tests to print [PASS].

Submission
Once all tests pass, upload your completed DataStructures.java file to your GitHub (Exam2 directory), then paste the link in Question 17. Upload a screenshot of the program run in Question 18. Ensure your code is clean, indented, and free of syntax errors.

Code Template
Java
import java.util.*;

public class DataStructures {
     // ==========================================
     // 1. RECURSION
     // ==========================================
     /**
     * TODO: Calculate the nth Fibonacci number recursively.
     * sequence: 0, 1, 1, 2, 3, 5, 8, 13...
     * Example: fib(6) -> 8
     */
     public static int recursiveFibonacci(int n) {
          // 1. Write the Base Cases (for n=0 and n=1)
          // 2. Write the Recursive Step
          return 0; // Placeholder return
      }

      // ==========================================
      // 2. ANALYSIS OF ALGORITHMS
      // ==========================================
      /**
      * TODO: Find and return the SECOND LARGEST value in an array.
      * Constraint: Try to do this with O(n) time complexity (single pass).
      */
      public static int findSecondMax(int[] arr) {
          if (arr == null || arr.length < 2) {
               throw new IllegalArgumentException("Array must have at least two elements"); 
          }
          // TODO: Implement the logic to find the second maximum
          return 0; // Placeholder return
       }

       // ==========================================
       // 3. TREES
       // ==========================================
       static class Node {
           int value;
           Node left, right;
           public Node(int value) {
               this.value = value;
               this.left = null;
               this.right = null;
           }
       }

     /**
     * TODO: Return the sum of values of ONLY the leaf nodes.
     * A leaf is a node with no children (left and right are both null).
     */
     public static int sumLeafNodes(Node root) {
          // TODO: Write the recursive logic here
         return 0; // Placeholder return
      }

      // ==========================================
      // 4. SEARCH ALGORITHMS
      // ==========================================
      /**
      * TODO: Implement Binary Search on a SORTED array.
      * Return the index of the target if found, otherwise return -1.
      */
      public static int binarySearch(int[] arr, int target) {
          // TODO: Implement the while loop with low, high, and mid logic
          return -1; // Placeholder return
      }

      // ==========================================
      // 5. SORTING ALGORITHMS
      // ==========================================
      /**
      * TODO: Implement Selection Sort to sort the array in ascending order.
      * Hint: Find the minimum in the unsorted part and swap once per pass.
      */
      public static void selectionSort(int[] arr) {
          int n = arr.length;
          // TODO: Write the outer and inner loops
          // TODO: Implement the finding of the minimum and the swap
      }

      // ==========================================
      // TEST DRIVER (Do not modify this part)
      // ==========================================
      public static void main(String[] args) {
          System.out.println("=== Coding Advanced Data Structures ===\n");

          // Test 1: Recursion (Fibonacci)
          int fibN = 6;
          int expectedFib = 8;
          int actualFib = recursiveFibonacci(fibN);
          printTestResult("1. Recursion (Fibonacci)", expectedFib, actualFib);

          // Test 2: Analysis (Second Max)
          int[] numbers = {10, 5, 20, 8, 15};
          int expectedSecondMax = 15;
          int actualSecondMax = findSecondMax(numbers);
          printTestResult("2. Analysis (Second Max)", expectedSecondMax, actualSecondMax);

          // Test 3: Trees (Leaf Sum)
          // Constructing tree: 
          //       1
          //      / \
          //     2   3 (Leaf)
          //    /
          //   4 (Leaf)
          Node root = new Node(1);
          root.left = new Node(2);
          root.right = new Node(3);
          root.left.left = new Node(4);
          int expectedLeafSum = 7; // Nodes 3 and 4 are leaves
          int actualLeafSum = sumLeafNodes(root);
          printTestResult("3. Trees (Leaf Sum)", expectedLeafSum, actualLeafSum);

          // Test 4: Search (Binary Search)
          int[] sortedData = {1, 2, 4, 7, 9};
          int target = 7;
          int expectedIndex = 3;
          int actualIndex = binarySearch(sortedData, target);
          printTestResult("4. Search (Binary)", expectedIndex, actualIndex);

          // Test 5: Sorting (Selection Sort)
          int[] sortData = {64, 25, 12, 22, 11};
          String expectedSort = "[11, 12, 22, 25, 64]";
          selectionSort(sortData);
          String actualSort = Arrays.toString(sortData);
          System.out.println("[Test 5] Sorting (Selection Sort)");
          System.out.println(" Expected: " + expectedSort);
          System.out.println(" Actual: " + actualSort);
          if (expectedSort.equals(actualSort)) {
                   System.out.println(" Result: [PASS]");          
          } else {
               System.out.println(" Result: [FAIL]");
          }
          System.out.println();
      }

      // Helper to print results
      private static void printTestResult(String testName, int expected, int actual) {
         System.out.println("[Test] " + testName);
         System.out.println(" Expected: " + expected);
         System.out.println(" Actual: " + actual);
         if (expected == actual) {
             System.out.println(" Result: [PASS]");
         } else {
            System.out.println(" Result: [FAIL]");
         }
         System.out.println();
      }
}
