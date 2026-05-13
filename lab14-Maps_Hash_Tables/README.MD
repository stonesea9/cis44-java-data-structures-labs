Project 1: Unsorted List Map (K, V)
Objective: Implement a basic Map ADT using an unsorted ArrayList to store key-value Entry objects. This implementation serves to demonstrate the $O(n)$ time complexity of search and insertion in a non-optimized map structure. [Image of Big O notation chart comparing O(1), O(log n), and O(n) complexity curves]

Requirements:

Create a generic Entry<K, V> class to hold the Key and Value.
The UnsortedListMap must use a java.util.ArrayList internally to store Entry objects.
The time complexity of get(k), put(k, v), and remove(k) are all $O(n)$ due to linear searching for the key.
Code Template: Copy and paste the code below into your IDE. You must complete the put(K key, V value) method. It must check for an existing key, update the value if found, or append a new entry if not found.

import java.util.ArrayList;

// --- 1. Entry ADT ---
class Entry<K, V> {
    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
    public V setValue(V value) { 
        V old = this.value;
        this.value = value;
        return old;
    }
}

// --- 2. Common Map Interface ---
interface MapADT<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
}

// --- 3. Implementation: Unsorted List Map ---
class UnsortedListMap<K, V> implements MapADT<K, V> {
    private ArrayList<Entry<K, V>> list = new ArrayList<>();
    private int findEntryIndex(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    
    public V get(K key) {
        int i = findEntryIndex(key);
        return (i != -1) ? list.get(i).getValue() : null;
    }
    
    public V remove(K key) {
        int i = findEntryIndex(key);
        if (i != -1) {
            V oldValue = list.get(i).getValue();
            list.remove(i); 
            return oldValue;
        }
        return null;
    }
    
    // TODO: Complete this method (O(n))
    public V put(K key, V value) {
        // 1. Search for existing key.
         
        
        // 2. If found, update the value and return the old value.
        
        
        // 3. If not found, add a new entry and return null.
        
    }
}
