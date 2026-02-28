public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.addItem(new Item("Item1"));
        inv.addItem(new Item("Item2"));
        inv.addItem(new Item("Item3"));

        System.out.println("Inventory BEFORE:");
        inv.display();

        System.out.println();
        inv.combineItems("Item2", "Item1");

        System.out.println();
        System.out.println("Inventory AFTER:");
        inv.display();
    }
}
