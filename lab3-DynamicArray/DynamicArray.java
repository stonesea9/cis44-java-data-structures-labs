
public class DynamicArray<T> {

    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
  
    public DynamicArray() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }
    public int length() {
        return data.length;
    }
  
  
    public void add(T element) {
        if (size == data.length) {
            resize();
        }
        data[size] = element;
        size++;
    }

  
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
    /**
     * Removes the element at the specified index and shifts subsequent elements left.
     * @param index index of element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public T remove(int index) {
        checkIndex(index);

        T removed = data[index];

        // Shift elements left to fill the gap
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        // Clear last element reference (avoid loitering)
        data[size - 1] = null;
        size--;

        return removed;
    }

    /**
     * Returns the number of elements currently in the list.
     * @return current size
     */
    public int size() {
        return size;
    }

    /**
     * Doubles the capacity of the internal array and copies elements over.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = data.length * 2;
        T[] newData = (T[]) new Object[newCapacity];

        // Copy elements
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    /**
     * Helper method: checks whether index is within [0, size - 1].
     * @param index index to validate
     * @throws IndexOutOfBoundsException if invalid
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }
}
