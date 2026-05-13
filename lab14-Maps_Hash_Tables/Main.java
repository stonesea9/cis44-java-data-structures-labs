/*public class Main {
    public static void main(String[] args) {
        UnsortedListMap<Integer, String> map = new UnsortedListMap<>();

        System.out.println("put(5, A): " + map.put(5, "A"));
        System.out.println("put(7, B): " + map.put(7, "B"));
        System.out.println("put(2, C): " + map.put(2, "C"));
        System.out.println("put(2, E): " + map.put(2, "E"));
        System.out.println("get(7): " + map.get(7));
        System.out.println("remove(5): " + map.remove(5));
    }
}
*/
public class Main {
    public static void main(String[] args) {
        testUnsortedListMap();
        System.out.println();
        testSeparateChainingMap();
    }

    public static void testUnsortedListMap() {
        UnsortedListMap<Integer, String> map = new UnsortedListMap<>();

        System.out.println("Testing UnsortedListMap:");
        System.out.println("put(5, A): " + map.put(5, "A"));
        System.out.println("put(7, B): " + map.put(7, "B"));
        System.out.println("put(2, C): " + map.put(2, "C"));
        System.out.println("put(2, E): " + map.put(2, "E"));
        System.out.println("get(7): " + map.get(7));
        System.out.println("remove(5): " + map.remove(5));
    }

    public static void testSeparateChainingMap() {
        SeparateChainingMap<String, String> map = new SeparateChainingMap<>();

        System.out.println("Testing SeparateChainingMap with collision handling:");
        System.out.println();

        System.out.println("put(AA, Patient A): " + map.put("AA", "Patient A"));
        System.out.println("put(AL, Patient B): " + map.put("AL", "Patient B"));
        System.out.println("put(AW, Patient C): " + map.put("AW", "Patient C"));

        System.out.println();

        System.out.println("get(AA): " + map.get("AA"));
        System.out.println("get(AL): " + map.get("AL"));
        System.out.println("get(AW): " + map.get("AW"));

        System.out.println();

        System.out.println("put(AL, Updated Patient B): " + map.put("AL", "Updated Patient B"));
        System.out.println("get(AL): " + map.get("AL"));

        System.out.println();

        System.out.println("remove(AA): " + map.remove("AA"));
        System.out.println("get(AA): " + map.get("AA"));
        System.out.println("size(): " + map.size());

        System.out.println();

        System.out.println("Collision test completed.");
    }
}
