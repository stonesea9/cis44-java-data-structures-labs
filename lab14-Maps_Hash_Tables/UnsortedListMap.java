import java.util.ArrayList;

// --- 1. Entry ADT ---
class Entry<K, V> {
    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

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
public class UnsortedListMap<K, V> implements MapADT<K, V> {
    private ArrayList<Entry<K, V>> list = new ArrayList<>();

    private int findEntryIndex(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public V get(K key) {
        int i = findEntryIndex(key);

        if (i != -1) {
            return list.get(i).getValue();
        }

        return null;
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

    // Complete this method: O(n)
    public V put(K key, V value) {
        int i = findEntryIndex(key);

        // If the key already exists, update the value and return old value.
        if (i != -1) {
            return list.get(i).setValue(value);
        }

        // If the key does not exist, add a new entry and return null.
        list.add(new Entry<>(key, value));
        return null;
    }
}
