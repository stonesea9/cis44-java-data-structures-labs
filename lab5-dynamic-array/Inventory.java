import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void display() {
        if (items.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        for (Item item : items) {
            System.out.println("- " + item);
        }
    }

    public void combineItems(String name1, String name2) {
        boolean removed1 = false;
        boolean removed2 = false;

        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();

            if (!removed1 && current.getName().equals(name1)) {
                iter.remove();
                removed1 = true;
            } else if (!removed2 && current.getName().equals(name2)) {
                iter.remove();
                removed2 = true;
            }

            if (removed1 && removed2) break;
        }

        if (removed1 && removed2) {
            String combinedName = name1 + " + " + name2; // or "Magic Staff"
            items.add(new Item(combinedName));
            System.out.println("Combined \"" + name1 + "\" and \"" + name2 + "\" into \"" + combinedName + "\".");
        } else {

            if (removed1) items.add(new Item(name1));
            if (removed2) items.add(new Item(name2));
            System.out.println("Combine failed: missing one or both items.");
        }
    }
}
