
Part 2: The Maximum Subarray Sum
Objective
Highlight how a superior algorithm design can produce a solution that is orders of magnitude faster by solving the Maximum Subarray Sum problem with two different algorithms.

The Problem
Given an array of integers (which can include both positive and negative numbers), find the contiguous subarray with the largest possible sum.

Example: For the array [-2, 1, -3, 4, -1, 2, 1, -5, 4], the maximum subarray is [4, -1, 2, 1], and its sum is 6.

Requirements
Algorithm 1: The Brute-Force Approach (O(n^2)): Implement a method that finds the maximum subarray sum by systematically checking every possible subarray using nested loops. In your code comments, perform a "primitive operation" count to formally show why this algorithm is O(n^2).
Algorithm 2: Kadane's Algorithm (O(n)): Research and implement Kadane's Algorithm, a dynamic programming approach that solves this problem in a single pass. In your code comments, analyze this single-loop algorithm to explain why it is O(n).
Experimental Comparison: Create a testing framework to time both of your algorithms on arrays of random integers (including negatives) for a range of sizes, e.g., n = 1000, 5000, 10000, 50000, 100000.
