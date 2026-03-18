
Objective
This project's goal is to empirically demonstrate the performance differences between algorithms with varying time complexities. You will implement three sorting algorithms, conduct an experimental analysis by timing them with different input sizes and types (best-case, worst-case, average-case), and compare your practical results to their known theoretical complexities.

Requirements
Implement Sorting Algorithms: In Java, implement the following three sorting algorithms. You must write the code yourself, not use built-in Java sorting methods.
Research and implement selection Sort: A straightforward O(n^2) algorithm.
Research and implement insertion Sort: An O(n^2) algorithm that has a best-case performance of O(n).
Research and implement merge Sort: A more complex divide-and-conquer algorithm with O(n log n) complexity.
Create a Testing Framework: Your main method or a dedicated tester class should be able to:
Generate Test Data: Create methods to generate integer arrays of a given size n for three scenarios: Average Case (random integers), Best Case (sorted ascending), and Worst Case (sorted descending).
Time Execution: Use System.nanoTime() to accurately measure the execution time of each sorting algorithm.
Automate Testing: Run each sorting algorithm on all three data scenarios for a range of input sizes, for example: n = 1000, 5000, 10000, 25000, 50000, 100000.
