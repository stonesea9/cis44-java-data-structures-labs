Project 2: Heap Priority Queue & Heap-Sort
Objective: Implement a generic Min-Heap using an Array (or ArrayList) to achieve O(log n) efficiency for both insertion and removal, and then use it to perform Heap-Sort.

Requirements:

Implement HeapPriorityQueue using an ArrayList internally.
Implement upheap and downheap operations.
Implement HeapSorter to sort an array by inserting all elements into the heap and then removing them.
Code Template: Copy and paste the code below into your IDE. You must complete the upheap and downheap methods.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// --- Heap Implementation ---
class HeapPriorityQueue<K extends Comparable<K>> {
    private ArrayList<K> heap = new ArrayList<>();

    // Helper methods
    protected int parent(int j) { return (j - 1) / 2; }
    protected int left(int j) { return 2 * j + 1; }
    protected int right(int j) { return 2 * j + 2; }

    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }
    
    private void swap(int i, int j) {
        K temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(K key) {
        heap.add(key);
        upheap(heap.size() - 1);
    }

    public K removeMin() {
        if (isEmpty()) return null;
        K answer = heap.get(0);
        // Move last element to root
        K last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0);
        }
        return answer;
    }

    public K min() {
        return isEmpty() ? null : heap.get(0);
    }

    private void upheap(int j) {
        // TODO: While j > 0 and parent > child, swap and move up
    }

    private void downheap(int j) {
        // TODO: While j has left child...
        // Find smaller child, swap if child < parent, move down
    }
}

// --- HeapSort Driver ---
public class HeapSorter {
    public static void heapSort(Integer[] arr) {
        // Assuming we are sorting the array elements (Keys) themselves
        HeapPriorityQueue<Integer> pq = new HeapPriorityQueue<>();
        
        // Phase 1: Insert (Construction)
        for (Integer x : arr) {
            pq.insert(x);
        }
        
        // Phase 2: Remove (Sorting)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.removeMin();
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[10];
        Random rand = new Random();
        for (int i=0; i<data.length; i++) data[i] = rand.nextInt(100);
        
        System.out.println("Before Sorting: " + Arrays.toString(data));
        heapSort(data);
        System.out.println("After Sorting:  " + Arrays.toString(data));
    }
}
