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
        SeparateChainingMap<Integer, String> map = new SeparateChainingMap<>();

        System.out.println("Testing SeparateChainingMap:");
        System.out.println("put(5, A): " + map.put(5, "A"));
        System.out.println("put(7, B): " + map.put(7, "B"));
        System.out.println("put(2, C): " + map.put(2, "C"));
        System.out.println("get(7): " + map.get(7));
        System.out.println("get(99): " + map.get(99));
        System.out.println("remove(5): " + map.remove(5));
    }
}
